public class Square extends Expression {
    private Expression expression;

    /**
     * Constructor.
     */
    public Square(Expression expression) {
        this.expression = expression;
    }

    /**
     * To string.
     */
    @Override
    public String toString() {
        return "(" + expression.toString() + ") ^ 2";
    }

    /**
     * Evaluate.
     */
    @Override
    public double evaluate() {
        return Math.pow(expression.evaluate(), 2);
    }
}
