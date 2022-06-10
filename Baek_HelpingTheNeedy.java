import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Baek_HelpingTheNeedy {
	
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
		int[][] map = new int[N][N];
		int sum = 0;
		
		for(int row = 0; row < N; ++row) {
			String strMap = br.readLine();
			for(int col = 0; col < N; ++col) {
				char ch = strMap.charAt(col);
				if(ch != '0') {
					if(ch < 'a') map[row][col] = ch - 'A' + 27;
					else map[row][col] = ch -'a' + 1;
				}
				else map[row][col] = 0;
				sum += map[row][col];
				if(map[col][row] != 0 && map[row][col] != 0) {
					map[row][col] = Math.min(map[row][col], map[col][row]);
					map[col][row] = Math.min(map[row][col], map[col][row]);
				}
				else if(map[col][row] != 0) map[row][col] = map[col][row];
				else if(map[row][col] != 0) map[col][row] = map[row][col];
			}
		}
		
		bw.write(prim(N, sum, map) + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int prim(int v, int sum, int[][] map) {
		int result = 0, cnt = 0;
		Queue<Pair> q = new LinkedList();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[v];
		q.add(new Pair(0, 0));
		
		while(!q.isEmpty()) {
			Pair c = q.poll();
			int n = c.n;
			int cost = c.cost;

			if(visited[n]) continue;
			
			result += cost;
			visited[n] = true;
			++cnt;
			for(int col = 1; col < v; ++col) {
				if(!visited[col] && map[n][col] != 0) pq.add(new Pair(col, map[n][col]));
			} 
			
			while(!pq.isEmpty()) {
				Pair p = pq.poll();
				if(!visited[p.n]) {
					q.add(p);
					break;
				}
			}
		}
		
		if(cnt == v) return sum - result;
		else return -1;
	}

}
