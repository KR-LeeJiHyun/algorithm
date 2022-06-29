import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_Road {
	
	static class Edge implements Comparable<Edge> {
		int start;
		int dest;
		
		public Edge(int start, int dest) {
			this.start = start;
			this.dest = dest;
		}

		public int compareTo(Edge o) {
			if(this.start == o.start) return this.dest - o.dest;
			else return this.start - o.start;
		}
	}
	
	static int[] parent;
	static int[] nums;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken()), M = Integer.parseInt(stNM.nextToken());
		PriorityQueue<Edge> edges = new PriorityQueue<>(), add_edges = new PriorityQueue<>();
		
		for(int row = 0; row < N; ++row) {
			String line = br.readLine();
			for(int col = 0; col < N; ++col) {
				if(row < col && line.charAt(col) == 'Y') {
					Edge edge = new Edge(row, col);
					edges.add(edge);
					add_edges.add(edge);
				}
			}
		}

		int cnt = kruskal(N, edges);
		
		if(cnt != N - 1) bw.write("-1");
		else {
			while(cnt < M && !add_edges.isEmpty()) {
				Edge edge = add_edges.poll();
				if(!visited[edge.start][edge.dest]) {
					++nums[edge.start];
					++nums[edge.dest];
					++cnt;
				}
			}
			if(cnt == M) {
				for(int idx = 0; idx < N; ++idx) bw.write(nums[idx] + " ");
			}
			else bw.write("-1");
		}
		bw.write("\n");
		br.close();
		bw.flush();
		br.close();
	}
	
	private static int kruskal(int N, PriorityQueue<Edge> edges) {
		parent = new int[N];
		nums = new int[N]; 
		visited = new boolean[N][N];
		
		for(int idx = 0; idx < N; ++idx) parent[idx] = idx;
		
		int cnt = 0;
		
		while(cnt != N - 1 && !edges.isEmpty()) {
			Edge edge = edges.poll();
			int start = edge.start, dest = edge.dest;
            int fs = find(start), fd = find(dest);
            
			if (fs != fd) {
				union(fs, fd);
				++nums[start];
				++nums[dest];
				visited[start][dest] = true;
				++cnt;
			}
		}
		
		return cnt;
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
