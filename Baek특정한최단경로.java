import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek특정한최단경로 {
	
	static final int INF = 100000000;
	static int N;
	static int E;
	static ArrayList<Node>[] graph;
	
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
		E = Integer.parseInt(input.nextToken());
		
		graph = new ArrayList[N + 1];
		for(int idx = 1; idx <= N; ++idx) {
			graph[idx] = new ArrayList();
		}
		
		while(E > 0) {
			--E;
			input = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(input.nextToken());
			int v2 = Integer.parseInt(input.nextToken());
			int dis = Integer.parseInt(input.nextToken());
			graph[v1].add(new Node(v2, dis));
			graph[v2].add(new Node(v1, dis));
		}
		
		input = new StringTokenizer(br.readLine());
		int m1 = Integer.parseInt(input.nextToken());
		int m2 = Integer.parseInt(input.nextToken());
		
		int[] fd = dij(1);
		int[] md1 = dij(m1);
		int[] md2 = dij(m2);
		
		int answer = INF;
		
		answer = Math.min(answer, Math.min(fd[m1] + md1[m2] + md2[N], fd[m2] + md2[m1] + md1[N]));
		
		if(answer == INF) {
			answer = -1;
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();

	}

	private static int[] dij(int start) {
		boolean[] visited = new boolean[N + 1];
		int[] dis = new int[N + 1];
		Arrays.fill(dis, INF);
		dis[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			if(visited[current.v]) continue;
			visited[current.v] = true;
			for(Node next : graph[current.v]) {
				if(dis[next.v] <= current.d + next.d) continue;
				dis[next.v] = current.d  + next.d;
				pq.add(new Node(next.v, dis[next.v]));
			}
		}
		
		return dis;
	}

}
