import java.util.HashMap;

public class Pro할인행사 {

	public static void main(String[] args) {
		String[] wnat = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3, 2, 2, 2, 1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
		Pro할인행사 S = new Pro할인행사();
		S.solution(wnat, number, discount);

	}
	
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        final int CNT = 10;
        final int LEN = want.length;
        
        HashMap<String, Integer> wants = new HashMap<>();
        int[] discounts = new int[LEN];
        for(int idx = 0; idx < LEN; ++idx) {
        	wants.put(want[idx], idx);
        }
        
        for(int idx = 0; idx < discount.length; ++idx) {
        	if(idx >= CNT) {
        		int pIdx = idx - CNT;
        		String prev = discount[pIdx];
            	if(wants.containsKey(prev)) {
            		--discounts[wants.get(prev)];
            	}
        	}
        	String product = discount[idx];
        	if(wants.containsKey(product)) {
        		++discounts[wants.get(product)];
        	}
        	if(isSame(number, discounts)) {
        		++answer;
        	}
        }
        
        return answer;
    }

	private boolean isSame(int[] number, int[] discounts) {
		for(int idx = 0; idx < number.length; ++idx) {
			if(discounts[idx] != number[idx]) {
				return false;
			}
		}
		return true;
	}

}
