public class Circle extends Shape {
    protected double radius;

    /** Constructor. */
    public Circle(double radius) {
        this.radius = radius;
    }

    /** Constructor. */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    /** Getter. */
    public double getRadius() {
        return radius;
    }

    /** Setter. */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Area.
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Perimeter.
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /** String. */
    @Override
    public String toString() {
        return "Circle[" + "radius=" + radius + ",color=" + color + ",filled=" + filled + ']';
    }
}
