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
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		
		for(int row = 0; row < N - 1; ++row) {
			String line = br.readLine();
			for(int col = row + 1; col < N; ++col) {
				if(line.charAt(col) == 'Y') edges.add(new Edge(row, col));
			}
		}

		int cnt = kruskal(N, M, edges);
		if(cnt == M) for(int idx = 0; idx < N; ++idx) bw.write(nums[idx] + " ");
		else bw.write("-1");
		bw.write("\n");
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int kruskal(int N, int M, PriorityQueue<Edge> edges) {
		parent = new int[N];
		nums = new int[N]; 
		visited = new boolean[N][N];
		
		for(int idx = 0; idx < N; ++idx) parent[idx] = idx;
		
		int cnt = 0, a_cnt = 0, a_max = M - N + 1;
		
		while(cnt + a_cnt != M && !edges.isEmpty()) {
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
			else if(a_cnt < a_max) {
				++nums[start];
				++nums[dest];
				++a_cnt;
			}
		}
		
		return cnt + a_cnt;
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
