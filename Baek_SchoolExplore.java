import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_SchoolExplore {
	
	static class MinNode implements Comparable<MinNode>{
		int start;
		int dest;
		int weight;

		MinNode(int start,int dest, int weight) {
			this.start = start;
			this.dest = dest;
			this.weight = weight;
		}

		public int compareTo(MinNode o) {
			return this.weight - o.weight;
		}
	}
	
	static class MaxNode implements Comparable<MaxNode>{
		int start;
		int dest;
		int weight;

		MaxNode(int start,int dest, int weight) {
			this.start = start;
			this.dest = dest;
			this.weight = weight;
		}

		public int compareTo(MaxNode o) {
			return o.weight - this.weight;
		}
	}

	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(stNM.nextToken()), M = Integer.parseInt(stNM.nextToken());
		PriorityQueue<MinNode> min_edge = new PriorityQueue<>();
		PriorityQueue<MaxNode> max_edge = new PriorityQueue<>();
		
		for(int idx = 0; idx < M + 1; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), cost = Integer.parseInt(st.nextToken());
			min_edge.add(new MinNode(x, y, cost));
			max_edge.add(new MaxNode(x, y, cost));
		}
		
		
		int min = min_kruskal(N + 1, min_edge);
		int max = max_kruskal(N + 1, max_edge);
		int answer = (int)(Math.pow(N - min, 2) - Math.pow(N - max, 2));
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int min_kruskal(int N, PriorityQueue<MinNode> edge) {
		int result = 0;
		parent = new int[N];
		
		for(int idx = 0; idx < N; ++idx) parent[idx] = idx;
		
		while(!edge.isEmpty()) {
			MinNode node = edge.poll();
			int start = node.start, dest = node.dest, weight = node.weight;
			if (find(start) != find(dest)) {
				union(start, dest);
				result += weight;
			}
		}
		
		return result;
	}
	
	private static int max_kruskal(int N, PriorityQueue<MaxNode> edge) {
		int result = 0;
		parent = new int[N];
		
		for(int idx = 0; idx < N; ++idx) parent[idx] = idx;
		
		while(!edge.isEmpty()) {
			MaxNode node = edge.poll();
			int start = node.start, dest = node.dest, weight = node.weight;
			if (find(start) != find(dest)) {
				union(start, dest);
				result += weight;
			}
		}
		
		return result;
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
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
