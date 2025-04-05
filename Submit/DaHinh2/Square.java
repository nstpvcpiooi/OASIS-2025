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
     * Constructor.
     */
    public Square(Point topLeft, double side, String color, boolean filled) {
        super(topLeft, side, side, color, filled);
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
        return "Square[" + "topLeft=" + topLeft.toString()
                + ",side=" + width + ",color=" + color + ",filled=" + filled + ']';
    }

    /**
     * Equals.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Square) {
            Square newSquare = (Square) o;
            return this.width == newSquare.getSide();
        }
        return false;
    }

}
