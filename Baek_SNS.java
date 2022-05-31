import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_SNS {
	
	static int[][] dp;
	static ArrayList<Integer>[] map;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][2];
		map = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for(int idx = 1; idx <= N; ++idx) map[idx] = new ArrayList<Integer>();
		for(int idx = 0; idx < N - 1; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
			map[u].add(v);
			map[v].add(u);
		}
		
		dfs(1);
		
		bw.write(Math.min(dp[1][0], dp[1][1]) + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

	private static void dfs(int node) {
		visited[node] = true;
		dp[node][1] = 1;
		
		for(int idx = 0; idx < map[node].size(); ++idx) {
			int next = map[node].get(idx);
			if(!visited[next]) {
				dfs(next);
				dp[node][0] += dp[next][1];
				dp[node][1] += Math.min(dp[next][0], dp[next][1]);
			}
		}
	}

}
