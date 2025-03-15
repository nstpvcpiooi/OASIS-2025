public class Transaction {
    private String operation;
    private double amount;
    private double balance;
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    /** Constructor.*/
    public Transaction(String operation, double amount, double balance) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    /** Get operation.*/
    public String getOperation() {
        return operation;
    }

    /** Set operation.*/
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /** Get amount.*/
    public double getAmount() {
        return amount;
    }

    /** Set amount.*/
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /** Get balance.*/
    public double getBalance() {
        return balance;
    }

    /** Set balance.*/
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
