package main.java.NumberGuessing;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    private static final int MAX_ATTEMPTS = 7;

    //for keeping global score
    private static int wins = 0;
    private static int loses = 0;

    /**
     * Starting point, keeps the logic for main multi-game loop.
     * <p>
     * Note that it's short and very readable (you can immediately see what
     * the main logic is), and all the details are hidden in the more detailed
     * method it calls (each of them also having a clear javadoc comment about
     * what it does and returns)
     */
    public static void main(String[] args) {

        do {

            boolean won = playOneGame();

            updateAndDisplayScore(won);

        } while (userWantsToContinue());
    }

    /**
     * Plays only one game, returns true if user won it, false otherwise
     */
    private static boolean playOneGame() {
        int secret = new Random().nextInt(100) + 1;
        System.out.println("I've chosen a random number between 1 and 100. " +
                "Can you guess it? (in " + MAX_ATTEMPTS + " attempts)");

        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        //single game loop
        while (attempts < MAX_ATTEMPTS) {

            attempts++;
            System.out.println("\nGuess " + attempts + "/" + MAX_ATTEMPTS + " : ");

            int guess = sc.nextInt();

            if (guess < secret) {
                System.out.println("My number is HIGHER than that ...");
            } else if (guess > secret) {
                System.out.println("My number is LOWER than that ...");
            } else {
                System.out.println("\nYou guessed it, well done! (in " + attempts + " attempts)");
                return true;
            }
        }

        System.out.println("\nSorry, you didn't guess it, number was: " + secret +
                ". Play again and focus, you can do better that that! :)");
        return false;
    }

    /**
     * Updates score including result of last game, and displays it
     */
    private static void updateAndDisplayScore(boolean wonLastGame) {
        if (wonLastGame) {
            wins++;
        } else {
            loses++;
        }
        System.out.println("\nSCORE: win-lose: " + wins + "-" + loses);
    }

    /**
     * Asks user if he wants to continue, returns result as a boolean value
     */
    private static boolean userWantsToContinue() {
        System.out.println("Play one more game? (Y/N):");
        return new Scanner(System.in).next().toUpperCase().charAt(0) == 'Y';
    }
}
