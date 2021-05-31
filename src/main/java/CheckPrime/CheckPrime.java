package main.java.CheckPrime;

public class CheckPrime {
    static boolean isPrime(int n) {
        //special cases, need to handle them separately
        if (n <= 1) {
            return false;
        }


        //for (int i = 2; i <= n-1; i++) { //naive implementation
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //test some primes
        System.out.println(2 + " is prime?: " + isPrime(2));
        System.out.println(13 + " is prime?: " + isPrime(13));
        System.out.println(997 + " is prime?: " + isPrime(997));
        System.out.println(10007 + " is prime?: " + isPrime(10007));

        //also some non-primes
        System.out.println(0 + " is prime?: " + isPrime(0));
        System.out.println(1 + " is prime?: " + isPrime(1));
        System.out.println(6 + " is prime?: " + isPrime(6));
        System.out.println(10003 + " is prime?: " + isPrime(10003));

    }
}
