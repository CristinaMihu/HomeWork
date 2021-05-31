package main.java.FilterArray;

import java.util.Arrays;

public class FilterArray {
    static int[] onlyOdd(int[] array) {

        //Step 1: copy only the odd values ones to a temp array
        int[] tmp = new int[array.length];

        int i = 0;
        for (int d : array) {
            if (d % 2 == 1) {
                tmp[i] = d;
                i++;
            }
        }

        //Step 2: the temp array has the right values, but it may be too large (has extra 0 values at the end)
        //        so copy only the useful part of temp array to new smaller array to return

        /*
        //a) Manual copy (you should know how to do this too):
        int[] res = new int[i];       //create a new smaller array, as we know the right size for it now (value of i after finishing previous for loop)
        for (int j = 0; j < i; j++) { //copy elements form pos 0..(i-1) from tmp to new smaller res array, using a new index j
            res[j] = tmp[j];
        }
        return res;
        */

        //b) OR: can do the partial copy of an array contents using Arrays.copyOf:
        return Arrays.copyOf(tmp, i);
    }

//    Manual testing
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        onlyOdd(new int[]{1, 2, 3, 4, 5})));
    }
}
