import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek인터넷설치 {

	static int N;
	static int P;
	static int K;
	static ArrayList<Node>[] map;
	static boolean[] visited;
	
	static class Node implements Comparable<Node>{
		int v;
		int cost;
		
		Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
		
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer input = new StringTokenizer(br.readLine());
		N = Integer.parseInt(input.nextToken());
		P = Integer.parseInt(input.nextToken());
		K = Integer.parseInt(input.nextToken());
		map = new ArrayList[N + 1];
		
		for(int idx = 1; idx <= N; ++idx) {
			map[idx] = new ArrayList<>();
		}
		
		for(int idx = 0; idx < P; ++idx) {
			input = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(input.nextToken());
			int v2 = Integer.parseInt(input.nextToken());
			int cost = Integer.parseInt(input.nextToken());
			map[v1].add(new Node(v2, cost));
			map[v2].add(new Node(v1, cost));
		}

		int answer = Integer.MAX_VALUE;
		int left = 0;
		int right = 1000000;

		while(left <= right) {
			int mid = (left + right) / 2;
			if(dij(mid)) {
				answer = Math.min(answer, mid);
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}

		if(answer != Integer.MAX_VALUE) bw.write(String.valueOf(answer));
		else bw.write("-1");
		br.close();
		bw.close();
	}

	private static boolean dij(int limit) {
		visited = new boolean[N + 1];
		int[] dis = new int[N + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[1] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		
		while(!pq.isEmpty()) {
			Node c = pq.poll();
			visited[c.v] = true;
			
			for(Node next : map[c.v]) {
				int cost = c.cost + ((next.cost <= limit) ? 0 : 1);
				if(!visited[next.v] && dis[next.v] > cost) {
					dis[next.v] = cost;
					pq.add(new Node(next.v, cost));
				}
			} 
			
		}
		
		if(dis[N] <= K) {
			return true;
		}
		else {
			return false;
		}
	}
}