import java.util.ArrayList;

public class Pro등대 {

	public static void main(String[] args) {
		int n = 8;
		int[][] lighthouse = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}};
		
		Pro등대 s = new Pro등대();
		s.solution(n, lighthouse);

	}
	
	int[][] dp;
	ArrayList<Integer>[] map;
	boolean[] visited;
	
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        dp = new int[n + 1][2];
        map = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        for(int idx = 0; idx <= n; ++idx) {
        	map[idx] = new ArrayList<>();
        }
        
        for(int idx = 0; idx < lighthouse.length; ++idx) {
        	map[lighthouse[idx][0]].add(lighthouse[idx][1]);
        	map[lighthouse[idx][1]].add(lighthouse[idx][0]);
        }
        
        dfs(1);
        
        return Math.min(dp[1][0], dp[1][1]);
    }

	private void dfs(int node) {
		visited[node] = true;
		dp[node][1] = 1;
		for(int idx = 0; idx < map[node].size(); ++idx) {
			int next = map[node].get(idx);
			if(!visited[next]) {
				dfs(next);
				dp[node][0] += dp[next][1];
				dp[node][1] += Math.min(dp[next][0], dp[next][1]);
			}
		}
		
	}

}
