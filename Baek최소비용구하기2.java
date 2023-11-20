import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek최소비용구하기2 {
	
	static class Node implements Comparable<Node>{
		int v;
		long d;
		int c;
		
		public Node(int v, long d, int c) {
			this.v = v;
			this.d = d;
			this.c = c;
		}
		
		public int compareTo(Node o) {
			return Long.compare(this.d, o.d);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final long INF = 100_000_000_000l;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		long[][] map = new long[n + 1][n + 1];
		for(int idx = 1; idx <= n; ++idx) {
			Arrays.fill(map[idx], INF);
		}
		
		for(int idx = 0; idx < m; ++idx) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(input.nextToken());
			int e = Integer.parseInt(input.nextToken());
			long d = Integer.parseInt(input.nextToken());
			
			if( map[s][e] > d) {
				map[s][e] = d;
			}
		}
		
		long answerD = 0;
		int answerC = 0;
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(input.nextToken());
		int e = Integer.parseInt(input.nextToken());
		long[] dis = new long[n + 1];
		int[] prev = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		Arrays.fill(dis, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0, 1));
		dis[s] = 0;
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			if(current.v == e) {
				answerD = current.d;
				answerC = current.c;
				break;
			}
			if(visited[current.v]) continue;
			visited[current.v] = true;
			
			for(int next = 1; next <= n; ++next) {
				long d = current.d + map[current.v][next];
				if(dis[next] > d) {
					dis[next] = d;
					prev[next] = current.v;
					pq.add(new Node(next, d, current.c + 1));
				}
			}
		}
		
		StringBuilder answer = new StringBuilder();
		answer.append(answerD);
		answer.append('\n');
		answer.append(answerC);
		answer.append('\n');
		Stack<Integer> stack = new Stack();
		while(e != 0) {
			stack.add(e);
			e = prev[e];
		}
		while(!stack.isEmpty()) {
			answer.append(stack.pop());
			answer.append(' ');
		}
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}

}
