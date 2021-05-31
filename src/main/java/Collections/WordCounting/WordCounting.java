package main.java.Collections.WordCounting;

import java.util.*;

public class WordCounting {

    //some manual tests
    public static void main(String[] args) {

        String text = "Once upon a time in a land far far away there lived a great king whose name was a great mystery";
        System.out.println("initial text: " + text);

        System.out.println("\nall words (initial order): " + words(text));
        System.out.println("word count: " + wordsCount(text));
        System.out.println("all words (sorted): " + sortedWords(text));
        System.out.println("distinct words (initial order): " + distinctWords(text));
        System.out.println("distinct words (sorted): " + distinctSortedWords(text));

        System.out.println("\nword counts (initial order): " + wordsUsageCount(text));
        System.out.println("word counts (sorted by word): " + wordsUsageCountSortedByWord(text));
        System.out.println("word counts (sorted by count, then word): " + wordsUsageCountSortedByCountThenWord(text));
    }

    static List<String> words(String text) {
        if (text.trim().isEmpty()) {
            return new ArrayList<>();
        }
        String[] wordsArr = text.trim().split("\\s+");
        return Arrays.asList(wordsArr);
    }

    static int wordsCount(String text) {
        List<String> list = words(text);
        return list.size();
    }

    static Collection<String> sortedWords(String text) {
        List<String> list = words(text);
        Collections.sort(list);
        return list;
    }

    static Collection<String> distinctWords(String text) {
        List<String> list = words(text);
        /*Set<String> distinctWords = new LinkedHashSet<>();
        distinctWords.addAll(list);*/
        return new LinkedHashSet<>(list);
    }

    static Collection<String> distinctSortedWords(String text) {
        List<String> list = words(text);
        return new TreeSet<>(list);
    }

    static Map<String, Long> wordsUsageCount(String text) {
        List<String> list = words(text);
        Map<String, Long> map = new HashMap<>();

        for (String word : list) {
            //version 1:
            /*
            if (map.containsKey(word)) {
                int oldCount = map.get(word);
                map.put(word, oldCount + 1); //update
            } else {
                map.put(word, 1); //insert
            }
            */

            //version 2:
            long oldCount = map.getOrDefault(word, 0L);
            map.put(word, oldCount + 1);
        }

        return map;
    }

    static Map<String, Long> wordsUsageCountSortedByWord(String text) {

        //Map<String, Long> badMap = wordsUsageCount(text); //not sorted
        /*for (String key : temp.keySet()) {
            Integer value = temp.get(key);
            map.put(key, value);
        }*/

        //treeMap.putAll(badMap);

        return new TreeMap<>(wordsUsageCount(text));
    }

    static List<Map.Entry<String, Long>> wordsUsageCountSortedByCountThenWord(String text) {
        Map<String, Long> badMap = wordsUsageCount(text);

        Set<Map.Entry<String, Long>> setOfAllPairs = badMap.entrySet();

        List<Map.Entry<String, Long>> listOfAllPairs = new ArrayList<>(setOfAllPairs);

        return listOfAllPairs;
    }
}
