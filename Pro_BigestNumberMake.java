import java.util.Stack;

public class Pro_BigestNumberMake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("1924", 2);
	}
	
    public static String solution(String number, int k) {
    	char[] answer = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();
        int tmpK = k;
        
        for(char tmp : number.toCharArray()) {
        	while(!stack.isEmpty() && k != 0) {
        		if(tmp > stack.peek()) {
        			stack.pop();
        			--k;
        		}
        		else break;
        	}
        	stack.add(tmp);
        }
                
        for(int idx = 0; idx < number.length() - tmpK; ++idx) answer[idx] = stack.get(idx);
        return new String(answer);
    }
}
