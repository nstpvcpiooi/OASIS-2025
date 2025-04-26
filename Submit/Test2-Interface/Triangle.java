public class Triangle implements GeometricObject {
    private Point p1;
    private Point p2;
    private Point p3;

    /** Constructor.
     *
     * @param p1 first point of the triangle.
     * @param p2 second point of the triangle.
     * @param p3 third point of the triangle.
     */
    public Triangle(Point p1, Point p2, Point p3) {
        if (p1.equals(p2) || p2.equals(p3) || p3.equals(p1)) {
            throw new RuntimeException("Diem trung nhau");
        } else if (p1.distance(p2) + p2.distance(p3) <= p3.distance(p1)
                || p2.distance(p3) + p3.distance(p1) <= p1.distance(p2)
                || p3.distance(p1) + p1.distance(p2) <= p2.distance(p3)) {
            throw new RuntimeException("Diem thang hang");
        } else {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
        }
    }

    /** Gets the first point of the triangle.
     *
     * @return the first point of the triangle.
     */
    public Point getP1() {
        return p1;
    }

    /** Gets the second point of the triangle.
     *
     * @return the second point of the triangle.
     */
    public Point getP2() {
        return p2;
    }

    /** Gets the third point of the triangle.
     *
     * @return the third point of the triangle.
     */
    public Point getP3() {
        return p3;
    }

    /** Gets the area of the triangle.
     *
     * @return the area of the triangle.
     */
    public double getArea() {
        double a = p1.distance(p2);
        double b = p2.distance(p3);
        double c = p3.distance(p1);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    /** Gets the perimeter of the triangle.
     *
     * @return the perimeter of the triangle.
     */
    public double getPerimeter() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    /** Gets the string representation of the triangle.
     *
     * @return the string representation of the triangle.
     */
    public String getInfo() {
        return "Triangle[(" + String.format("%.2f", p1.getPointX())
                + "," + String.format("%.2f", p1.getPointY())
                + "),(" + String.format("%.2f", p2.getPointX())
                + "," + String.format("%.2f", p2.getPointY())
                + "),(" + String.format("%.2f", p3.getPointX())
                + "," + String.format("%.2f", p3.getPointY())
                + ")]";
    }
}
