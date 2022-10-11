import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Baek_GameMaker {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for(int idx = 0; idx < N; ++idx) stack.add(Integer.parseInt(br.readLine()));
		
		int score = stack.pop();
		int answer = 0;
		
		while(!stack.isEmpty()) {
			if(stack.peek() >= score) {
				answer += stack.peek() - (score - 1);
				--score; 
			}
			else score = stack.peek();
			stack.pop();
		}
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
		
	}

}
