public class SavingsAccount extends Account {

    /** .*/
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /** .*/
    @Override
    public void withdraw(double amount) {
        try {
            if (amount > 1000) {
                throw new BankException("Giao dich khong hop le");
            }
            if (getBalance() < 5000) {
                throw new BankException("So du khong du");
            }
            Transaction transaction = new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS,
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
            Transaction transaction = new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS,
                    amount, balance, balance + amount);
            doDepositing(amount);
            addTransaction(transaction);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }

}
