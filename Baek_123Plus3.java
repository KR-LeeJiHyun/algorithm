import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_123Plus3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int mod = 1000000009;
		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; ++t) {
			int n = Integer.parseInt(br.readLine());
			if(n > 2) {
				long[] dp = new long[n + 1];
				dp[0] = 1;
				dp[1] = 1;
				dp[2] = 2;
				for(int idx = 3; idx <= n; ++idx) dp[idx] = (dp[idx - 1] + dp[idx - 2] + dp[idx - 3]) % mod;

				bw.write(dp[n] + "\n");
			}
			else bw.write(n + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
