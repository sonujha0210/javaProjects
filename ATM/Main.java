import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an object of the AtmOperationImpl class, which implements AtmOperationInterf
        AtmOperationInterf op = new AtmOperationImpl();

        // Predefined ATM number and PIN (used for authentication)
        int atmnumber = 12345;
        int atmpin = 123;

        // Create a Scanner object for reading user input
        Scanner in = new Scanner(System.in);

        // Display welcome message
        System.out.println("Welcome to ATM Machine !!!");

        // Ask for ATM number input from the user
        System.out.print("Enter Atm Number : ");
        int atmNumber = in.nextInt();

        // Ask for PIN input from the user
        System.out.print("Enter Pin: ");
        int pin = in.nextInt();

        // Validate the entered ATM number and PIN
        if ((atmnumber == atmNumber) && (atmpin == pin)) {
            // If authentication is successful, enter a loop to perform ATM operations
            while (true) {
                // Display the available options for the user
                System.out.println("1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View Ministatement\n5.Exit");
                System.out.println("Enter Choice : ");
                int ch = in.nextInt(); // Read the user's choice

                // Perform the corresponding action based on the user's choice
                if (ch == 1) {
                    // View the available balance
                    op.viewBalance();
                }
                else if (ch == 2) {
                    // Ask the user for the amount to withdraw
                    System.out.println("Enter amount to withdraw ");
                    double withdrawAmount = in.nextDouble(); // Read the withdraw amount
                    op.withdrawAmount(withdrawAmount); // Call the method to withdraw amount
                }
                else if (ch == 3) {
                    // Ask the user for the amount to deposit
                    System.out.println("Enter Amount to Deposit :");
                    double depositAmount = in.nextDouble(); // Read the deposit amount
                    op.depositAmount(depositAmount); // Call the method to deposit amount
                }
                else if (ch == 4) {
                    // View the mini statement (list of recent transactions)
                    op.viewMiniStatement();
                }
                else if (ch == 5) {
                    // Exit the program after showing the final message
                    System.out.println("Collect your ATM Card\n Thank you for using ATM Machine!!");
                    System.exit(0); // Exit the program
                }
                else {
                    // If the user enters an invalid choice, display an error message
                    System.out.println("Please enter correct choice");
                }
            }
        } else {
            // If the entered ATM number or PIN is incorrect, display an error message and exit
            System.out.println("Incorrect Atm Number or pin");
            System.exit(0); // Exit the program
        }
    }
}
