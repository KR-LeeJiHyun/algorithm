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

public class Baek_MakeConstellation {

	static class Pair implements Comparable<Pair>{
		int n;
		double weight;
		
		Pair(int n, double weight) {
			this.n = n;
			this.weight = weight;
		}
		
		public int compareTo(Pair o) {
			return (int)(this.weight - o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Double>[] map = new ArrayList[N]; 
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[idx] = new ArrayList<>();
			map[idx].add(Double.parseDouble(st.nextToken()));
			map[idx].add(Double.parseDouble(st.nextToken()));
		}
		
		bw.write(String.format("%.2f",prim(N, map)) + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

	private static double prim(int n, ArrayList<Double>[] map) {
		double result = 0;
		Queue<Pair> q = new LinkedList();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n];
		q.add(new Pair(0, 0.0f));
		
		while(!q.isEmpty()) {
			Pair cq = q.poll();
			int c = cq.n;
			double weight = cq.weight;
			if(visited[(int)c]) continue;
			
			result += weight;
			visited[c] = true;
			for(int idx = 0; idx < n; ++idx) {
				if(idx != c) {
					pq.add(new Pair(idx, distance(c, idx, map)));
				}
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

	private static double distance(int current, int next, ArrayList<Double>[] map) {
		double result = 0;
		double x0 = map[current].get(0), y0 = map[current].get(1),x1 = map[next].get(0), y1 = map[next].get(1);
		result = Math.sqrt(Math.pow(Math.abs(x1 - x0), 2) + Math.pow(Math.abs(y1 - y0), 2));
		return result;
	}

}
