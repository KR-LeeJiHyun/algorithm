import java.util.Stack;

public class Pro_StockPrice {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		solution(prices);
	}
    public static int[] solution(int[] prices) {
    	final int len = prices.length;
    	int[] answer = new int[len];
        for(int idx = len - 2; idx >= 0; --idx) {
    		for(int sIdx = idx + 1; sIdx < len; ++sIdx) {
    			if(prices[idx] == prices[sIdx]) {
    				answer[idx] += answer[sIdx] + 1;
    				break;
    			}
    			else if(prices[idx] < prices[sIdx]) ++answer[idx] ;
    			else {
    				++answer[idx] ;
    				break;
    			}
    		}
        }
    		return answer;
        //초기 풀이
    	/*for(int idx = len - 2; idx >= 0; --idx) {
    		int cnt = 0;
    		for(int sIdx = idx + 1; sIdx < len; ++sIdx) {
    			if(prices[idx] == prices[sIdx]) {
    				answer[idx] = answer[sIdx] + 1;
    				break;
    			}
    			else if(prices[idx] < prices[sIdx]) ++cnt;
    			else {
    				++cnt;
    				break;
    			}
    		}
    		answer[idx] += cnt;
    	}*/
    	//스택 풀이
    	/*Stack<Integer> stack = new Stack<>();
    	
    	for(int idx = 0; idx < len; ++idx) {
    		while(!stack.isEmpty() && prices[idx] < prices[stack.peek()]) {
    			int peek = stack.pop();
    			answer[peek] = idx - peek;
    		}
    		stack.push(idx);
    	}
    	
		while(!stack.isEmpty()) {
			int peek = stack.pop();
			answer[peek] = len - peek - 1;
		}*/

    	
    }
}
