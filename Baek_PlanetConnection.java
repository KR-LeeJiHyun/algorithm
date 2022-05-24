import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_PlanetConnection {
	
	static class Pair implements Comparable<Pair>{
		int n;
		long weight;
		
		Pair(int n, long weight) {
			this.n = n;
			this.weight = weight;
		}
		
		public int compareTo(Pair o) {
			if(this.weight <= o.weight) return -1;
			else return 1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N]; 
		for(int row = 0; row < N; ++row) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; ++col) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		bw.write(prim(N, map) + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

	private static long prim(int v, int[][] map) {
		long result = 0;
		Queue<Pair> q = new LinkedList();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[v];
		q.add(new Pair(0, 0));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int c = p.n;
			long weight = p.weight;

			if(visited[c]) { 	
				continue;
			}
			
			result += weight;
			visited[c] = true;
			for(int idx = 0; idx < v; ++idx) {
				if(c != idx && !visited[idx]) pq.add(new Pair(idx, map[c][idx]));
			}
			
			while(!pq.isEmpty()) {
				Pair np = pq.poll();
				if(!visited[np.n]) {
					q.add(np);
					break;
				}
			}
		}
		
		return result;
	}

}
