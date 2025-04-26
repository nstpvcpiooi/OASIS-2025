public abstract class BinaryExpression extends Expression {
    protected Expression left;
    protected Expression right;

    /**
     * Constructor.
     */
    public BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /** To string. */
    @Override
    public String toString() {
        return "";
    }

    /** Evaluate. */
    @Override
    public double evaluate() {
        return 0;
    }
}
