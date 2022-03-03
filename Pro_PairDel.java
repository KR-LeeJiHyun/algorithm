import java.util.Stack;

public class Pro_PairDel {
	
	public static int solution(String s)
    {
        Stack<Character> stack = new Stack<Character>();
        stack.add(s.charAt(0));
        
        for(int idx = 1; idx < s.length(); ++idx) {
        	char tmp = s.charAt(idx);
        	if(!stack.isEmpty() && stack.peek() == tmp) stack.pop();
        	else stack.add(tmp);
        }

        if(stack.isEmpty()) return 1;
        else return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(solution("baabaa"));
	}

}
