import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_PinkPloid {
	
	static class Edge implements Comparable<Edge> {
		int start;
		int dest;
		int cost;
		
		public Edge(int start, int dest, int cost) {
			this.start = start;
			this.dest = dest;
			this.cost = cost;
		}

		public int compareTo(Edge o) {
			return (int)(this.cost - o.cost);
		}
	}
	
	static int[] parent;
	static ArrayList<Integer>[] answers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		for(int idx = 0; idx < N - 1; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int s_idx = idx + 1; s_idx < N; ++s_idx) edges.add(new Edge(idx, s_idx, Integer.parseInt(st.nextToken()))); 
		}
		
		kruskal(N, edges);
		
		for(int idx = 0; idx < N; ++idx) {
			Collections.sort(answers[idx]);
			bw.write(answers[idx].size() + " ");
			for(int node : answers[idx]) bw.write((node + 1) + " ");
			bw.write("\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void kruskal(int N, PriorityQueue<Edge> edges) {
		parent = new int[N];
		answers = new ArrayList[N];
		
		for(int idx = 0; idx < N; ++idx) {
			parent[idx] = idx;
			answers[idx] = new ArrayList<>();
		}
		
		while(!edges.isEmpty()) {
			Edge edge = edges.poll();
			int start = edge.start, dest = edge.dest;
            int fs = find(start), fd = find(dest);
            
			if (fs != fd) {
				union(fs, fd);
				answers[start].add(dest);
				answers[dest].add(start);
			}
		}
	}

	private static void union(int a, int b) {
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
