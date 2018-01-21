import java.lang.Math;

public class Point {

    /**
     * X-Coordinate of the point
     */
    final private double x;

    /**
     * Y-Coordinate of the point
     */
    final private double y;

    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x-coordinate of the point
     */
    public double getX () {
        return this.x;
    }

    /**
     * @return the y-coordinate of the point
     */
    public double getY () {
        return this.y;
    }

    /**
     * Calculates the euclidian distance from this point to point p
     * @param  p Point to calculate distance to
     * @return   Distance from this point to point p
     */
    public double distanceTo (Point p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }

    /**
     * Creates a string representation of the point in a (x,y) format
     * @return a string representation of the point
     */
    public String toString () {
        return String.format("(%f,%f)", this.x, this.y);
    }
}
