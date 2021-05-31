package main.java.Hangman;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class Hangman {
    private static final String WORDS_FILE = "top500_cautari_cuvinte_romanesti.csv";

    /**
     * Starting point for the game.
     */
    public static void main(String[] args) throws IOException {

        Difficulty dif = chooseDifficulty();
        List<String> words = loadWordsForDifficulty(dif);

        do {

            playOneGame(words, dif);

        } while (userWantsToContinue());
    }

    /**
     * Reads difficulty level from the user, returns it as an enum value
     */
    private static Difficulty chooseDifficulty() {
        char option = readOption("Difficulty level - Easy/Medium/Hard ?", "E/M/H");
        Difficulty dif = Difficulty.startingWith(option);
        System.out.println("Difficulty level: " + dif);
        return dif;
    }

    /**
     * Helper method for reading user input. It displays a message and a list
     * of possible options and keeps reading user input until the user
     * enters one of the allowed choices (letters)
     */
    private static char readOption(String message, String options) {
        System.out.println(message + " (" + options + "): ");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String in = sc.next().toUpperCase();
            if (in.length() == 1 && options.contains(in.charAt(0) + "")) {
                return in.charAt(0);
            }
        }
    }

    /**
     * Shows user a confirmation message for continue game, returns answer as a boolean
     */
    private static boolean userWantsToContinue() {
        return readOption("\nContinue with another game?", "Y/N") == 'Y';
    }

    private static List<String> loadWordsForDifficulty(Difficulty dif) throws IOException {
        List<String> words = loadAllWordsFromFile();
        return filterWordsByDifficulty(words, dif);
    }

    private static List<String> loadAllWordsFromFile() throws IOException {
        File dictionary = new File(WORDS_FILE);
        List<String> allWords = Files.readAllLines(dictionary.toPath());
        System.out.println("Load dictionary, found " + allWords.size() + " words.");
        return allWords;
    }

    private static List<String> filterWordsByDifficulty(List<String> words, Difficulty dif) {

        List<String> filtered = words.stream()
                .filter(word -> word.length() >= dif.minLen && word.length() <= dif.maxLen)
                .collect(toList());

        System.out.println("Will consider only words with length between " + dif.minLen + " and " + dif.maxLen
                + " => using " + filtered.size() + " words (out of the total of " + words.size() + ")");

        return filtered;
    }

    /**
     * Starting method for playing 1 game
     *
     * @param words list of words from which to choose (already filtered by difficulty)
     * @param dif   difficulty setting (needed for other logic, like computing allowed attempts)
     */
    private static void playOneGame(List<String> words, Difficulty dif) {

        String word = words.get(new Random().nextInt(words.size())); //choose random word

        List<Character> masked = maskAllLettersExcept2(word); //build its masked form

        //initialize some game progress variables
        long attemptsLeft = initAttemptsLeft(word, dif);
        Set<Character> alreadyTried = new TreeSet<>();

        //enter game loop
        while (!isGameOver(masked, attemptsLeft, word)) {

            System.out.println("\nWord to guess: " + masked + " (attempts left: " + attemptsLeft + ")");

            char letter = readLetter(alreadyTried);

            if (!unmaskIfGuessed(letter, masked, word)) {
                System.out.println("Wrong guess, word doesn't contain '" + letter + "'");
                alreadyTried.add(letter);
                attemptsLeft--;
            }
        }
    }

    private static List<Character> maskAllLettersExcept2(String word) {
        List<Character> masked = word.chars().mapToObj(c -> '_').collect(toList());

        //choose 2 different letters to unmask (not necessarily the first and last)
        Random random = new Random();
        char c1 = word.charAt(random.nextInt(word.length()));
        char c2 = c1;
        while (c2 == c1) { //should be different letters, not the same one in different positions in word
            c2 = word.charAt(random.nextInt(word.length()));
        }

        //unmask them using the regular method for this (like the user had guessed them)
        unmaskIfGuessed(c1, masked, word);
        unmaskIfGuessed(c2, masked, word);

        return masked;
    }

    /**
     * Compute attempts left based on word and difficulty, as:
     * - the number of unique letters remaining to be guessed (removing the 2 already displayed)
     * - also adding some extra attempts for Easy or Medium difficulty
     */
    private static long initAttemptsLeft(String word, Difficulty dif) {
        long attemptsLeft = word.chars().distinct().count() - 2;
        if (dif == Difficulty.EASY) {
            attemptsLeft += 2;
        } else if (dif == Difficulty.MEDIUM) {
            attemptsLeft += 1;
        }
        return attemptsLeft;
    }

    private static boolean isGameOver(List<Character> masked, long attemptsLeft, String word) {
        if (!masked.contains('_')) {
            System.out.println("\nYOU WON! You guessed all letters! Bravo!");
            System.out.println("Word was: " + word);
            return true;
        } else if (attemptsLeft == 0) {
            System.out.println("\nYOU LOST - no attempts left.");
            System.out.println("Word was: " + word);
            return true;
        }
        return false;
    }

    /**
     * Reads a letter guess from the user. Displays the already tried letters,
     * and keeps reading until user specifies a new letter (not tried)
     */
    private static char readLetter(Set<Character> alreadyTried) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a letter (in a..z, different from: " + alreadyTried + "): ");
            String in = sc.next().toLowerCase();
            if (in.length() == 1) {
                char first = in.charAt(0);
                if (first >= 'a' && first <= 'z' && !alreadyTried.contains(first)) {
                    return first;
                }
            }
        }
    }

    /**
     * Unmasks a new letter from the masked word
     */
    private static boolean unmaskIfGuessed(char guessedLetter, List<Character> masked, String original) {
        boolean found = false;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == guessedLetter) {
                masked.set(i, guessedLetter);
                found = true;
            }
        }
        return found;
    }


    /**
     * Enum to represent the difficulty level of the game (user choices)
     */
    enum Difficulty {

        EASY(3, 5),
        MEDIUM(6, 8),
        HARD(9, 30);

        //the min/max word length for each difficulty level
        final int minLen;
        final int maxLen;

        Difficulty(int minLen, int maxLen) {
            this.minLen = minLen;
            this.maxLen = maxLen;
        }

        static Difficulty startingWith(char c) {
            for (Difficulty dif : values()) {
                if (dif.name().startsWith((c + "").toUpperCase())) {
                    return dif;
                }
            }
            return null;
        }
    }
}
