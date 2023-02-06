import java.util.PriorityQueue;

public class Pro_DefenceGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int idx = 0; idx < enemy.length; ++idx) {
        	if(pq.size() == k) {
        		if(pq.peek() <= n || enemy[idx] <= n) {
        			pq.add(enemy[idx]);
        			n -= pq.poll();
        			answer = idx + 1;
        		}
        		else {
        			break;
        		}
        	}
        	else {
        		pq.add(enemy[idx]);
        	}
        }
        
        return answer;
    }

}
