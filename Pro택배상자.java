import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Pro택배상자 {

	public static void main(String[] args) {
		int[] order = {4, 3, 1, 2, 5};
		Pro택배상자 S = new Pro택배상자();
		S.solution(order);
	}
	
	
    public int solution(int[] order) {
        int answer = 0;
        final int LEN = order.length;
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int idx = 1; idx <= LEN; ++idx) {
        	q.add(idx);
        }
        
        int idx = 0;
        while(idx < LEN) {
        	if(!q.isEmpty() && q.peek() == order[idx]) {
        		++idx;
        		q.poll();
        		++answer;
        	}
        	else if(!stack.isEmpty() && stack.peek() == order[idx]) {
        		++idx;
        		stack.pop();
        		++answer;
        	}
        	else {
        		if(q.isEmpty()) {
        			break;
        		}else {
        			stack.push(q.poll());
        		}
        	}
        }
        
        return answer;
    }

}
