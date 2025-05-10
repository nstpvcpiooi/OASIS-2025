public class InvalidFundingAmountException extends BankException {

    /** .*/
    public InvalidFundingAmountException(String message) {
        super(message);
    }

    /** .*/
    public InvalidFundingAmountException(double amount) {
        super(String.format("Số tiền không hợp lệ: $%.2f", amount));
    }
}
