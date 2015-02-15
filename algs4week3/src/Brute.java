import java.lang.reflect.Array;
import java.util.Arrays;

public class Brute {
	public static void main(String[] args){
        In in = new In(args[0]);      // input file
        int N = in.readInt();         // total N points
        
        Point[] points = new Point[N];
        int[][] results = new int[N][2];
        int x, y;
        int index = 0;
        int indexR = 0;
        while (!in.isEmpty()) {
        	x = in.readInt();
        	y = in.readInt();
        	points[index++] = new Point(x, y);
        }
        
        Arrays.sort(points);
        for (int i = 0; i < points.length - 3; i++) {
        	for (int j = i + 1; j < points.length - 2; j++) {
        		for (int k = j + 1; k < points.length - 1; k++) {
        			if (points[i].slopeTo(points[j]) == points[j].slopeTo(points[k])) {
        				for (int n = k + 1; n < points.length; n++) {
        					if (points[j].slopeTo(points[k]) == points[k].slopeTo(points[n])) {
        						results[indexR][0] = i;
        						results[indexR++][1] = n;
        					}
        				}
        			} 
        		}
        	}
        }
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for(int[] result: results) {
        	points[result[0]].drawTo(points[result[1]]);
        }
        // display to screen all at once
        StdDraw.show(0);
	}
}
