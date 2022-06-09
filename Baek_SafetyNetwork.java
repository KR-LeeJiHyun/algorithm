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

public class Baek_SafetyNetwork {
	
	static class Pair implements Comparable<Pair>{
		int n;
		int cost;
		int prev;
		
		Pair(int prev, int n, int cost) {
			this.n = n;
			this.cost = cost;
			this.prev = prev;
		}
		
		public int compareTo(Pair o) {
			return this.cost - o.cost;
		}
	}
	
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stNM.nextToken()), m = Integer.parseInt(stNM.nextToken());
		int[][] map = new int[n][n];
		Queue<Integer> q = new LinkedList<>();
		
		for(int idx = 0; idx < m; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			q.add(Integer.parseInt(st.nextToken()));
			q.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int row = 0; row < n; ++row) {
			StringTokenizer stMap = new StringTokenizer(br.readLine());
			for(int col = 0; col < n; ++col) map[row][col] = Integer.parseInt(stMap.nextToken());
		}
		
		while(!q.isEmpty()) {
			int n1 = q.poll() - 1, n2 = q.poll() - 1;
			map[n1][n2] = 0;
			map[n2][n1] = 0;
		}
		
		list = new ArrayList<>();
		int cost = prim(n, map);
		
		bw.write(cost + " " + (list.size() / 2) + "\n");
		for(int idx = 0; idx < list.size(); idx += 2) bw.write((list.get(idx) + 1) + " " + (list.get(idx + 1) + 1) + "\n");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int prim(int v, int[][] map) {
		int result = 0;
		Queue<Pair> q = new LinkedList();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[v];
		q.add(new Pair(0, 1, 0));
		
		while(!q.isEmpty()) {
			Pair c = q.poll();
			int prev = c.prev;
			int n = c.n;
			int cost = c.cost;

			if(visited[n]) continue;
			
			result += cost;
			
			if(cost != 0) {
				list.add(n);
				list.add(prev);
			}
			
			visited[n] = true;
			for(int col = 2; col < v; ++col) {
				if(!visited[col]) pq.add(new Pair(n, col, map[n][col]));
			} 
			
			while(!pq.isEmpty()) {
				Pair p = pq.poll();
				if(!visited[p.n]) {
					q.add(p);
					break;
				}
			}
		}
		
		return result;
	}

}
