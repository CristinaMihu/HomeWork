package main.java.ConsecutiveRepeats;

public class ConsecutiveRepeats {
      /*
    //A naive solution - doesn't work ok on all cases
    static String onlyConsecutiveRepeating(int[] numbers) {
        String s = "";
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) s += numbers[i] + " ";
        }
        return s;
    }
    */


    /**
     * A solution working correctly on all cases
     */
    static String onlyConsecutiveRepeating2(int[] numbers) {
        String out = "";

        int i = 0;
        while (i < numbers.length) {

            //assume a new repeating sequence starts at index i
            int repeatingSeqStartValue = numbers[i];

            //go to next number, to check if this is really a repeating sequence
            i++;
            if (i < numbers.length && numbers[i] == repeatingSeqStartValue) {  //we still have valid indices AND value repeats
                out += numbers[i] + " ";                                       //add the value to result
            }

            //repeat this to skip over all the elements in repeating sequence (but without adding them to output)
            while (i < numbers.length && numbers[i] == repeatingSeqStartValue) {
                i++;
            }
        }

        return out;
    }


    /**
     * Alternative solution (with minimal repeating code, and maybe clearer/easier to understand)
     */
    static String onlyConsecutiveRepeating(int[] numbers) {
        String out = "";

        boolean sequenceInProgress = false; //flag which signals if we are currently (at index i) inside a repeating sequence or not
        for (int i = 0; i < numbers.length - 1; i++) {

            //consecutive numbers are equal -> check if this is the start of a new sequence (adding the repeating value to result in this case)
            if (numbers[i] == numbers[i + 1]) {
                if (!sequenceInProgress) {      //if not currently in a sequence
                    sequenceInProgress = true;  //the mark we are in a new sequence now...
                    out += numbers[i] + " ";    //...and save the sequence number to the output (just once, now when we detected its start)
                }
            } else { //consecutive numbers differ -> mark the current sequence as ended (if any was in progress)
                sequenceInProgress = false;
            }
        }

        return out;
    }


    public static void main(String[] args) {
        System.out.println(onlyConsecutiveRepeating(new int[]{}));                                            //expected: ''
        System.out.println(onlyConsecutiveRepeating(new int[]{1, 1}));                                        //expected: '1'
        System.out.println(onlyConsecutiveRepeating(new int[]{1, 1, 1}));                                     //expected: '1'
        System.out.println(onlyConsecutiveRepeating(new int[]{1, 1, 2, 1, 1}));                               //expected: '1 1'
        System.out.println(onlyConsecutiveRepeating(new int[]{1, 4, 3, 4}));                                  //expected: ''
        System.out.println(onlyConsecutiveRepeating(new int[]{1, 4, 4, 4, 3, 5, 5, 4, 4}));                   //expected: '4 5 4'
        System.out.println(onlyConsecutiveRepeating(new int[]{1, 4, 4, 4, 4, 4, 5, 7, 8, 7, 2, 2, 9, 9, 9})); //expected: '4 2 9'
    }
}
