package main.java.Fibonacci;

import java.util.Arrays;

public class Fibonacci {

    //version1: recursive - short & simple, mirrors the math definition;
    //but quite inefficient, complexity is: O(2^n) !
    static int fibonacci_v1(int n) {
        return n <= 1 ?
                n :
                fibonacci_v1(n - 1) + fibonacci_v1(n - 2);
    }

    //version1: simple, calls fibonacci repeatedly, but even more inefficient: n*O(2^n)
    static int[] fibonacciSequence_v1(int n) {
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = fibonacci_v1(i);
        }
        return seq;
    }


    //version2: iterative - more complex, but much more efficient, complexity is: O(n)
    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int f1 = 0;
        int f2 = 1;
        for (int i = 2; i <= n; i++) {
            int sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        return f2;
    }

    //version2: iterative - short/nice and quite efficient, complexity is: O(n)
    static int[] fibonacciSequence(int n) {
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = i <= 1 ?
                    i :
                    seq[i - 1] + seq[i - 2];
        }
        return seq;
    }


//    Some manual tests
    public static void main(String[] args) {
        System.out.println("fibonacci(0) = " + fibonacci(0));
        System.out.println("fibonacci(1) = " + fibonacci(1));
        System.out.println("fibonacci(2) = " + fibonacci(2));
        System.out.println("fibonacci(3) = " + fibonacci(3));
        System.out.println("fibonacci(4) = " + fibonacci(4));
        System.out.println("fibonacci(10) = " + fibonacci(10));
        System.out.println("fibonacci(20) = " + fibonacci(20));

        System.out.println("\nfibonacciSequence(0): " + Arrays.toString(fibonacciSequence(0)));
        System.out.println("fibonacciSequence(1): " + Arrays.toString(fibonacciSequence(1)));
        System.out.println("fibonacciSequence(5): " + Arrays.toString(fibonacciSequence(5)));
        System.out.println("fibonacciSequence(25): " + Arrays.toString(fibonacciSequence(25)));
    }
}
