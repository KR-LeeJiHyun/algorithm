import java.util.Arrays;
import java.util.PriorityQueue;

public class Pro_IslandConnect {

	public static void main(String[] args) {
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		solution(n, costs);
	}
	
	static class Pair implements Comparable<Pair>{
		int node;
		int weight;
		
		
		public Pair(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
		
		public int compareTo(Pair o) {
			return this.weight - o.weight;
		}
	}

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int[][] map = new int[n][n];
        boolean[] visited = new boolean[n];
        
        for(int idx = 0; idx < n; ++idx) Arrays.fill(map[idx], Integer.MAX_VALUE);
        
        for(int idx = 0; idx < costs.length; ++idx) {
        	map[costs[idx][0]][costs[idx][1]] = costs[idx][2];
        	map[costs[idx][1]][costs[idx][0]] = costs[idx][2];
        }
        
        answer = bfs(0, n, map, visited);
        
        return answer;
    }

	private static int bfs(int start, int n, int[][] map, boolean[] visited) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		visited[start] = true;
		for(int idx = 1; idx < n; ++idx) {
			if(map[start][idx] != Integer.MAX_VALUE) pq.add(new Pair(idx, map[start][idx]));
		}
		
		int result = 0;
		while(!pq.isEmpty()) {
			Pair current = pq.poll();
			if(!visited[current.node]) {
				visited[current.node] = true;
				result += current.weight;
				for(int idx = 1; idx < n; ++idx) {
					if(map[current.node][idx] != Integer.MAX_VALUE) pq.add(new Pair(idx, map[current.node][idx]));
				}
			}
		}
		
		return result;
	}
}
