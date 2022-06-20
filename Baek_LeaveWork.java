import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_LeaveWork {
	
	static class Pair implements Comparable<Pair>{
		int row;
		int col;
		int cost;
		
		Pair(int row, int col, int cost) {
			this.row = row;
			this.col = col;
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
		int[][] map = new int[N][N];
		for(int row = 0; row < N; ++row) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; ++col) map[row][col] = Integer.parseInt(st.nextToken());
		} 
		
		bw.write(prim(N, map) + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int prim(int v, int[][] map) {
		int result = 0;
		Queue<Pair> q = new LinkedList();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[v][v];
		int[] d_row = {1, -1, 0, 0}, d_col = {0, 0, 1, -1};
		q.add(new Pair(0, 0, 0));
		
		while(!q.isEmpty()) {
			Pair c = q.poll();
			int row = c.row;
			int col = c.col;
			int cost = c.cost;

			if(visited[row][col]) continue;
			
			result = Math.max(result, cost);
			if(row == v - 1 && col == v - 1) return result;
			visited[row][col] = true;
			for(int idx = 0; idx < d_row.length; ++idx) {
				int n_row = row + d_row[idx], n_col = col + d_col[idx];
				if(n_row < 0 || n_row == v || n_col < 0 || n_col == v) continue;
				if(!visited[n_row][n_col]) pq.add(new Pair(n_row, n_col, Math.abs(map[row][col] - map[n_row][n_col])));
			} 
			
			while(!pq.isEmpty()) {
				Pair p = pq.poll();
				if(!visited[p.row][p.col]) {
					q.add(p);
					break;
				}
			}
		}
		
		return -1;
	}

}
