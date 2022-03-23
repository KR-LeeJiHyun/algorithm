import java.util.ArrayList;

public class Pro_SheepWolf {
	public static void main(String[] args) {
		int[] info = {0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0};
		int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}};
		
		solution(info, edges);
	}
	
	static int answer = 0;
	
    public static int solution(int[] info, int[][] edges) {
        int len = info.length;
        
        ArrayList<Integer>[] map = new ArrayList[len];
        int[] visited = new int[len];
        
        for(int idx = 0; idx < len; ++idx) map[idx] = new ArrayList<>();
        
        for(int[] edge : edges) {
        	map[edge[0]].add(edge[1]);
        	map[edge[1]].add(edge[0]);
        }
        
        dfs(0, 0, 0, info, map, visited);
        
        return answer;
    }

	private static void dfs(int current, int sheep, int wolf, int[] info, ArrayList<Integer>[] map, int[] visited) {
		/*if(info[current] == 0) ++sheep; 
		else if(info[current] == 1) ++wolf;
		int[] clone = info.clone();
		clone[current] = -1;
		int tmp = visited[current];
		visited[current] = sheep;

		answer = Math.max(answer, sheep);
		
		for(int idx = 0; idx < map[current].size(); ++idx) {
			int next = map[current].get(idx);
			if(visited[next] < sheep) {
				if(clone[next] == 1 && sheep > wolf + 1) dfs(next, sheep, wolf, clone, map, visited);
				else if(clone[next] != 1) dfs(next, sheep, wolf, clone, map, visited);
			}
		}
		visited[current] = tmp;*/
		if(info[current] == 0) ++sheep; 
		else if(info[current] == 1) ++wolf;
        int vtmp = visited[current], itmp = info[current];
        info[current] = -1;
		visited[current] = sheep;

		answer = Math.max(answer, sheep);
		
		for(int idx = 0; idx < map[current].size(); ++idx) {
			int next = map[current].get(idx);
			if(visited[next] < sheep) {
				
				if(info[next] == 1 && sheep > wolf + 1) dfs(next, sheep, wolf, info, map, visited);
				else if(info[next] != 1) dfs(next, sheep, wolf, info, map, visited);
			}
		}
        visited[current] = vtmp;
        info[current] = itmp;
	}

}


