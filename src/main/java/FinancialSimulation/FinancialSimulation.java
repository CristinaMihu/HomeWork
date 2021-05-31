package main.java.FinancialSimulation;

public class FinancialSimulation {
    static int simulate(double initial, double interestPct, double target) {

        System.out.printf("\nSimulation started, with parameters: initial: %.2f, interest: %.2f%%, target: %.2f\n",
                initial, interestPct, target);

        double sum = initial;
        int year = 0;

        while (sum < target) {
            year++;
            double interest = sum * (interestPct / 100);
            System.out.printf(" Year %d: amount: %.2f, interest: %.2f => total amount: %.2f \n",
                    year, sum, interest, sum + interest);
            sum += interest;
        }

        System.out.printf("Can happily retire in: %d years!\n", year);
        return year;
    }

    public static void main(String[] args) {
        simulate(1000, 10, 900);
        simulate(1000, 10, 1000);
        simulate(1000, 10, 1100);
        simulate(1000, 10, 1600);

        simulate(1000, 2.5, 1500);
        simulate(1000, 0.1, 1500);
    }
}
