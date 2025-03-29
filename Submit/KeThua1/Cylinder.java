public class Cylinder extends Circle {
    private double height;

    /** Constructor. */
    public Cylinder() {
        super();
    }

    /** Constructor. */
    public Cylinder(double height) {
        super();
        this.height = height;
    }

    /** Constructor. */
    public Cylinder(double height, double radius) {
        super(radius);
        this.height = height;
    }

    /** Constructor. */
    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    /** Get Height. */
    public double getHeight() {
        return height;
    }

    /** Set Height. */
    public void setHeight(double height) {
        this.height = height;
    }

    /** Get Volume. */
    public double getVolume() {
        return height * super.getArea();
    }

    /** Get Area. */
    public double getArea() {
        return super.getArea() * 2 + height * Math.PI * super.getRadius() * 2;
    }

    /** To String. */
    public String toString() {
        return super.toString();
    }
}
