import java.util.LinkedList;
import java.util.Queue;

public class Pro_PowerGridDiv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[][] wires = {{1,2}, {2,3}, {3,4}};
		solution(n, wires);
	}
	
    public static int solution(int n, int[][] wires) {
        int answer = 100;
        int[][] map = new int[n + 1][n + 1];
        for(int idx = 0; idx < n - 1; ++idx) {
        	int v1 = wires[idx][0], v2 = wires[idx][1];
        	map[v1][v2] = 1;
        	map[v2][v1] = 1;
        }
        
        for(int idx = 0; idx < n - 1; ++idx) {
        	boolean[] visited = new boolean[n + 1];
        	answer = Math.min(answer, div(n, wires[idx], map, visited));
        }
        
        return answer;
    }

	private static int div(int n, int[] wire, int[][] map, boolean[] visited) {
		int result = 100, v1 = wire[0], v2 = wire[1];
		map[v1][v2] = 0;
		map[v2][v1] = 0;
		
		int v1R = bfs(n, v1, v2, map, visited), v2R = bfs(n, v2, v1, map, visited);
		if(v1R + v2R == n) result = Math.abs(v1R - v2R);
		
		map[v1][v2] = 1;
		map[v2][v1] = 1;
		
		return result;
	}

	private static int bfs(int n, int start, int prohi, int[][] map, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		int result = 0;
		q.add(start);
		
		while(!q.isEmpty()) {
			int current = q.poll();
			visited[current] = true;
			++result;
			if(map[current][prohi] == 1) return 100;
			
			for(int next = 0; next <= n; ++next) {
				if(!visited[next] && map[current][next] == 1) {
					q.add(next);
				}
			}
		}
		
		return result;
	}
}
