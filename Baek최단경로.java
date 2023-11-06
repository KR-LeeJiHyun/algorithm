import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek최단경로 {
	
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
		
		final int INF = Integer.MAX_VALUE;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(input.nextToken());
		int E = Integer.parseInt(input.nextToken());
		int K = Integer.parseInt(br.readLine());
		ArrayList<Node> graph[] = new ArrayList[V + 1];
		
		for(int idx = 1; idx <= V; ++idx) {
			graph[idx] = new ArrayList();
		}
		
		for(int idx = 0; idx < E; ++idx) {
			input = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(input.nextToken());
			int v = Integer.parseInt(input.nextToken());
			int w = Integer.parseInt(input.nextToken());
			
			graph[u].add(new Node(v, w));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dis = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
 		Arrays.fill(dis, INF);
		dis[K] = 0;
		pq.add(new Node(K, 0));
		
		while(!pq.isEmpty()) {
			Node c = pq.poll();
			if(visited[c.v]) continue;
			visited[c.v] = true;
			
			for(Node next : graph[c.v]) {
				int nd = next.d + c.d;
				if(dis[next.v] <= nd) continue;
				dis[next.v] = nd;
				pq.add(new Node(next.v, nd));
			}
		}
		
		StringBuilder answer = new StringBuilder();
		
		for(int idx = 1; idx <= V; ++idx) {
			if(dis[idx]!= INF) {
				answer.append(dis[idx]);
			}
			else {
				answer.append("INF");
			}
			answer.append('\n');
		}
		
		bw.write(answer.toString());
		br.close();
		bw.close();
		
	}

}
