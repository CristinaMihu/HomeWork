package main.java.DecimalToBinary;

public class DecimalToBinary {
    static String decimalToBinary(int n) {

        String binNumber = "";
        do {
            int reminder = n % 2; //compute a new binary digit, as the reminder of dividing number by 2 (-> an int value, either 0 or 1)
            n = n / 2;            //reduce size of original number (divide it by 2)

            binNumber = reminder + binNumber; //append each reminder to the front (left side) of binary number (String)

        } while (n > 0); //until decimal number gets to 0

        return binNumber;
    }

    /**
     * Aici logica a fost compresata la maxim, intr-o singura expresie ternara.
     */
    static String decimalToBinary2(int n) {
        return n <= 1 ? String.valueOf(n) : decimalToBinary(n / 2) + n % 2;
    }

    /**
     * Manual testing
     */
    public static void main(String[] args) {
        System.out.println(decimalToBinary(0));
        System.out.println(decimalToBinary(1));
        System.out.println(decimalToBinary(2));
        System.out.println(decimalToBinary(3));
        System.out.println(decimalToBinary2(4));
        System.out.println(decimalToBinary2(10));
    }
}
