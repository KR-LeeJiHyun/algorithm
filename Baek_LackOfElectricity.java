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


public class Baek_LackOfElectricity {
	
	static class Pair implements Comparable<Pair>{
		int n;
		int weight;
		
		Pair(int n, int weight) {
			this.n = n;
			this.weight = weight;
		}
		
		public int compareTo(Pair o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st_NMK = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st_NMK.nextToken()), M = Integer.parseInt(st_NMK.nextToken()), K = Integer.parseInt(st_NMK.nextToken());
		ArrayList<Integer> sList = new ArrayList<>();
		StringTokenizer st_gen = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < K; ++idx) sList.add(Integer.parseInt(st_gen.nextToken()));
			
		ArrayList<Integer>[] map = new ArrayList[N + 1];
		
		for(int idx = 1; idx <= N; ++idx) map[idx] = new ArrayList<>();
		
		for(int idx = 0; idx < M; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken()), node2 = Integer.parseInt(st.nextToken()), cost = Integer.parseInt(st.nextToken());
			map[node1].add(node2);
			map[node1].add(cost);
			map[node2].add(node1);
			map[node2].add(cost);
		}
		
		bw.write(prim(N, map, K, sList) + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int prim(int v, ArrayList<Integer>[] map, int k, ArrayList<Integer> sList) {
		int result = 0;
		Queue<Integer> q = new LinkedList();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[v + 1];
		
		for(int i = 0; i < k; ++i) {
			int c = sList.get(i);
			for(int idx = 0; idx < map[c].size(); idx += 2) {
				int node = map[c].get(idx);
				if(!visited[node]) pq.add(new Pair(node, map[c].get(idx + 1)));
			}
			visited[c] = true;
		}
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			if(!visited[p.n]) {
				q.add(p.n);
				q.add(p.weight);
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int c = q.poll();
			int weight = q.poll();

			if(visited[c]) { 	
				continue;
			}
			
			result += weight;
			visited[c] = true;
			for(int idx = 0; idx < map[c].size(); idx += 2) {
				int node = map[c].get(idx);
				if(!visited[node]) pq.add(new Pair(node, map[c].get(idx + 1)));
			}
			
			while(!pq.isEmpty()) {
				Pair p = pq.poll();
				if(!visited[p.n]) {
					q.add(p.n);
					q.add(p.weight);
					break;
				}
			}
		}
		
		return result;
	}

}
