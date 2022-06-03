import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_WaterRoad {

	static class Pair implements Comparable<Pair>{
		int n;
		int cost;
		
		Pair(int n, int cost) {
			this.n = n;
			this.cost = cost;
		}
		
		public int compareTo(Pair o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][N + 1];
		for(int idx = 0; idx < N; ++idx) {
			int cost = Integer.parseInt(br.readLine());
			map[N][idx] = cost;
			map[idx][N] = cost;
		}
		
		
		for(int row = 0; row < N; ++row) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; ++col) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		bw.write((prim(N, map)) + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int prim(int v, int[][] map) {
		int result = 0;
		Queue<Pair> q = new LinkedList();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[v + 1];
		q.add(new Pair(0, 0));
		
		while(!q.isEmpty()) {
			Pair c = q.poll();
			int n = c.n;
			int cost = c.cost;

			if(visited[n]) continue;
			
			result += cost;
			visited[n] = true;
			for(int col = 0; col <= v; ++col) {
				if(!visited[col]) pq.add(new Pair(col, map[n][col]));
			} 
			
			while(!pq.isEmpty()) {
				Pair p = pq.poll();
				if(!visited[p.n]) {
					q.add(p);
					break;
				}
			}
		}
		
		return result;
	}

}
