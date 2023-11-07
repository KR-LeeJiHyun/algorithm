import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek웜홀 {
	
	static final int INF = 1 << 29;
	static int N;
	static int M;
	static int W;
	static int[][] graph;
	static ArrayList<Edge> edges;
	
	static class Edge{
		int u;
		int v;
		int d;
		
		Edge(int u, int v, int d) {
			this.u = u;
			this.v = v;
			this.d = d;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T > 0) {
			--T;
			StringTokenizer input = new StringTokenizer(br.readLine());
			N = Integer.parseInt(input.nextToken());
			M = Integer.parseInt(input.nextToken());
			W = Integer.parseInt(input.nextToken());
			
			graph = new int[N + 1][N + 1];
			edges = new ArrayList();
			for(int idx = 1; idx <= N; ++idx) Arrays.fill(graph[idx], INF);
			
			for(int idx = 0; idx < M; ++idx) {
				input = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(input.nextToken());
				int e = Integer.parseInt(input.nextToken());
				int t = Integer.parseInt(input.nextToken());
				
				graph[s][e] = Math.min(graph[s][e], t);
				graph[e][s] = Math.min(graph[e][s], t);
			}
			
			for(int idx = 0; idx < W; ++idx) {
				input = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(input.nextToken());
				int e = Integer.parseInt(input.nextToken());
				int t = Integer.parseInt(input.nextToken());
				
				graph[s][e] = Math.min(graph[s][e], -t);
			}
			
			for(int s = 1; s <= N; ++s) {
				for(int e = 1; e <= N; ++e) {
					if(graph[s][e] != INF) {
						edges.add(new Edge(s, e, graph[s][e]));
					}
				}
			}
			
			if(bellmanford(1)) bw.write("YES\n");
			else bw.write("NO\n");
		}

		br.close();
		bw.close();
		
	}

	private static boolean bellmanford(int start) {
		int[] dis = new int[N + 1];
		Arrays.fill(dis, INF);
		dis[start] = 0;
		
		for(int n = 1; n <= N; ++n) {
			for(int idx = 0; idx < edges.size(); ++idx) {
				Edge current = edges.get(idx);
				int u = current.u;
				int v = current.v;
				int d = current.d;
				
				int sum = dis[u] + d;
				if(dis[v] > sum) {
					dis[v] = sum;
					if(n == N) return true;
				}
			}
		}
		
		return false;
	}

}
