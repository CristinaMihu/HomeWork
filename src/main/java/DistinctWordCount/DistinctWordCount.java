package main.java.DistinctWordCount;

public class DistinctWordCount {
    static String[] splitToWords(String text) {
        return text.trim().length() == 0 ?
                new String[]{} :
                text.trim().split("\\s+");
    }

    static boolean contains(String[] wordsArray, String word) {
        for (String s : wordsArray) {
            if (word.equals(s)) {
                return true;
            }
        }
        return false;
    }

    static int distinctWordCount(String phrase) {
        String[] words = splitToWords(phrase.toLowerCase());

        String[] distinctWords = new String[words.length];
        int distinctCount = 0;
        for (String w : words) {
            if (!contains(distinctWords, w)) {
                distinctWords[distinctCount] = w;
                distinctCount++;
            }
        }
        return distinctCount;
    }

    //some manual tests
    public static void main(String[] args) {
        testIt("");
        testIt("abc");
        testIt("aa bb");
        testIt("aa  bb");
        testIt("  ");
        testIt(" aa  bb");
        testIt(" aa  bb aa");
        testIt("aa Cc bb  AA cc  ");
    }

    //helper method for manual tests
    private static void testIt(String phrase) {
        System.out.println("distinctWordCount('" + phrase + "') = " + distinctWordCount(phrase));
    }
}
