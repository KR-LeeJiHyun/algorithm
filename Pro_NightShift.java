import java.util.Collections;
import java.util.PriorityQueue;

public class Pro_NightShift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int idx = 0; idx < works.length; ++idx) pq.add(works[idx]);
        
        while(!pq.isEmpty() && n != 0) {
        	int work = pq.poll() - 1;
        	--n;
        	if(work == 0) continue;
        	pq.add(work);
        }
        
        while(!pq.isEmpty()) {
        	int work = pq.poll();
        	answer += work * work;
        }
        
        return answer;
    }

}
