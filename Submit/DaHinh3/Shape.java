import java.awt.*;

public abstract class Shape {
    protected  Color color;
    protected boolean filled;
    protected int x, y, size;
    protected int velocityX, velocityY;

    /** Constructor. */
    public Shape() {}

    /** Constructor. */
    public Shape(Color color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    /** Constructor. */
    public Shape(int x, int y, int size, Color color, int velocityX, int velocityY) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    /** Getter. */
    public String getColor() {
        return color.toString();
    }

    /** Setter. */
    public void setColor(Color color) {
        this.color = color;
    }

    /** Getter. */
    public boolean isFilled() {
        return filled;
    }

    /** Setter. */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /** Area. */
    public abstract double getArea();

    /** Perimeter. */
    public abstract double getPerimeter();

    /** String. */
    public String toString() {
        return "Shape[color=" + color + ",filled=" + filled + "]";
    }

    /** Abstract method for movement.*/
    public abstract void move();

    /** Abstract method for drawing. */
    public abstract void draw(Graphics g);

    /** Method to check if a shape hits the window borders. */
    public void checkBoundary(int width, int height) {
        if (x <= 0 || x + size >= width) velocityX = -velocityX;
        if (y <= 0 || y + size >= height) velocityY = -velocityY;
    }
}
