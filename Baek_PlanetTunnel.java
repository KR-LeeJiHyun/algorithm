import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_PlanetTunnel {

	static class Pair implements Comparable<Pair>{
		int n;
		int coordinate;

		Pair(int n, int coordinate) {
			this.n = n;
			this.coordinate = coordinate;
		}

		public int compareTo(Pair o) {
			return this.coordinate - o.coordinate;
		}
	}

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

		int N = Integer.parseInt(br.readLine());

		ArrayList<Pair>x = new ArrayList<>(), y = new ArrayList<>(), z = new ArrayList<>();
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x.add(new Pair(idx, Integer.parseInt(st.nextToken())));
			y.add(new Pair(idx, Integer.parseInt(st.nextToken())));
			z.add(new Pair(idx, Integer.parseInt(st.nextToken())));
		}

		Collections.sort(x);
		Collections.sort(y);
		Collections.sort(z);

		PriorityQueue<Node> edge = new PriorityQueue<Node>(new Comparator<Node>() {@Override
			public int compare(Node o1, Node o2) {
				return o1.weight - o2.weight;
			}
		});

		for(int idx = 0; idx < N - 1; ++idx) {
			edge.add(new Node(x.get(idx).n, x.get(idx + 1).n, Math.abs(x.get(idx).coordinate - x.get(idx + 1).coordinate)));
			edge.add(new Node(y.get(idx).n, y.get(idx + 1).n, Math.abs(y.get(idx).coordinate - y.get(idx + 1).coordinate)));
			edge.add(new Node(z.get(idx).n, z.get(idx + 1).n, Math.abs(z.get(idx).coordinate - z.get(idx + 1).coordinate)));
		}
		
		bw.write(kruskal(N, edge) + "\n");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int kruskal(int N, PriorityQueue<Node> edge) {
		int result = 0;
		parent = new int[N];
		
		for(int idx = 0; idx < N; ++idx) parent[idx] = idx;
		
		while(!edge.isEmpty()) {
			Node node = edge.poll();
			int start = node.start, dest = node.dest, weight = node.weight;
			if (find(start) != find(dest)) {
				union(start, dest);
				result += weight;
			}
		}
		
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
