import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_CityErection {
	
	static class Node implements Comparable<Node> {
		int start;
		int dest;
		long cost;
		
		public Node(int start, int dest, long cost) {
			this.start = start;
			this.dest = dest;
			this.cost = cost;
		}

		public int compareTo(Node o) {
			return (int)(this.cost - o.cost);
		}
	}
	
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken()), M = Integer.parseInt(stNM.nextToken());
		long sum = 0;
		PriorityQueue<Node> edge = new PriorityQueue<>();
		
		for(int idx = 0; idx < M; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()), dest = Integer.parseInt(st.nextToken());
			long cost = Long.parseLong(st.nextToken());
			sum += cost;
			edge.add(new Node(start, dest, cost));
		}
		
		bw.write(kruskal(N, sum, edge) + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static long kruskal(int N, long sum, PriorityQueue<Node> edge) {
		long result = 0;
		parent = new int[N + 1];
		
		for(int idx = 0; idx <= N; ++idx) parent[idx] = idx;
		int cnt = 0;
		
		while(!edge.isEmpty()) {
			Node node = edge.poll();
			int start = node.start, dest = node.dest;
            long cost = node.cost;
            int fs = find(start), fd = find(dest);
            
			if (fs != fd) {
				union(fs, fd);
				result += cost;
				++cnt;
			}
		}
		
		if(cnt == N - 1) return sum - result;
		else return -1;
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
