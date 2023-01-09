import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Baek_TrueBracket {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T > 0) {
			--T;
			Stack<Character> stack = new Stack<Character>();
			String input = br.readLine();
			for(int idx = 0; idx < input.length(); ++idx) {
				char c = input.charAt(idx);
				if(c == '(') stack.add(input.charAt(idx));
				else if(!stack.isEmpty() && c == ')') stack.pop();
				else {
					stack.add('N');
					break;
				}
			}
			
			if(stack.isEmpty()) sb.append("YES\n");
			else sb.append("NO\n");
			
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
		
	}

}
