import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekLCA {
	
	static int[][] parents;
	static int[] depths;
	static int h;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] map = new ArrayList[N + 1];
		for(int idx = 1; idx <= N; ++idx) map[idx] = new ArrayList();
		h = getHeight(N);
		parents = new int[N + 1][h];
		depths = new int[N + 1];
		for(int idx = 1; idx < N; ++idx) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(input.nextToken());
			int v = Integer.parseInt(input.nextToken());
			map[u].add(v);
			map[v].add(u);
		}
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;
		q.add(1);
		while(!q.isEmpty()) {
			int c = q.poll();
			for(int next : map[c]) {
				if(!visited[next]){
					visited[next] = true;
					parents[next][0] = c;
					depths[next] = depths[c] + 1;
					q.add(next);
				}
			}
		}
		
		for(int col = 1; col < h; ++col) {
			for(int row = 1; row <= N; ++row) {
				parents[row][col] = parents[parents[row][col - 1]][col - 1];
			}
		}
		
		StringBuilder answer = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		for(int idx = 0; idx < M; ++idx) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(input.nextToken());
			int v = Integer.parseInt(input.nextToken());
			
			int lca = find(u, v);
			answer.append(lca);
			answer.append('\n');
		}
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}

	private static int getHeight(int n) {
		return (int)Math.ceil(Math.log(n)/Math.log(2)) + 1;
	}

	private static int find(int u, int v) {
		int uh = depths[u];
		int vh = depths[v];
		
		if(uh < vh) {
			return find(v, u);
		}
		
		for(int idx = h - 1; idx >= 0; --idx) {
			if(Math.pow(2, idx) <= depths[u] - depths[v]) {
				u = parents[u][idx];
			}
		}
		
		if(u == v) return u;
		
		for(int idx = h - 1; idx >= 0; --idx) {
			if(parents[u][idx] != parents[v][idx]) {
				u = parents[u][idx];
				v = parents[v][idx];
			}
		}
		
		return parents[u][0];
	}
}