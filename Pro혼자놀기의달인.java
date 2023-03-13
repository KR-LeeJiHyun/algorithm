import java.util.Collections;
import java.util.PriorityQueue;

public class Pro혼자놀기의달인 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	boolean[] visited;
	int LEN;
	
    public int solution(int[] cards) {
        int answer = 0;
        LEN = cards.length;
        visited = new boolean[LEN];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        
        for(int idx = 0; idx < LEN; ++idx) {
        	if(!visited[idx]) {
        		pq.add(dfs(idx, 0, cards));
        	}
        }
        
        answer = pq.poll() * pq.poll();
        
        return answer;
    }

	private Integer dfs(int idx, int cnt, int[] cards) {
		visited[idx] = true;
		++cnt;
		
		int next = cards[idx] - 1;
		if(visited[next]) {
			return cnt;
		}
		else {
			return dfs(next, cnt, cards);
		}
	}

}
