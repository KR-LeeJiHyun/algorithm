import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_GodOfSpace {
	
	static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Node{
		int n;
		double weight;
		
		public Node(int n, double weight) {
			this.n = n;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken()), M = Integer.parseInt(stNM.nextToken());
		
		Pair[] coor = new Pair[N];
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			coor[idx] = new Pair(x, y);
		}
		
		double[][] map = new double[N][N];
		
		for(int start = 0; start < N; ++start) {
			for(int dest = 0; dest < N; ++dest) {
				map[start][dest] = distance(start, dest, coor);
			}
		}
		
		for(int idx = 0; idx < M; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1, dest = Integer.parseInt(st.nextToken()) - 1;
			map[start][dest] = 0;
			map[dest][start] = 0;
		}
		
		bw.write(String.format("%.2f",prim(N, map)) + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static double prim(int n, double[][] map) {
		double result = 0;
		boolean[] visited = new boolean[n];
		Queue<Node> q = new LinkedList();
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return Double.compare(o1.weight, o2.weight);
			}
		});
		
		q.add(new Node(0, 0));
		
		while(!q.isEmpty()) {
			Node cq = q.poll();
			int c = cq.n;
			double weight = cq.weight;
			if(visited[(int)c]) continue;
			
			result += weight;
			visited[c] = true;
			for(int idx = 0; idx < n; ++idx) {
				if(idx != c && !visited[idx]) {
					pq.add(new Node(idx, map[c][idx]));
				}
			} 
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				if(!visited[node.n]) {
					q.add(node);
					break;
				}
			}
		}
		
		return result;
	}

	private static double distance(int current, int next, Pair[] coor) {
		double result = 0;
		double x0 = coor[current].x, y0 = coor[current].y,x1 = coor[next].x, y1 = coor[next].y;
		result = Math.sqrt(Math.pow(Math.abs(x1 - x0), 2) + Math.pow(Math.abs(y1 - y0), 2));
		return result;
	}
}


