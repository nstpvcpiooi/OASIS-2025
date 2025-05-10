import java.util.List;

public abstract class Account {
    public static final String SAVINGS = "SAVINGS";
    public static final String CHECKING = "CHECKING";

    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new java.util.ArrayList<>();

    /** .*/
    public Account() {
        accountNumber = 0;
        balance = 0;
    }

    /** .*/
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /** .*/
    public long getAccountNumber() {
        return accountNumber;
    }

    /** .*/
    public double getBalance() {
        return balance;
    }

    /** .*/
    public void doWithdrawing(double amount) throws BankException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else if (amount > balance) {
            throw new InsufficientFundsException(amount);
        } else {
            balance -= amount;
        }

    }

    /** .*/
    public void doDepositing(double amount) throws BankException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else {
            balance += amount;
        }
    }

    /** .*/
    public abstract void withdraw(double amount);

    /** .*/
    public abstract void deposit(double amount);

    /** .*/
    public String getTransactionHistory() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lịch sử giao dịch của tài khoản ").append(accountNumber).append(":\n");
        for (Transaction transaction : transactionList) {
            sb.append(transaction.getTransactionSummary()).append("\n");
        }
        return sb.toString();
    }

    /** .*/
    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    /** .*/
    public boolean equals(Object obj) {
        if (obj instanceof Account) {
            Account account = (Account) obj;
            return accountNumber == account.accountNumber;
        }
        return false;
    }
}
