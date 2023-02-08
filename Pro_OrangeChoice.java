import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Pro_OrangeChoice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap();
        for(int t : tangerine) {
        	if(map.containsKey(t)) {
        		map.put(t, map.get(t) + 1);
        	}
        	else {
        		map.put(t, 1);
        	}
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int key : map.keySet()) {
        	pq.add(map.get(key));
        }
        
        while(k > 0) {
        	++answer;
        	k -= pq.poll();
        }
            
        return answer;
    }

}
