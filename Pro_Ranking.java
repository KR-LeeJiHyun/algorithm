import java.util.ArrayList;
import java.util.Arrays;

public class Pro_Ranking {
	
	public static ArrayList<Integer>[] map;
	public static boolean[] visited;
	
	public static int dfs(int node, int win) {
		visited[node] = true;
		
		for(int tmp : map[node]) {
			if(!visited[tmp]) win = dfs(tmp, win + 1);
		}
		
		return win;
	}

    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[] wins = new int[n];
        map = new ArrayList[n + 1];
        
        for(int idx = 1; idx < n + 1; ++idx) map[idx] = new ArrayList();
        for(int[] tmp : results) map[tmp[0]].add(tmp[1]);
        
        for(int idx = 1; idx < n + 1; ++idx) {
        	visited = new boolean[n + 1];
        	wins[idx - 1] = dfs(idx, 0);
        }
        
        Arrays.sort(wins);
        
        for(int idx = 0; idx < wins.length - 1; ++idx) {
        	if(wins[idx] == idx && wins[idx + 1] != wins[idx]) ++answer;
        }
        
        if(wins[wins.length - 1] == n - 1) ++answer;
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int results[][] = {{3, 5}, {4, 2}, {4, 5}, {5, 1}, {5, 2}};
		System.out.print(solution(n, results));
	}

}
