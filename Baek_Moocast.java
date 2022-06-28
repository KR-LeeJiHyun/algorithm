import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_Moocast {

	static class Edge implements Comparable<Edge> {
		int start;
		int dest;
		int cost;
		
		public Edge(int start, int dest, int cost) {
			this.start = start;
			this.dest = dest;
			this.cost = cost;
		}

		public int compareTo(Edge o) {
			return (int)(this.cost - o.cost);
		}
	}
	
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] xys  = new int[N][2];
		
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer xy = new StringTokenizer(br.readLine());
			xys[idx][0] = Integer.parseInt(xy.nextToken());
			xys[idx][1] = Integer.parseInt(xy.nextToken());
		}
		
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		for(int start = 0; start < N - 1; ++start) {
			for(int dest = start + 1; dest < N; ++dest) edges.add(new Edge(start, dest, calcCost(xys, start, dest)));
		}
		
		bw.write(kruskal(N, edges) + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int calcCost(int[][] xys, int start, int dest) {
		int result = 0;
		
		result = (int)Math.pow(xys[start][0] - xys[dest][0] , 2);
		result += (int)Math.pow(xys[start][1] - xys[dest][1] , 2);
		
		return result;
	}

	private static long kruskal(int N, PriorityQueue<Edge> edges) {
		long result = 0;
		parent = new int[N];
		
		for(int idx = 0; idx < N; ++idx) parent[idx] = idx;
		
		int cnt = 0;
		while(cnt != N - 1) {
			Edge edge = edges.poll();
			int start = edge.start, dest = edge.dest;
			int cost = edge.cost;
            int fs = find(start), fd = find(dest);
            
			if (fs != fd) {
				union(fs, fd);
				result = Math.max(result, cost);
				++cnt;
			}
		}
		
		return result;
	}

	private static void union(int a, int b) {
		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	private static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return find(parent[x]);
	}

}
