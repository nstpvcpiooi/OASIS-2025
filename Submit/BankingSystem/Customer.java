import java.util.List;

public class Customer {
    long idNumber;
    String fullName;
    private List<Account> accountList = new java.util.ArrayList<>();

    /** .*/
    public Customer() {
        idNumber = 0;
        fullName = "";
    }

    /** .*/
    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    /** .*/
    public String getCustomerInfo() {
        return String.format("Số CMND: %d. Họ tên: %s.", idNumber, fullName);
    }

    /** .*/
    public void addAccount(Account account) {

        for (Account acc : accountList) {
            if (acc.equals(account)) {
                acc = account;
                return;
            }
        }
        accountList.add(account);
    }

    /** .*/
    public void removeAccount(Account account) {
        for (Account acc : accountList) {
            if (acc.equals(account)) {
                accountList.remove(acc);
                return;
            }
        }
    }

    /** .*/
    public long getIdNumber() {
        return idNumber;
    }

    /** .*/
    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    /** .*/
    public String getFullName() {
        return fullName;
    }

    /** .*/
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /** .*/
    public List<Account> getAccountList() {
        return accountList;
    }


}
