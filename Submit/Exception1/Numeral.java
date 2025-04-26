public class Numeral extends Expression {
    private double value;

    /**
     * Constructor.
     */
    public Numeral() {
        this.value = 0;
    }

    /**
     * Constructor.
     */
    public Numeral(double value) {
        this.value = value;
    }

    /**
     * To string.
     */
    @Override
    public String toString() {
        return (int) value + "";
    }

    /**
     * Evaluate.
     */
    @Override
    public double evaluate() {
        return value;
    }
}
