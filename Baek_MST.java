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


public class Baek_MST {
	
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
		
		StringTokenizer stVE = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(stVE.nextToken()), E = Integer.parseInt(stVE.nextToken());
		ArrayList<Integer>[] map = new ArrayList[V + 1]; 
		for(int idx = 1; idx <= V; ++idx) map[idx] = new ArrayList<>();
		for(int idx = 0; idx < E; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
			map[A].add(B);
			map[A].add(C);
			map[B].add(A);
			map[B].add(C);
		}
		
		bw.write(prim(V, E, map) + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

	private static int prim(int v, int e, ArrayList<Integer>[] map) {
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
