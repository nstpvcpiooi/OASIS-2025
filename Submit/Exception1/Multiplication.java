public class Multiplication extends BinaryExpression {
    /**
     * Constructor.
     */
    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * To string.
     */
    @Override
    public String toString() {
        return "(" + left.toString() + " * " + right.toString() + ")";
    }

    /**
     * Evaluate.
     */
    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }
}
