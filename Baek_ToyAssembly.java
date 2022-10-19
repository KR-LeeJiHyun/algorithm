import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_ToyAssembly {
	
	static int[][] dp;
	static boolean[] visited;
	static boolean[] basic;
	static int N;
	static int M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		basic = new boolean[N + 1];
		Arrays.fill(basic, true);
		
		for(int idx = 0; idx < M; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int middleNum = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			basic[num] = false;
			dp[num][middleNum] = cnt;
		}
		
		dfs(N);
		
		StringBuilder answer = new StringBuilder();
		for(int idx = 1; idx <= N; ++idx) {
			if(dp[N][idx] != 0) {
				answer.append(idx);
				answer.append(' ');
				answer.append(dp[N][idx]);
				answer.append('\n');
			}
		}
		
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();

	}

	private static void dfs(int num) {
		if(visited[num]) return;
		visited[num] = true;
		for(int idx = 1; idx <= N; ++idx) {
			if(dp[num][idx] != 0 && !basic[idx]) {
				dfs(idx);
				for(int sIdx = 1; sIdx <= N; ++sIdx) dp[num][sIdx] += dp[idx][sIdx] * dp[num][idx];
				dp[num][idx] = 0;
			}
		}
	}

}
