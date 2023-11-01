import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek트리의지름 {
	
	static class Edge {
		int v;
		int dis;
		
		Edge(int v, int dis) {
			this.v = v;
			this.dis = dis;
		}
	}
	static boolean[] visited;
	static ArrayList<Edge> edges[];
	static int start = 0;
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int V = Integer.parseInt(br.readLine());
		edges = new ArrayList[V + 1];
		
		for(int idx = 0; idx < V; ++idx) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(input.nextToken());
			edges[c] = new ArrayList();
			int v = Integer.parseInt(input.nextToken());
			while(v != -1) {
				int dis = Integer.parseInt(input.nextToken());
				edges[c].add(new Edge(v, dis));
				v = Integer.parseInt(input.nextToken());
			}
		}
		
		visited = new boolean[V + 1];
		visited[1] = true;
		dfs(1, 0);
		
		int answer = 0;
		visited = new boolean[V + 1];
		visited[start] = true;
		answer = dfs(start, 0);
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
		
	}

	private static int dfs(int current, int sum) {
		
		int result = 0;
		
		for(int idx = 0; idx < edges[current].size(); ++idx) {
			Edge e = edges[current].get(idx);
			int next = e.v;
			if(!visited[next]) {
				visited[next] = true;
				result = Math.max(result, dfs(next, sum + e.dis));
			}
		}
		
		sum = Math.max(sum, result);
		
		if(max < sum) {
			start = current;
			max = sum;
		}
		
		return sum;
	}

}
