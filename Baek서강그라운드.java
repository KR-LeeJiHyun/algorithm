import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek서강그라운드 {
	
	static class Node implements Comparable<Node>{
		int city;
		int dis;
		
		public Node(int city, int dis) {
			this.city = city;
			this.dis = dis;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.dis - o.dis;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(input.nextToken());
		int m = Integer.parseInt(input.nextToken());
		int r = Integer.parseInt(input.nextToken());
		int[] items = new int[n + 1];
		
		input = new StringTokenizer(br.readLine());
		ArrayList<Node>[] map = new ArrayList[n + 1];
		for(int idx = 1; idx <= n; ++idx) {
			items[idx] = Integer.parseInt(input.nextToken());
			map[idx] = new ArrayList();
		}
		
		for(int idx = 0; idx < r; ++idx) {
			input = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(input.nextToken());
			int b = Integer.parseInt(input.nextToken());
			int dis = Integer.parseInt(input.nextToken());
			
			map[a].add(new Node(b, dis));
			map[b].add(new Node(a, dis));
		}
		
		int answer = 0;
		for(int start = 1; start <= n; ++start) {
			boolean[] visited = new boolean[n + 1];
			PriorityQueue<Node> q = new PriorityQueue();
			q.add(new Node(start, 0));
			
			int cnt = 0;
			while(!q.isEmpty()) {
				Node c = q.poll();
				if(visited[c.city]) continue;
				cnt += items[c.city];
				visited[c.city] = true;
				for(Node next : map[c.city]) {
					int nDis = next.dis + c.dis;
					if(nDis <= m && !visited[next.city]) {
						q.add(new Node(next.city, nDis));
					}
				}
			}
			
			answer = Math.max(answer, cnt);
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

}
