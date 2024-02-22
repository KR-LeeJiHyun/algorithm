import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek임계경로 {
	
	static class Node {
		int node;
		int dist;
		
		public Node(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int DIST = 0;
		final int CNT = 1;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] degree = new int[n + 1];
		int[][] dist = new int[n + 1][2];
		int[][] map = new int[n + 1][n + 1];
		
		for(int idx = 0; idx < m; ++idx) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(input.nextToken());
			int v = Integer.parseInt(input.nextToken());
			int w = Integer.parseInt(input.nextToken());
			map[u][v] = w;
			map[v][u] = -w;
			++degree[v];
		}
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(input.nextToken());
		int end = Integer.parseInt(input.nextToken());
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node c = q.poll();
			if(c.node == end) break;
			for(int next = 1; next <= n; ++next) {
				int cnd = map[c.node][next];
				int nd = dist[next][DIST];
				int nnd = cnd + c.dist;
				if(cnd > 0) {
					--degree[next];
					if(nd < nnd) {
						dist[next][DIST] = nnd;
						dist[next][CNT] = 1;
					}
					else if(nd == nnd) ++dist[next][CNT];
					if(degree[next] == 0) q.add(new Node(next, dist[next][DIST]));				
				}
			}
		}
		
		int answer = dist[end][CNT];
		boolean[] visited = new boolean[n + 1];
		q.clear();
		q.add(new Node(end, dist[end][DIST]));
		while(!q.isEmpty()) {
			Node c = q.poll();
			for(int next = 1; next <= n; ++next) {
				if(map[c.node][next] < 0 && dist[next][DIST] == dist[c.node][DIST] + map[c.node][next] && !visited[next]) {
					visited[next] = true;
					answer += dist[next][CNT];
					q.add(new Node(next, dist[c.node][DIST] + map[c.node][next]));
				} 
			}
		}
		
		bw.write(String.valueOf(dist[end][DIST]));
		bw.write('\n');
		bw.write(String.valueOf(answer));
		
		br.close();
		bw.close();
	}

}
