public class Circle implements GeometricObject {
    public static final double PI = 3.14;
    private double radius;
    private Point center;

    /** Constructor.
     *
     * @param center center of the circle.
     * @param radius radius of the circle.
     */
    public Circle(Point center, double radius) {
        this.radius = radius;
        this.center = center;
    }

    /** Gets the radius of the circle.
     *
     * @return the radius of the circle.
     */
    public double getRadius() {
        return radius;
    }

    /** Sets the radius of the circle.
     *
     * @param radius the radius of the circle.
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /** Gets the center of the circle.
     *
     * @return the center of the circle.
     */
    public Point getCenter() {
        return center;
    }

    /** Sets the center of the circle.
     *
     * @param center the center of the circle.
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /** Gets the area of the circle.
     *
     * @return the area of the circle.
     */
    public double getArea() {
        return PI * radius * radius;
    }

    /** Gets the perimeter of the circle.
     *
     * @return the perimeter of the circle.
     */
    public double getPerimeter() {
        return 2 * PI * radius;
    }

    /** Gets the string representation of the circle.
     *
     * @return the string representation of the circle.
     */
    public String getInfo() {
        return "Circle[(" + String.format("%.2f", center.getPointX())
                + "," + String.format("%.2f", center.getPointY())
                + "),r=" + String.format("%.2f", radius) + "]";
    }
}
