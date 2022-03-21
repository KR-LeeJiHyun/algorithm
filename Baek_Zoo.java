import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_Zoo {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int MOD = 9901;
		int N = Integer.parseInt(br.readLine());
		
		if(N != 1) {
			int[][] dp = new int[N + 1][3];
			dp[1][0] = 1;
			dp[1][1] = 1;
			dp[1][2] = 1;

			for(int n = 2; n <= N; ++n) {
				dp[n][0] = (dp[n - 1][0] + dp[n-1][1] + dp[n - 1][2]) % MOD;
				dp[n][1] = (dp[n - 1][0] + dp[n - 1][2]) % MOD;
				dp[n][2] = (dp[n - 1][0] + dp[n - 1][1]) % MOD;
			}
			
			bw.write((dp[N][0] + dp[N][1] + dp[N][2]) % MOD + "\n");
		}
		else bw.write("3");
		br.close();
		bw.flush();
		bw.close();
	}
}
