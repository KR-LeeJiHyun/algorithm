import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_ArcticNetwork {
	
	static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int start;
		int dest;
		double cost;
		
		public Edge(int start, int dest, double cost) {
			this.start = start;
			this.dest = dest;
			this.cost = cost;
		}

		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}
	}
	
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer stSP = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(stSP.nextToken()), P = Integer.parseInt(stSP.nextToken());
			Pair[] pairs = new Pair[P];
			for(int p = 0; p < P; ++p) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				pairs[p] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			PriorityQueue<Edge> edges = new PriorityQueue<>();
			for(int p = 0; p < P - 1; ++p) {
				for(int sp = p + 1; sp < P; ++sp) edges.add(new Edge(p, sp, calcCost(pairs[p], pairs[sp])));
			}
			
			bw.write(String.format("%.2f",kruskal(P, S, edges)) + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	private static double calcCost(Pair start, Pair dest) {
		double result = 0;
		result = Math.sqrt(Math.pow(start.x - dest.x,2) + Math.pow(start.y - dest.y, 2));
		return result;
	}

	private static double kruskal(int P, int S, PriorityQueue<Edge> edges) {
		double result = 0;
		parent = new int[P];
		
		for(int idx = 0; idx < P; ++idx) parent[idx] = idx;
		
		while(P - (S - 1) > 1) {
			Edge edge = edges.poll();
			int start = edge.start, dest = edge.dest;
			double cost = edge.cost;
            int fs = find(start), fd = find(dest);
            
			if (fs != fd) {
				union(fs, fd);
				result = Math.max(result, cost);
				--P;
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
