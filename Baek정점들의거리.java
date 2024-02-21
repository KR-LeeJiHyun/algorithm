import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek정점들의거리 {

	static class Node {
		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static int[][] parents;
	static int[] levels;
	static int maxH;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		final int INF = Integer.MAX_VALUE;
		int N = Integer.parseInt(br.readLine());
		ArrayList<Node>[] map = new ArrayList[N + 1];
		for(int idx = 1; idx <= N; ++idx) {
			map[idx] = new ArrayList();
		}

		for(int idx = 1; idx < N; ++idx) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(input.nextToken());
			int v = Integer.parseInt(input.nextToken());
			int w = Integer.parseInt(input.nextToken());
			map[u].add(new Node(v , w));
			map[v].add(new Node(u , w));
		}

		int M = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		int[] dist = new int[N + 1];
		maxH = (int)Math.ceil(Math.log(N) / Math.log(2)) + 1;
		parents = new int[N + 1][maxH];
		levels = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1, 0));
		while(!q.isEmpty()) {
			Node c = q.poll();
			for(Node next : map[c.v]) {
				if(!visited[next.v]) {
					visited[next.v] = true;
					dist[next.v] = c.w + next.w;
					parents[next.v][0] = c.v;
					levels[next.v] = levels[c.v] + 1;
					q.add(new Node(next.v, dist[next.v]));
				}
			}
		}
		
		for(int col = 1; col < maxH; ++col) {
			for(int row = 1; row <= N; ++row) {
				parents[row][col] = parents[parents[row][col - 1]][col - 1];
			}
		}
		
		for(int idx = 0; idx < M; ++idx) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(input.nextToken());
			int end = Integer.parseInt(input.nextToken());
			
			int parent = find(start, end);
			answer.append(dist[start] + dist[end] - dist[parent] * 2);
			answer.append('\n');
		}
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}

	private static int find(int start, int end) {
		int sl = levels[start];
		int el = levels[end];
		
		if(sl < el) return find(end, start);
		
		for(int idx = maxH - 1; idx >= 0; --idx) {
			if(Math.pow(2, idx) <= levels[start] - el) start = parents[start][idx];
		}
		
		if(start == end) return start;
		
		for(int idx = maxH - 1; idx >= 0; --idx) {
			if(parents[start][idx] != parents[end][idx]) {
				start = parents[start][idx];
				end = parents[end][idx];
			}
		}
		
		return parents[start][0];
	}

}
