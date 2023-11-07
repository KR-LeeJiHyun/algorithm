import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek최소비용구하기 {
	
	static class Node implements Comparable<Node>{
		int v;
		int d;
		Node next;
		
		Node(int v, int d, Node next) {
			this.v = v;
			this.d = d;
			this.next = next;
		}
		
		public int compareTo(Node o) {
			return this.d - o.d;
		}
	}
	
	static final int INF = 100000001;
	static int N;
	static int M;
	static Node[] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new Node[N + 1];
		StringTokenizer input;
		for(int idx = 0; idx < M; ++idx) {
			input = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(input.nextToken());
			int b = Integer.parseInt(input.nextToken());
			int d = Integer.parseInt(input.nextToken());
			
			graph[a] = new Node(b, d, graph[a]);
		}
		
		input = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(input.nextToken());
		int end = Integer.parseInt(input.nextToken());
		
		int[] dis = dij(start, end);
		
		bw.write(String.valueOf(dis[end]));
		br.close();
		bw.close();

	}

	private static int[] dij(int start, int end) {
		int[] dis = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(dis, INF);
		dis[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0, null));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			if(current.v == end) return dis;
			if(visited[current.v]) continue;
			visited[current.v] = true;
			
			for(Node next = graph[current.v]; next != null; next = next.next) {
				int sum = current.d + next.d;
				if(sum < dis[next.v]) {
					dis[next.v] = sum;
					pq.add(new Node(next.v, sum, null));
				}
			}
		}
		
		return dis;
	}

}
