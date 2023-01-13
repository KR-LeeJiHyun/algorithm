import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Baek_StringReverse {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String S = br.readLine();
		Stack<Character> stack = new Stack<>();
		StringBuilder answer = new StringBuilder();
		boolean r = true;
		for(int idx = 0; idx < S.length(); ++idx) {
			char c = S.charAt(idx);
			if(c == '<') {
				r = false;
				while(!stack.isEmpty()) answer.append(stack.pop());
				answer.append(c);
			}
			else if(c == '>') {
				r = true;
				answer.append(c);
			}
			else if(c == ' ') {
				while(!stack.isEmpty()) answer.append(stack.pop());
				answer.append(c);
			}
			else {
				if(r) stack.add(c);
				else answer.append(c);
			}
		}
		
		while(!stack.isEmpty()) answer.append(stack.pop());

		bw.write(answer.toString());
		br.close();
		bw.close();
		
	}

}
