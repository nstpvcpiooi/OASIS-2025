import java.io.InputStream;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private final List<Customer> customerList = new java.util.ArrayList<>();

    /** .*/
    public void readCustomerList(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        String line = null;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            String[] customerInfo = line.split(" ");

            if (!Character.isDigit(customerInfo[0].charAt(0))) {
                String fullName = "";
                long idNumber = 0;
                for (String s : customerInfo) {
                    if (Character.isDigit(s.charAt(0))) {
                        idNumber = Long.parseLong(s);
                    } else {
                        if (fullName.isEmpty()) {
                            fullName += s;
                        } else {
                            fullName += " " + s;
                        }
                    }
                }

                Customer customer = new Customer(idNumber, fullName);
                customerList.add(customer);
            } else {
                long accountNumber = Long.parseLong(customerInfo[0]);
                double balance = Double.parseDouble(customerInfo[2]);
                if (customerInfo[1].equals(Account.CHECKING)) {
                    CheckingAccount checkingAccount = new CheckingAccount(accountNumber, balance);
                    customerList.get(customerList.size() - 1).addAccount(checkingAccount);

                } else if (customerInfo[1].equals(Account.SAVINGS)) {
                    SavingsAccount savingsAccount = new SavingsAccount(accountNumber, balance);
                    customerList.get(customerList.size() - 1).addAccount(savingsAccount);
                } else {
                    System.out.println("Invalid account type");
                }
            }
        }
    }

    /** .*/
    public String getCustomersInfoByNameOrder() {
        List<Customer> sortedList = getCustomerList();
        sortedList.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }
        });

        return getCustomerInfo(sortedList);
    }

    /** .*/
    public String getCustomersInfoByIdOrder() {
        List<Customer> sortedList = getCustomerList();
        sortedList.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return Long.compare(o1.getIdNumber(), o2.getIdNumber());
            }
        });

        return getCustomerInfo(sortedList);
    }

    /** .*/
    public List<Customer> getCustomerList() {
        return customerList;
    }

    /** .*/
    private String getCustomerInfo(List<Customer> list) {
        String result = "";
        for (Customer customer : list) {
            if (result.isEmpty()) {
                result += customer.getCustomerInfo();
            } else {
                result += "\n" + customer.getCustomerInfo();
            }
        }
        return result;
    }

}
