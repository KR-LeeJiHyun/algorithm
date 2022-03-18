import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_SumDiv {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MOD = 1000000000;
		int N = 0, K = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		long[][] dp = new long[K + 1][N + 1];
		Arrays.fill(dp[1], 1);
		
		for(int k = 1; k <= K; ++k) {
			for(int n = 0; n <= N; ++n) {
				for(int cost = 0; cost <= n; ++cost) {
					dp[k][n] += dp[k - 1][n - cost] * dp[1][cost] % MOD;
				}
				dp[k][n] %= MOD;
			}
		}
		
		bw.write(dp[K][N] + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
