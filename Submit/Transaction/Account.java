import java.util.Objects;

public class Account {
    private double balance;
    private java.util.ArrayList<Transaction> transitionList = new java.util.ArrayList<>();

    /** Deposit.*/
    private void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /** Withdraw.*/
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > this.balance) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else {
            this.balance -= amount;
        }
    }

    /** Add transaction.*/
    public void addTransaction(double amount, String operation) {
        double previous = this.balance;
        if (Objects.equals(operation, Transaction.DEPOSIT)) {
            this.deposit(amount);
            if (previous != this.balance) {
                Transaction tmp = new Transaction(Transaction.DEPOSIT, amount, this.balance);
                transitionList.add(tmp);
            }
        } else if (Objects.equals(operation, Transaction.WITHDRAW)) {
            this.withdraw(amount);
            if (previous != this.balance) {
                Transaction tmp = new Transaction(Transaction.WITHDRAW, amount, this.balance);
                transitionList.add(tmp);
            }
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /** Print transaction.*/
    public void printTransaction() {
        for (Transaction t : transitionList) {
            String operation = t.getOperation();
            String a = String.format("%.2f", t.getAmount());
            String b = String.format("%.2f", t.getBalance());
            System.out.print("Giao dich " + (transitionList.indexOf(t) + 1) + ": ");
            if (operation.equals(Transaction.DEPOSIT)) {
                System.out.println("Nap tien $" + a + ". So du luc nay: $" + b + ".");
            } else {
                System.out.println("Rut tien $" + a + ". So du luc nay: $" + b + ".");
            }
        }
    }
}
