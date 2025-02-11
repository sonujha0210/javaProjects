public class ATM {
    // Declare private variables to store balance, deposit amount, and withdrawal amount
    private double balance;
    private double depositAmount;
    private double withdrawAmount;

    // Default constructor: Initializes the ATM object without any parameters.
    public ATM() {
        // The default constructor does not initialize the balance, depositAmount, or withdrawAmount.
    }

    // Getter method for balance: Returns the current balance in the ATM.
    public double getBalance() {
        return balance;
    }

    // Setter method for balance: Allows setting the balance of the ATM.
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Getter method for depositAmount: Returns the deposit amount.
    public double getDepositAmount() {
        return depositAmount;
    }

    // Setter method for depositAmount: Allows setting the deposit amount.
    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    // Getter method for withdrawAmount: Returns the withdrawal amount.
    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    // Setter method for withdrawAmount: Allows setting the withdrawal amount.
    public void setWithdrawAmount(double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }
}
