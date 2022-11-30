import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_SumOfPowersOf2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MOD = 1000000000;
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N + 1];
		dp[1] = 1;
		for(int idx = 2; idx <= N; ++idx) {
			dp[idx] += dp[idx - 1];
			if(idx % 2 == 0) dp[idx] += dp[idx / 2];
			dp[idx] %= MOD;
		}
		
		bw.write(Long.toString(dp[N]));
		br.close();
		bw.close();

	}

}
