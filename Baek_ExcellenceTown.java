import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Baek_ExcellenceTown {

	static final int LEN = 2;
	static int N;
	static int[] populations;
	static int[][] dp;
	static ArrayList<Integer>[] map;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		populations = new int[N + 1];
		dp = new int[N + 1][LEN];
		map = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 1; idx <= N; ++idx) {
			populations[idx] = Integer.parseInt(st.nextToken());
			map[idx] = new ArrayList<>();
		}

		for(int idx = 0; idx < N - 1; ++idx) {
			StringTokenizer st_link = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st_link.nextToken()), v = Integer.parseInt(st_link.nextToken());
			map[u].add(v);
			map[v].add(u);
		}

		dfs(1);

		int answer = Math.max(dp[1][0], dp[1][1]);
		StringBuilder sb = new StringBuilder();
		sb.append(answer);
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}

	private static void dfs(int node) {

		visited[node] = true;
		dp[node][1] = populations[node];
		for(int idx = 0; idx < map[node].size(); ++idx) {
			int next = map[node].get(idx);
			if(!visited[next]) {
				dfs(next);
				dp[node][0] += Math.max(dp[next][0], dp[next][1]);
				dp[node][1] += dp[next][0];
			}
		}
	}

}
