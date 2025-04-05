public abstract class Shape {
    protected  String color;
    protected boolean filled;

    /** Constructor. */
    public Shape() {}

    /** Constructor. */
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    /** Getter. */
    public String getColor() {
        return color;
    }

    /** Setter. */
    public void setColor(String color) {
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
}
