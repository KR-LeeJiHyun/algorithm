import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Baek히스토그램 {
	
	static class Point {
		int b;
		int h;
		
		public Point(int b, int h) {
			this.b = b;
			this.h = h;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        int N = Integer.parseInt(br.readLine());
        int h = Integer.parseInt(br.readLine());
        int answer = 0;
        Stack<Point> stack = new Stack<>();
        stack.add(new Point(0, -1));
        stack.add(new Point(1, h));
        
        for(int idx = 2; idx <= N; ++idx) {
        	h = Integer.parseInt(br.readLine());
        	while(stack.peek().h > h) {
        		Point current = stack.pop();
        		answer = Math.max(answer, current.h * (idx - 1 - stack.peek().b));
        	}
        	while(stack.peek().h == h) stack.pop();
        	stack.add(new Point(idx, h));
        }
        
        while(stack.size() > 1) {
        	Point current = stack.pop();
        	answer = Math.max(answer, current.h * (N - stack.peek().b));
    	}

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
	}

}
