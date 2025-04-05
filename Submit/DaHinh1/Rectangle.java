public class Rectangle extends Shape {
    protected double width;
    protected double length;

    /** Constructor. */
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /** Constructor. */
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    /** Getter. */
    public double getWidth() {
        return width;
    }

    /** Setter. */
    public void setWidth(double width) {
        this.width = width;
    }

    /** Getter. */
    public double getLength() {
        return length;
    }

    /** Setter. */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Area.
     */
    @Override
    public double getArea() {
        return width * length;
    }

    /**
     * Perimeter.
     */
    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    /** String. */
    @Override
    public String toString() {
        return "Rectangle[" + "width=" + width + ",length="
                + length + ",color=" + color + ",filled=" + filled + ']';
    }
}
