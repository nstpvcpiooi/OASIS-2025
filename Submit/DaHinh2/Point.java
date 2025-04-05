public class Point {
    private double pointX;
    private double pointY;

    /** Constructor. */
    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    /** Getter. */
    public double getPointX() {
        return pointX;
    }

    /** Setter. */
    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    /** Getter. */
    public double getPointY() {
        return pointY;
    }

    /** Setter. */
    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    /** Distance. */
    public double distance(Point p) {
        return Math.sqrt(Math.pow(p.getPointX() - this.pointX, 2)
                + Math.pow(p.getPointY() - this.pointY, 2));
    }

    /** Equals. */
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point p = (Point) o;
            return this.pointX == p.getPointX()
                    && this.pointY == p.getPointY();
        }
        return false;
    }

    /** String. */
    public String toString() {
        return "(" + this.pointX + "," + this.pointY + ")";
    }

    /** Hash code. */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(pointX, pointY);
    }
}
