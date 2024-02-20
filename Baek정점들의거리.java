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

	static class Node implements Comparable<Node>{
		int v;
		int w;
		int l;

		public Node(int v, int w, int l) {
			this.v = v;
			this.w = w;
			this.l = l;
		}

		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	static int[] parents;
	static int[] levels;

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
			map[u].add(new Node(v , w, 0));
			map[v].add(new Node(u , w, 0));
		}

		int M = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		int[] dist = new int[N + 1];
		parents = new int[N + 1];
		levels = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		parents[1] = 1;
		visited[1] = true;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1, 0, 0));
		while(!q.isEmpty()) {
			Node c = q.poll();
			for(Node next : map[c.v]) {
				if(!visited[next.v]) {
					visited[next.v] = true;
					dist[next.v] = c.w + next.w;
					parents[next.v] = c.v;
					levels[next.v] = c.l + 1;
					q.add(new Node(next.v, dist[next.v], levels[next.v]));
				}
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
		if(start == end) return start;
		else if(levels[start] < levels[end]) return find(start, parents[end]);
		else if(levels[start] > levels[end]) return find(parents[start], end);
		else return find(parents[start], parents[end]);
	}

}
