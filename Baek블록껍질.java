import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek블록껍질 {
	
	static class Point{
		long x;
		long y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static Point p1 = new Point(40001, 40001);

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];
        for(int idx = 0; idx < N; ++idx) {
        	StringTokenizer input = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(input.nextToken());
        	int y = Integer.parseInt(input.nextToken());
        	points[idx] = new Point(x, y);
        	if(p1.y > y || (p1.y == y && p1.x > x)) {
        		p1 = points[idx]; 
        	}
        }
        
        Arrays.sort(points, new Comparator<Point>() {
        	public int compare(Point p2, Point p3) {
        		int result = ccw(p1, p2, p3);
        		
        		if(result > 0) {
        			return -1;
        		}
        		else if(result < 0) {
        			return 1;
        		}
        		else {
        			long dist1 = dist(p1, p2);
        			long dist2 = dist(p1, p3);
        			return Long.compare(dist1, dist2);
        		}
        	}

			private long dist(Point p1, Point p2) {
				return (long)(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
			}
		});
        
        Stack<Point> stack = new Stack<>();
        stack.add(points[0]);
        stack.add(points[1]);
        for(int idx = 2; idx < N; ++idx) {
        	while(stack.size() > 1 && ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), points[idx]) <= 0) stack.pop();
        	stack.add(points[idx]);
        }
        
        bw.write(String.valueOf(stack.size()));
        br.close();
        bw.close();
	}
	
	private static int ccw(Point p1, Point p2, Point p3) {
		long result = (p1.x*p2.y + p2.x*p3.y + p3.x*p1.y) - (p1.y*p2.x + p2.y*p3.x + p3.y*p1.x);
		if(result > 0) return 1;
		else if(result < 0) return -1;
		return 0;
	}

}


