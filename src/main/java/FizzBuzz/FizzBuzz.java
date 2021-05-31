package main.java.FizzBuzz;

class FizzBuzz {

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.println(i + " => " + fizzBuzz(i));
        }
    }

    static String fizzBuzz(int i) {
        if (i % 15 == 0) {
            return "fizzbuzz";
        }
        if (i % 3 == 0) {
            return "fizz";
        }
        if (i % 5 == 0) {
            return "buzz";
        }
        return String.valueOf(i);
    }

    static void printAllFizzBuzzUpTo(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                System.out.println(i + "fizzbuzz");
            }
        }
    }
}

