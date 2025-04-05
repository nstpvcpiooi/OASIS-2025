public class Circle extends Shape {
    protected double radius;
    protected Point center;

    /** Constructor. */
    public Circle(double radius) {
        this.radius = radius;
    }

    /** Constructor. */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    /** Constructor. */
    public Circle(Point center, double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
        this.center = center;
    }

    /** Getter. */
    public Point getCenter() {
        return center;
    }

    /** Setter. */
    public void setCenter(Point center) {
        this.center = center;
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
        return "Circle[" + "center=" + center.toString() + ","
                + "radius=" + radius + ",color=" + color + ",filled=" + filled + ']';
    }

    /** Equals. */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Circle) {
            Circle c = (Circle) o;
            return this.radius == c.getRadius()
                    && this.center.equals(c.getCenter());
        }
        return false;
    }

    /** Hash code. */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(radius, center);
    }
}
