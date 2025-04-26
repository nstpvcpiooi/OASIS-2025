public class Division extends BinaryExpression {
    /**
     * Constructor.
     */
    public Division(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * To string.
     */
    @Override
    public String toString() {
        return "(" + left.toString() + " / " + right.toString() + ")";
    }

    /**
     * Evaluate.
     */
    @Override
    public double evaluate() {
        if (right.evaluate() == 0) {
            throw new ArithmeticException("Lỗi chia cho 0");
        } else {
            return left.evaluate() / right.evaluate();
        }
    }
}
