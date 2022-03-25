import java.util.ArrayList;
import java.util.PriorityQueue;

public class Pro_WallCheck {

	public static void main(String[] args) {
		int n = 12;
		int[] weak = {1, 2, 3, 4, 9, 10}, dist = {3, 5, 7};
		solution(n, weak, dist);
	}
	
    public static int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        boolean[] visited = new boolean[dist.length];
        ArrayList<Integer> dList = new ArrayList<>();
        answer = permu(n, dist, weak, dList, visited); 
        
        return answer;
    }

	private static int permu(int n, int[] dist, int[] weak, ArrayList<Integer> dList, boolean[] visited) {
		int answer = -1;
		for(int idx = 0; idx < dist.length; ++idx) {
			if(visited[idx]) continue;
			visited[idx] = true;
			dList.add(dist[idx]);
			for(int sIdx = 0; sIdx < weak.length; ++sIdx) {
				boolean result = search(weak[sIdx], n, dList, weak);
				if(result) {
					int cnt = dList.size();
					dList.remove(dList.size() - 1);
					visited[idx] = false;
					return cnt;
				}
			}
			if(answer == -1) answer = permu(n, dist, weak, dList, visited);
			else answer = Math.min(answer, permu(n, dist, weak, dList, visited));
			dList.remove(dList.size() - 1);
			visited[idx] = false;
		}
		return answer;
	}

	private static boolean search(int start, int n, ArrayList<Integer> dList, int[] weak) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int idx = 0; idx < weak.length; ++idx) {
			if(start <= weak[idx]) pq.add(weak[idx]);
			else pq.add(weak[idx] + n);
		}
				
		for(int d : dList) {
			int end = start + d;
			while(!pq.isEmpty()) {
				if(pq.peek() <= end) pq.poll();
				else {
					start = pq.peek();
					break;
				}
			}
		}
		
		return pq.isEmpty();
	}

}
