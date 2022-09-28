import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.Arrays;

public class Baek_Bracket {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MAX = 5000, MOD = 1000000007;
		long[] dp = new long[MAX + 1];
		dp[0] = 1;
		dp[2] = 1;
		for(int idx = 4; idx <= MAX; idx += 2) {
			for(int sIdx = 0; sIdx <= idx - 2; sIdx += 2) {
				dp[idx] += dp[sIdx] * dp[idx - sIdx - 2];
				dp[idx] %= MOD;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int idx = 0; idx < T; ++idx) {
			int L = Integer.parseInt(br.readLine());
			bw.write(Long.toString(dp[L]));
			bw.write('\n');
		}
		br.close();
		bw.flush();
		bw.close();

	}
	
	/*
	dp + dfs 풀이
	괄호를 열고 닫고를 dfs를 통해서 구현하여 직접적으로 올바르게 짜여진 괄호를 만듬
	static final int MOD = 1000000007;
	static int[][] dp = new int[5001][5001]; // 여는 괄호 i개 닫는 괄호 j 개 있는 문자열

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < 5001; i++) {
			Arrays.fill(dp[i], -1);
		}
        
        solve(2500, 2500);

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());

			if (n % 2 == 0) {
				System.out.println(dp[n / 2][n / 2]); // 문자열 길이가 짝수면
			} else {
				System.out.println(0); // 문자열 길이가 홀수면
			}
		}
		
		br.close();

	}

	private static int solve(int i, int j) {
		// i : 여는 괄호 갯수 j : 닫는 괄호 갯수
		if (i > j) {
			return 0;
		}
		if (i < 0 || j < 0) {
			return 0;
		}
		if (i == 0 && j == 0) {
			return 1;
		}
		
		if (dp[i][j] != -1) {
			return dp[i][j] %= MOD;
		}

		dp[i][j] = 0;
		dp[i][j] = solve(i - 1, j) + solve(i, j - 1);
		dp[i][j] %= MOD;
		
		return dp[i][j];
	}*/

}
