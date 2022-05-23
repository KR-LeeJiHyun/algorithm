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

public class Baek_PowerShortage {
	
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
		
		while(true) {
			int sum = 0;
			StringTokenizer stVE = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(stVE.nextToken()), e = Integer.parseInt(stVE.nextToken());
			if(v == 0 && e == 0) break;
			ArrayList<Integer>[] map = new ArrayList[v];
			for(int idx = 0; idx < v; ++idx) map[idx] = new ArrayList<>();

			for(int idx = 0; idx < e; ++idx) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int node1 = Integer.parseInt(st.nextToken()), node2 = Integer.parseInt(st.nextToken()), cost = Integer.parseInt(st.nextToken());
				sum += cost;
				map[node1].add(node2);
				map[node1].add(cost);
				map[node2].add(node1);
				map[node2].add(cost);
			}
			
			bw.write(sum - prim(v, map) + "\n");	
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int prim(int v, ArrayList<Integer>[] map) {
		int result = 0;
		Queue<Integer> q = new LinkedList();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[v + 1];
		q.add(1);
		q.add(0);
		
		while(!q.isEmpty()) {
			int c = q.poll();
			int weight = q.poll();

			if(visited[c]) { 	
				continue;
			}
			
			result += weight;
			visited[c] = true;
			for(int idx = 0; idx < map[c].size(); idx += 2) pq.add(new Pair(map[c].get(idx), map[c].get(idx + 1)));
			
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
