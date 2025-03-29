public class Circle {
    private double radius;
    private String color;

    /** Constructor. */
    public Circle() {}

    /** Constructor. */
    public Circle(double radius) {
        this.radius = radius;
    }

    /** Constructor. */
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    /** Get Radius. */
    public double getRadius() {
        return radius;
    }

    /** Set Radius. */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /** Get Color. */
    public String getColor() {
        return color;
    }

    /** Set Color. */
    public void setColor(String color) {
        this.color = color;
    }

    /** Area. */
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /** To String. */
    public String toString() {
        return "Circle[radius=" + this.radius + ",color=" + this.color + "]";
    }
}
