import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_MSTGame {
	static class Node implements Comparable<Node> {
		int start;
		int dest;
		int cost;
		
		public Node(int start, int dest, int cost) {
			this.start = start;
			this.dest = dest;
			this.cost = cost;
		}

		public int compareTo(Node o) {
			return (this.cost - o.cost);
		}
	}
	
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNMK = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNMK.nextToken()), M = Integer.parseInt(stNMK.nextToken()), K = Integer.parseInt(stNMK.nextToken());
		ArrayList<Node> edge = new ArrayList<>();
		for(int idx = 0; idx < M; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()), dest = Integer.parseInt(st.nextToken()), cost = idx + 1;
			edge.add(new Node(start, dest, cost));
		}
		
		int answer = -1;
		for(int idx = 0; idx < K; ++idx) {
			if(answer == 0) bw.write(answer + " ");
			else {
				answer = kruskal(N, edge);
				bw.write(answer + " ");
				edge.remove(0);
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int kruskal(int N, ArrayList<Node> edge) {
		int result = 0;
		parent = new int[N + 1];
		
		for(int idx = 0; idx <= N; ++idx) parent[idx] = idx;
		int cnt = 0;
		
		for(int idx = 0; idx < edge.size(); ++idx) {
			Node node = edge.get(idx);
			int start = node.start, dest = node.dest;
			int cost = node.cost;
            int fs = find(start), fd = find(dest);
            
			if (fs != fd) {
				union(fs, fd);
				result += cost;
				++cnt;
			}
		}
		
		if(cnt == N - 1) return result;
		else return 0;
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
