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

    /**
     * Creates a new point object modeling a point in 2-D space.
     * @param  x the x-coordinate in the 2-D space
     * @param  y the y-coordinate in the 2-D space
     * @return   the new point object
     */
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
     * Calculates which quadrant the point lies in.
     * The return value will be in the range [1,4]
     * @return the quadrant in which the point is in
     */
    public int quadrant () {
        if (this.x >= 0 && this.y >= 0) return 1;
        else if (this.x <= 0 && this.y >= 0) return 2;
        else if (this.x <= 0 && this.y <= 0) return 3;
        else return 4;
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
     * Returns the dot product of this and point p
     * @param  p The point to perform the dot product with
     * @return   the dot product of this and p
     */
    public double dotProduct (Point p) {
        return (this.x * p.x) + (this.y * p.y);
    }

    /**
     * Returns a new point with coordinates equal to component-wise subtraction with
     * this point as starting reference.
     * @param  p the point to subtract this with
     * @return   a new point with coordinates equal to component-wise subtraction
     */
    public Point minus (Point p) {
        return new Point(this.x - p.x, this.y - p.y);
    }

    /**
     * Creates a string representation of the point in a (x,y) format
     * @return a string representation of the point
     */
    public String toString () {
        return String.format("(%f,%f)", this.x, this.y);
    }
}
