package main.java.FirstPowerAbove;

public class FirstPowerAbove {
    static double firstPowerAbove(double base, double limit) {

        //version1: with manual operations, reusing the previous computed value when computing each new power (optimal)
        int i = 0;
        double pow = 1;
        while (pow <= limit) {
            pow *= base;
            i++;
            System.out.println(base + " to power of " + i + " is: " + pow);
        }
        System.out.println("First power of " + base + " above limit " + limit + " is: " + pow + " (" + base + "^" + i + ")");
        return pow;


        //version2: less efficient, as it calls Math.pow() at every step, which takes more time/operations;
        //but simple and it seems more precise for fractional numbers! (but no difference for integer numbers)
        /*
        double pow = 0;
        for (int i = 0; pow <= limit; i++) {
            pow = Math.pow(base, i);
            System.out.println(base + " to power of " + i + " is: " + pow);
        }
        System.out.println("First power of " + base + " above limit " + limit + " is: " + pow);
        return pow;
        */
    }

    public static void main(String[] args) {
        System.out.println(firstPowerAbove(2, 30));   //=> 32,   as: 2^5   = 32   > 30
        System.out.println(firstPowerAbove(2, 1000)); //=> 1024, as: 2^10  = 1024 > 1000
        System.out.println(firstPowerAbove(7, 0.1));  //=> 1,    as: 7^0   = 1    > 0.1
        System.out.println(firstPowerAbove(1.5, 2));  //=> 2.25, as: 1.5^2 = 2.25 > 2
    }
}
