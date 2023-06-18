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

public class Baek중량제한 {
	
	static class Edge implements Comparable<Edge> {
		int v1;
		int v2;
		int weight;
		
		public Edge(int v1, int v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return o.weight - this.weight;
		}
	}
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stNM.nextToken());
		int M = Integer.parseInt(stNM.nextToken());
		parent = new int[N + 1];
		
		for(int idx = 1; idx <= N; ++idx) {
			parent[idx] = idx;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int idx = 0; idx < M; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			pq.add(new Edge(v1, v2, weight));
		}
		
		StringTokenizer stSE = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(stSE.nextToken());
		int end = Integer.parseInt(stSE.nextToken());
		
		int answer = 0;
		while(!pq.isEmpty()) {
			Edge c = pq.poll();
			int v1 = c.v1;
			int v2 = c.v2;
			int weight = c.weight;
			
			union(v1, v2);
			if(find(start) == find(end)) {
				answer = weight;
				break;
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

	private static void union(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		
		parent[p2] = p1;
	}

	private static int find(int v) {
		if(parent[v] == v) return v;
		return find(parent[v]);
	}
	
	/*static class Node {
		int target;
		int weight;
		
		public Node(int target, int weight) {
			super();
			this.target = target;
			this.weight = weight;
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stNM.nextToken());
		int M = Integer.parseInt(stNM.nextToken());
		ArrayList<Node>[] map = new ArrayList[N + 1];
		
		for(int idx = 1; idx <= N; ++idx) {
			map[idx] = new ArrayList<>();
		}
		
		for(int idx = 0; idx < M; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			map[A].add(new Node(B, C));
			map[B].add(new Node(A, C));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		int start = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		int left = 1;
		int right = 1000000000;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			boolean possible = false;
			boolean[] visited = new boolean[N + 1];
			visited[start] = true;
			Queue<Integer> q = new LinkedList<>();
			q.add(start);
			
			while(!q.isEmpty()) {
				int c = q.poll();
				
				if(c == dest) {
					possible = true;
					break;
				}
				
				for(int idx = 0; idx < map[c].size(); ++idx) {
					int next = map[c].get(idx).target;
					int weight = map[c].get(idx).weight;
					if(!visited[next] && weight >= mid) {
						visited[next] = true;
						q.add(next);
					}
				}
			}
			
			if(possible) {
				left = mid + 1;
				answer = Math.max(answer, mid);
			}
			else {
				right = mid - 1;
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
		
	}
	*/

}
