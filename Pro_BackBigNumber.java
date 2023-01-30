import java.util.Arrays;
import java.util.Stack;

public class Pro_BackBigNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[] solution(int[] numbers) {
    	final int LEN = numbers.length;
        int[] answer = new int[LEN];
        Stack<Integer> stack = new Stack<>();
    
        
        Arrays.fill(answer, -1);
        for(int idx = LEN - 1; idx > -1; --idx) {
        	while(!stack.isEmpty() && stack.peek() <= numbers[idx]) {
        		stack.pop();
        	}
        	if(!stack.isEmpty()) answer[idx] = stack.peek();
        	stack.add(numbers[idx]);
        }
        
        return answer;
    }

}
