

/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new SlopeOrder(this);       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    private static class SlopeOrder implements Comparator<Point> {

    	private Point point0;
    	
		public SlopeOrder(Point point) {
			point0 = point;
		}
		@Override
		public int compare(Point p1, Point p2) {
			double p1Slope = point0.slopeTo(p1);
			double p2Slope = point0.slopeTo(p2);
			return (int) (p1Slope - p2Slope);
		}
    	
    }
    private boolean samePosition(Point that) {
    	return this.x == that.x && this.y == that.y;
    }
    
    // slope between this point and that point
    public double slopeTo(Point that) {
    	if (this.samePosition(that)) return Double.NEGATIVE_INFINITY;
    	else if(this.x == that.x) return Double.POSITIVE_INFINITY;
    	else if(this.y == that.y) return 0;
        return ((double)this.y - that.y)/(this.x - that.x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        if (this.y == that.y) return this.x - that.x;
        else return this.y - that.y;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}
