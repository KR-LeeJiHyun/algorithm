import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pro부대복귀 {
	
	int[] dp;

	public int[] solution(int n, int[][] roads, int[] sources, int destination) {
	        int[] answer = new int[sources.length];
	        
	        ArrayList<Integer>[] maps = new ArrayList[n + 1];
	        dp = new int[n + 1];
	        Arrays.fill(dp, -1);
	        
	        for(int idx = 1; idx <= n; ++idx) {
	        	maps[idx] = new ArrayList<>();
	        }
	        
	        for(int idx = 0; idx < roads.length; ++idx) {
	        	int a = roads[idx][0];
	        	int b = roads[idx][1];
	        	maps[a].add(b);
	        	maps[b].add(a);
	        }
	        bfs(n, destination, maps);
	        
	        for(int idx = 0; idx < sources.length; ++idx) {
	        	answer[idx] = dp[sources[idx]];
	        }
	        
	        return answer;
	    }

	private void bfs(int n, int destination, ArrayList<Integer>[] maps) {
		dp[destination] = 0;
		Queue<Integer> q = new LinkedList();
		q.add(destination);
		q.add(0);
		
		while(!q.isEmpty()) {
			int current = q.poll();
			int cnt = q.poll();
			
			for(int idx = 0; idx < maps[current].size(); ++idx) {
				int next = maps[current].get(idx);
				if(dp[next] == -1) {
					dp[next] = cnt + 1;
					q.add(next);
					q.add(cnt + 1);
				}
			}
		}
	}
	
}
