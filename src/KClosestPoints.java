import java.util.*;

class Point {
	double x;
	double y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

public class KClosestPoints {
	public Point[] getKNearestPoints(Point[] points, int k) {
		// write your code here
		if(points.length <= k)
			return points;
		if(k == 0)
			return new Point[0];
		Point[] ret = new Point[k];
		PriorityQueue<Point> queue = new PriorityQueue(points.length,new Comparator<Point>(){
			@Override
			 public int compare(Point p1, Point p2) {
                return (int) ((p2.x * p2.x + p2.y * p2.y)
                        - (p1.x * p1.x + p1.y * p1.y));
            }
		});
		for(int i = 0; i < points.length; i++)
		{
			if(queue.size() < k)
				queue.add(points[i]);
			else
			{
				Point tmp = queue.peek();
				if(points[i].y * points[i].y + points[i].x * points[i].x < tmp.y * tmp.y + tmp.x * tmp.x)
				{
					queue.poll();
					queue.offer(points[i]);
				}
			}
		
		}
		int index = 0;
		while(!queue.isEmpty())
		{
			if(queue.peek() != null)
			{
				ret[index] = queue.poll();
				index++;
			}
			
		}
		return ret;
	}
	private double getDistance(Point a, Point b) {
	    return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
	}
	public static void main(String[] argc) {
		KClosestPoints s = new KClosestPoints();
		
		// Test case 1
		Point[] test1 = new Point[5];
		test1[0] = new Point(0, 1);
		test1[1] = new Point(7, 8);
		test1[2] = new Point(2, 6);
		test1[3] = new Point(3, 7);
		test1[4] = new Point(-2, 8);
		Point[] results = s.getKNearestPoints(test1, 3);
		if(results[0] == test1[3] && results[1] == test1[2] && results[2] == test1[0]) {
			System.out.println("test case 1 correct!");
		} else {
			System.out.println("test case 1 wrong!");
		}
		// s.print(results);
		
		// Test case 2
		Point[] test2 = new Point[4];
		test2[0] = new Point(0, 4);
		test2[1] = new Point(4, 0);
		test2[2] = new Point(0, -4);
		test2[3] = new Point(-4, 0);
		results = s.getKNearestPoints(test2, 3);
		if(results[0] == test2[3] && results[1] == test2[2] && results[2] == test2[1]) {
			System.out.println("test case 2 correct!");
		} else {
			System.out.println("test case 2 wrong!");
		}
		// s.print(results);
		
		// Test case 3
		Point[] test3 = new Point[3];
		test3[0] = new Point(0, 4);
		test3[1] = new Point(0, 2);
		test3[2] = new Point(0, 1);
		results = s.getKNearestPoints(test3, 5);
		if(results[0] == test3[0] && results[1] == test3[1] && results[2] == test3[2]) {
			System.out.println("test case 3 correct!");
		} else {
			System.out.println("test case 3 wrong!");
		}
		// s.print(results);
		
		// Test case 4
		Point[] test4 = new Point[0];
		results = s.getKNearestPoints(test4, 8);
		if(results.length == 0) {
			System.out.println("test case 4 correct!");
		} else {
			System.out.println("test case 4 wrong!");
		}
		// s.print(results);
		
		// Test case 5
		Point[] test5 = new Point[2];
		test5[0] = new Point(0, 1);
		test5[1] = new Point(1, 0);
		results = s.getKNearestPoints(test5, 0);
		if(results.length == 0) {
			System.out.println("test case 5 correct!");
		} else {
			System.out.println("test case 5 wrong!");
		}
		// s.print(results);
		
//		// Test case 6
//		Point[] test6 = new Point[3];
//		test6[0] = new Point(Double.MIN_VALUE, Double.MAX_VALUE);
//		test6[1] = new Point(Double.MIN_VALUE, Double.MIN_VALUE);
//		test6[1] = new Point(Double.MAX_VALUE, Double.MAX_VALUE);
//		results = s.getKNearestPoints(test5, 2);
//		if(results[0] == test6[0] && results[1] == test6[1]) {
//			System.out.println("test case 6 correct!");
//		} else {
//			System.out.println("test case 6 wrong!");
//		}
//		// s.print(results);
		
	}
	
//	private void print(Point[] ps) {
//		for(Point p : ps) {
//			System.out.println("[x: " + p.x + " y: " + p.y + "]");
//		}
//		System.out.println("Done!");
//	}
}
