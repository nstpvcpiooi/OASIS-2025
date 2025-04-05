import java.awt.*;

public class Rectangle extends Shape {
    protected double width;
    protected double length;
    protected Point topLeft;

    /** Constructor. */
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /** Constructor. */
    public Rectangle(double width, double length, Color color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    /** Constructor. */
    public Rectangle(Point topLeft, double width, double length, Color color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
        this.topLeft = topLeft;
    }

    /** Constructor. */
    public Rectangle(int x, int y, int size, Color color, int velocityX, int velocityY,
                     double width, double length) {
        super(x, y, size, color, velocityX, velocityY);
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
    public Point getTopLeft() {
        return topLeft;
    }

    /** Setter. */
    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
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
        return "Rectangle[" + "topLeft=" + topLeft.toString()
                + ",width=" + width + ",length=" + length
                + ",color=" + getColor() + ",filled=" + filled + ']';
    }

    @Override
    public void move() {
        x += velocityX;
        y += velocityY;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }

    /** Equals. */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Rectangle) {
            Rectangle r = (Rectangle) o;
            return this.width == r.getWidth()
                    && this.length == r.getLength()
                    && this.color.equals(r.getColor())
                    && this.filled == r.isFilled();
        }
        return false;
    }

    /** Hash code. */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(width, length, color, filled);
    }
}
