package main.java.Collections.Josephus;

import java.util.ArrayList;
import java.util.List;

public class Josephus {
    /**
     * @return the number of the last remaining soldier
     */
    static int eliminate(int total, int step) {
        System.out.println("\nTotal soldiers: " + total + ", will eliminate them with step: " + step);

        //populate initial list
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= total; i++) {
            list.add(i);
        }

        int idx = 0; //start counting from 1st

        //start killing
        while (list.size() > 1) {
            //compute the index of next to be removed (with roll over at the end of list)
            idx = (idx - 1 + step) % list.size();

            int numberToRemove = list.get(idx);
            System.out.println(list + " => " + numberToRemove);
            list.remove(idx);
        }
        int remaining = list.get(0);

        System.out.println("Last standing: " + remaining);
        return remaining;
    }


    /**
     * Some manual tests
     */
    public static void main(String[] args) {
        eliminate(1, 1);
        eliminate(3, 1);
        eliminate(5, 2);
        eliminate(5, 3);
        eliminate(5, 7);
        eliminate(10, 3);
    }
}
