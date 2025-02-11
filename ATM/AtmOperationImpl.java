import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperationInterf {
    // Create an instance of the ATM class which holds the balance
    ATM atm = new ATM();

    // A map to store the mini statement of the user (withdrawals and deposits)
    Map<Double, String> ministmt = new HashMap<>();

    @Override
    public void viewBalance() {
        // Display the current balance of the ATM
        System.out.println("Available Balance is : " + atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        // Check if the withdrawal amount is in multiples of 500
        if (withdrawAmount % 500 == 0) {
            // If the withdrawal amount is less than or equal to the available balance, proceed with the transaction
            if (withdrawAmount <= atm.getBalance()) {
                // Record the transaction in the mini statement with the corresponding action ("Amount Withdrawn")
                ministmt.put(withdrawAmount, " Amount Withdrawn");
                System.out.println("Collect the Cash " + withdrawAmount);

                // Update the ATM balance after the withdrawal
                atm.setBalance(atm.getBalance() - withdrawAmount);

                // Show the updated balance after withdrawal
                viewBalance();
            } else {
                // If the withdrawal amount exceeds the balance, display an error message
                System.out.println("Insufficient Balance !!");
            }
        } else {
            // If the withdrawal amount is not in multiples of 500, ask the user to enter a valid amount
            System.out.println("Please enter the amount in multiple of 500");
        }
    }

    @Override
    public void depositAmount(double depositAmount) {
        // Record the deposit in the mini statement
        ministmt.put(depositAmount, " Amount Deposited");

        // Display a success message for the deposit
        System.out.println(depositAmount + " Deposited Successfully !!");

        // Update the ATM balance after the deposit
        atm.setBalance(atm.getBalance() + depositAmount);

        // Show the updated balance after deposit
        viewBalance();
    }

    @Override
    public void viewMiniStatement() {
        // Loop through the mini statement and print each transaction (amount and action)
        for (Map.Entry<Double, String> m : ministmt.entrySet()) {
            // Print the amount and the corresponding transaction type (Withdrawn/Deposited)
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}
