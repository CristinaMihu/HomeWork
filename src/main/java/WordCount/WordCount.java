package main.java.WordCount;

public class WordCount {
    static int wordCount(String phrase) {

        /*
        //basic solution:
        int count = 0;
        for (String s : phrase.split(" ")) {
            if (!s.trim().isEmpty())
                count++;
        }
        return count;
        */

        //shorter, with regex
        return phrase.trim().isEmpty() ?
                0 :
                phrase.trim().split("\\s+").length;

        //return (int) Arrays.stream(phrase.split("\\s+")).filter(s -> !s.isEmpty()).count();
    }

    //some manual tests
    public static void main(String[] args) {
        testIt("");
        testIt("abc");
        testIt("aa bb");
        testIt("aa  bb");
        testIt("  ");
        testIt(" aa  bb");
        testIt("aa bb  cc  ");
    }

    //helper method for manual tests
    private static void testIt(String phrase) {
        System.out.println("wordCount('" + phrase + "') = " + wordCount(phrase));
    }
}
