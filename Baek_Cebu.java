import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_Cebu {
	
	static class Node implements Comparable<Node>{
		int dest;
		int weight;

		Node(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}

		public int compareTo(Node o) {
			return o.weight - this.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken()), M = Integer.parseInt(stNM.nextToken());
		
		StringTokenizer stSD = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(stSD.nextToken()), D = Integer.parseInt(stSD.nextToken());
		
		ArrayList<Node>[] map = new ArrayList[N + 1]; 
		for(int idx = 1; idx <= N; ++idx) map[idx] = new ArrayList();		
		
		for(int idx = 0; idx < M; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken()), weight = Integer.parseInt(st.nextToken());
			map[u].add(new Node(v, weight));
			map[v].add(new Node(u, weight));
		}
		
		bw.write(prim(S, D, N, map) + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

	private static int prim(int s, int d, int n, ArrayList<Node>[] map) {
		Queue<Node> q = new LinkedList();
		PriorityQueue<Node> pq = new PriorityQueue<>();
		q.add(new Node(s, Integer.MAX_VALUE));
		int result = Integer.MAX_VALUE;
		boolean[] visited = new boolean[n + 1];
		
		while(!q.isEmpty()) {
			Node p = q.poll();
			int c = p.dest;
			int weight = p.weight;

			if(visited[c]) continue;
			
			result = Math.min(result ,weight);
			visited[c] = true;
			if(c == d) return result;
			
			for(int idx = 0; idx < map[c].size(); ++idx) {
				Node node = map[c].get(idx);
				if(!visited[node.dest]) {
					pq.add(node);
				}
			}
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				if(!visited[node.dest]) {
					q.add(node);
					break;
				}
			}
		}
		
		return 0;
	}
	

}
