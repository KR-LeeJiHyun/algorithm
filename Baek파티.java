import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek파티 {
	
	static final int INF = 1_000_000;
	static int N;
	static int M;
	static int X;
	
	static class Node implements Comparable<Node>{
		int v;
		int d;
		
		Node(int v, int d) {
			this.v = v;
			this.d = d;
		}
		
		public int compareTo(Node o) {
			return this.d - o.d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		N = Integer.parseInt(input.nextToken());
		M = Integer.parseInt(input.nextToken());
		X = Integer.parseInt(input.nextToken());
		ArrayList<Node>[] adj = new ArrayList[N + 1];
		ArrayList<Node>[] rAdj = new ArrayList[N + 1];
		
		for(int start = 1; start <= N; ++start) {
			adj[start] = new ArrayList();
			rAdj[start] = new ArrayList();
		}
		
		for(int idx = 0; idx < M; ++idx) {
			input = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(input.nextToken());
			int e = Integer.parseInt(input.nextToken());
			int d = Integer.parseInt(input.nextToken());
			adj[s].add(new Node(e, d));
			rAdj[e].add(new Node(s, d));
		}
		
		int answer = 0;
		int[] forward = dij(adj);
		int[] reverse = dij(rAdj);
		
		
		for(int start = 1; start <= N; ++start) {
			answer = Math.max(answer, forward[start] + reverse[start]);
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

	private static int[] dij(ArrayList<Node>[] adj) {
		int[] dis = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(dis, INF);
		PriorityQueue<Node> pq = new PriorityQueue();
		dis[X] = 0;
		pq.add(new Node(X, 0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			if(visited[current.v]) continue;
			visited[current.v] = true;
			for(Node next : adj[current.v]) {
				if(dis[next.v] <= current.d + next.d) continue;
				dis[next.v] = current.d  + next.d;
				pq.add(new Node(next.v, dis[next.v]));
			}
		}
		
		return dis;
	}

}
