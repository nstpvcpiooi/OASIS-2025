public class CheckingAccount extends Account {

    /** .*/
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /** .*/
    @Override
    public void withdraw(double amount) {
        try {
            Transaction transaction = new Transaction(Transaction.TYPE_WITHDRAW_CHECKING,
                    amount, balance, balance - amount);
            doWithdrawing(amount);
            addTransaction(transaction);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }

    /** .*/
    @Override
    public void deposit(double amount) {
        try {
            Transaction transaction = new Transaction(Transaction.TYPE_DEPOSIT_CHECKING,
                    amount, balance, balance + amount);
            doDepositing(amount);
            addTransaction(transaction);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }
}
