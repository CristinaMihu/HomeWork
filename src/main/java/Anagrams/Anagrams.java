package main.java.Anagrams;

import java.util.Arrays;

public class Anagrams {
    static boolean anagrams(String s1, String s2) {
        return sortedLetters(s1)
                .equals(sortedLetters(s2));
    }

    private static String sortedLetters(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    /**
     * Some manual tests:
     */
    public static void main(String[] args) {
        System.out.println("AbcaBd - sorted letters are: " + sortedLetters("AbcaBd"));

        checkAnagrams("", "");
        checkAnagrams("A", "a");
        checkAnagrams("binary", "brainy");
        checkAnagrams("Listen", "Silent");
        checkAnagrams("anagram", "nagaram");

        checkAnagrams("ab", "ac");
        checkAnagrams("Aa", "a");
        checkAnagrams("anagram", "angrm");
    }

//    helper method for testing
    private static void checkAnagrams(String s1, String s2) {
        System.out.println("'" + s1 + "' and '" + s2 + "' are anagrams? : " + anagrams(s1, s2));
    }
}
