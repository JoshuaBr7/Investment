import java.util.Scanner;

public class Deposit {

    //Global Variable
    private static Scanner input = new Scanner(System.in);

    public static void displayBanner() {
        System.out.print("Welcome to the Investment Banker!\n");
    }

    public static double getFutureValue() {
        System.out.print("Enter how much money would you like to accumulate: ");
        return input.nextDouble();
    }

    public static double getInterestRate() {
        System.out.print("Enter the interest rate (between 0 and 1): ");
        double interest = input.nextDouble();
        return (interest > 0 && interest < 1) ? interest : 0;
    }

    public static int getNumberOfYears() {
        System.out.print("Enter the number of years the money will be left in the bank: ");
        int years = input.nextInt();
        return (years > 0) ? years : 0;
    }

    public static double calculatePresentValue(double futureVal, double interestRate, int numOfYears) {
        return ( futureVal / Math.pow((1 + interestRate), numOfYears) );
    }

    public static void displayResults(double futureVal, double interestRate, int numOfYears, double presentVal) {
        System.out.printf("To achieve %,.2f in %d year(s) at an interest rate of %.2f%%, a deposit of $%,.2f is required.",
                            futureVal, numOfYears, (interestRate*100), presentVal);
    }

    public static void main(String[] args) {
        //Main Formula: PresentVal = FutureVal/(1 + InterestRate)^numberOfYears

        //Local Variables
        double futureInvestment;
        double interestRate;
        int numberOfYears;
        double presentValue;

        //Introduce the firm.
        displayBanner();

        //Ask for the future value they want to get.
        futureInvestment = getFutureValue();

        //Ask what is the interest rate. Keep looping and asking if they give invalid answer.
        interestRate = getInterestRate();
        while (interestRate == 0) {
            System.out.println("\nPlease enter correct value\n");
            interestRate = getInterestRate();
        }

        //Ask the user to enter years.  If they give incorrect value, loop until they give correct value.
        numberOfYears = getNumberOfYears();
        while (numberOfYears == 0) {
            System.out.println("\nPlease enter correct value\n");
            numberOfYears = getNumberOfYears();
        }

        //Calculate the person's future investment value.
        presentValue = calculatePresentValue(futureInvestment, interestRate, numberOfYears);

        //Display results
        displayResults(futureInvestment, interestRate, numberOfYears, presentValue);

    }
}
