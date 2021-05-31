package main.java.ReverseArray;

import java.util.Arrays;

public class ReverseArray {

    static String[] reversedCopy(String[] arr) {
        String[] rev = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rev[arr.length - 1 - i] = arr[i];
        }
        return rev;
    }

    static void reverse(String[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            swapPositions(arr, i, arr.length - 1 - i);
        }
    }

    //helper method - swaps the elements at 2 given indices, in an array
    private static void swapPositions(String[] arr, int i, int j) {
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        String[] arr = {"aa", "bb", "cc", "dd", "ee"};
        System.out.println("initial:  " + Arrays.toString(arr));

        System.out.println("a reversed copy: " + Arrays.toString(reversedCopy(arr)));

        System.out.println("initial after making the copy (should be unchanged): " + Arrays.toString(arr));

        reverse(arr);
        System.out.println("initial after reverse(): " + Arrays.toString(arr));
    }
}
