import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Baek후위표기식 {
	
	static class Operator {
		char op;
		int group;
		
		Operator(char op, int group) {
			this.op = op;
			this.group = group;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		StringBuilder answer = new StringBuilder();
		int len = input.length();
		int group = 0;
		Stack<Operator> stack = new Stack();
		
		
		for(int idx = 0; idx < len; ++idx) {
			char c = input.charAt(idx);
			if('A' <= c && c <= 'Z') {
				answer.append(c);
			}
			else if(c == '(') {
				++group;
			}
			else if(c == ')') {
				while(!stack.isEmpty() && stack.peek().group == group) {
					answer.append(stack.pop().op);
				}
				--group;
			}
			else if(c == '*') {
				while(!stack.isEmpty() && stack.peek().group == group && stack.peek().op != '+' && stack.peek().op != '-') {
					answer.append(stack.pop().op);
				}
				stack.add(new Operator(c, group));
			}
			
			else if(c == '/') {
				while(!stack.isEmpty() && stack.peek().group == group && stack.peek().op != '+' && stack.peek().op != '-') {
					answer.append(stack.pop().op);
				}
				stack.add(new Operator(c, group));
			}
			
			else if(c == '+') {
				while(!stack.isEmpty() && stack.peek().group == group) {
					answer.append(stack.pop().op);
				}
				stack.add(new Operator(c, group));
			}
			else {
				while(!stack.isEmpty() && stack.peek().group == group) {
					answer.append(stack.pop().op);
				}
				stack.add(new Operator(c, group));
			}
		}
		
		while(!stack.isEmpty()) {
			answer.append(stack.pop().op);
		}
		
		bw.write(answer.toString());
		br.close();
		bw.close();
		
	}

}
