import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_MotaeSolo {

	static class Node implements Comparable<Node>{
		int start;
		int dest;
		int weight;

		Node(int start,int dest, int weight) {
			this.start = start;
			this.dest = dest;
			this.weight = weight;
		}

		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken()), M = Integer.parseInt(stNM.nextToken());
		StringTokenizer st = new StringTokenizer(br.readLine());
		String[] sex = new String[N];
		
		for(int idx = 0; idx < N; ++idx) sex[idx] = st.nextToken(); 
		
		PriorityQueue<Node> edge = new PriorityQueue<>();
		for(int idx = 0; idx < M; ++idx) {
			StringTokenizer stEdge = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stEdge.nextToken()) - 1, dest = Integer.parseInt(stEdge.nextToken()) - 1, cost = Integer.parseInt(stEdge.nextToken());
			if(!sex[start].equals(sex[dest])) edge.add(new Node(start, dest, cost));
		}
		
		bw.write(kruskal(N, edge) + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int kruskal(int N, PriorityQueue<Node> edge) {
		int result = 0, cnt = 0;
		parent = new int[N];
		
		for(int idx = 0; idx < N; ++idx) parent[idx] = idx;
		
		while(!edge.isEmpty()) {
			Node node = edge.poll();
			int start = node.start, dest = node.dest, weight = node.weight;
			if (find(start) != find(dest)) {
				union(start, dest);
				++cnt;
				result += weight;
			}
		}
		
		if(cnt != N - 1) return -1;
		return result;
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	private static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return find(parent[x]);
	}

}
