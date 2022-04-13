import java.util.Stack;
public class Pro_CorrectBracket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int idx = 0; idx < s.length(); ++idx) {
        	char c = s.charAt(idx);
        	if(c == ')') {
        		if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
        		else return false;
        	}
        	else stack.add(c);
        }

        return stack.isEmpty();
    }

}
