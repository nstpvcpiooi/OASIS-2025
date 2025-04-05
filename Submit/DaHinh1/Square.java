public class Square extends Rectangle {
    /**
     * Constructor.
     */
    public Square(double side) {
        super(side, side);
    }

    /**
     * Constructor.
     */
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    /**
     * Getter.
     */
    public double getSide() {
        return width;
    }

    /**
     * Setter.
     */
    public void setSide(double side) {
        this.width = side;
        this.length = side;
    }

    /**
     * Setter.
     */
    @Override
    public void setLength(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    /**
     * Setter.
     */
    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    /**
     * String.
     */
    @Override
    public String toString() {
        return "Square[" + "side=" + width + ",color=" + color + ",filled=" + filled + ']';
    }

}
