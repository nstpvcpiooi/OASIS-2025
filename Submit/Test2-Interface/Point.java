public class Point {
    private double pointX;
    private double pointY;

    /** Constructor.
     *
     * @param pointX x-coordinate of the point.
     * @param pointY y-coordinate of the point.
     */
    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    /** Gets the x-coordinate of the point.
     *
     * @return the x-coordinate of the point.
     */
    public double getPointX() {
        return pointX;
    }

    /** Sets the x-coordinate of the point.
     *
     * @param pointX the x-coordinate of the point.
     */
    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    /** Gets the y-coordinate of the point.
     *
     * @return the y-coordinate of the point.
     */
    public double getPointY() {
        return pointY;
    }

    /** Sets the y-coordinate of the point.
     *
     * @param pointY the y-coordinate of the point.
     */
    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    /** Gets the distance between this point and another point.
     *
     * @param other the other point.
     * @return the distance between this point and the other point.
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(pointX - other.pointX, 2) + Math.pow(pointY - other.pointY, 2));
    }
}
