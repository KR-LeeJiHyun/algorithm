import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_TreeAndQuery {
	
	static int N, R, Q;
	static int[] dp;
	static ArrayList<Integer>[] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st_NRQ = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st_NRQ.nextToken());
		R = Integer.parseInt(st_NRQ.nextToken());
		Q = Integer.parseInt(st_NRQ.nextToken());
		dp = new int[N + 1];
		visited = new boolean[N + 1];
		map = new ArrayList[N + 1];
		
		for(int idx = 1; idx <= N; ++idx) map[idx] = new ArrayList<>();
		
		for(int idx = 1; idx < N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken()), V = Integer.parseInt(st.nextToken());
			map[U].add(V);
			map[V].add(U);
		}
		
		visited[R] = true;
		dfs(R);
		
		StringBuilder sb = new StringBuilder();
		for(int idx = 0; idx < Q; ++idx) {
			int q = Integer.parseInt(br.readLine());
			sb.append(dp[q]);
			sb.append('\n');
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
		
	}

	private static int dfs(int current) {
		
		for(int idx = 0; idx < map[current].size(); ++idx) {
			int next = map[current].get(idx);
			if(!visited[next]) {
				visited[next] = true;
				dp[current] += dfs(next);
			}
		}
		
		dp[current] += 1;
		return dp[current];
		
	}

}
