import java.util.Stack;

public class Pro_BracketRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(String s) {
        int answer = 0;
        
        for(int idx = 0; idx < s.length(); ++idx) {
        	if(check(s)) ++answer;
        	s = s.substring(1) + s.charAt(0);
        }
        
        return answer;
    }
    
    public boolean check(String s) {
    	Stack<Character> stack = new Stack<>();
    	
    	for(char tmp : s.toCharArray()) {
    		if(!stack.isEmpty()) {
    			if(tmp == ')' && stack.peek() == '(') stack.pop();
    			else if(tmp == '}' && stack.peek() == '{') stack.pop();
    			else if(tmp == ']' && stack.peek() == '[') stack.pop();
    			else stack.push(tmp);
    		}
    		else stack.push(tmp);
    	}
    	
    	if(stack.isEmpty()) return true;
    	return false;
    }

}
