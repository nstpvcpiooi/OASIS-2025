import java.awt.*;

public class Circle extends Shape {
    protected double radius;
    protected Point center;

    /** Constructor. */
    public Circle(double radius) {
        this.radius = radius;
    }

    /** Constructor. */
    public Circle(double radius, Color color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    /** Constructor. */
    public Circle(Point center, double radius, Color color, boolean filled) {
        super(color, filled);
        this.radius = radius;
        this.center = center;
    }

    /** Constructor. */
    public Circle(int x, int y, int size, Color color, int velocityX, int velocityY,
                  double radius) {
        super(x, y, size, color, velocityX, velocityY);
        this.radius = radius;
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
                + "radius=" + radius + ",color=" + getColor() + ",filled=" + filled + ']';
    }

    @Override
    public void move() {
        x += velocityX;
        y += velocityY;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
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
