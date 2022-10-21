import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_Tile3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		final long MOD = 1000000007;
		
		long[] dp = new long[Math.max(N + 1, 4)];
		long[] dp2 = new long[Math.max(N + 1, 4)];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 7;
		dp[3] = 22;
		dp2[3] = 1; 
		for(int idx = 4; idx <= N; ++idx) {
			dp2[idx] = dp2[idx - 1] + dp[idx - 3];
			dp[idx] = dp[idx - 2] * 3 + dp[idx - 1] * 2 + dp2[idx] * 2;
			dp[idx] %= MOD;
		}
		
		bw.write(Long.toString(dp[N]));
		br.close();
		bw.flush();
		bw.close();

	}

}
