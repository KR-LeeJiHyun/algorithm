import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_BoringFibonacci {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MOD = 1000000007;
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[51];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int idx = 2; idx <= N; ++idx) dp[idx] = (dp[idx - 1] + dp[idx - 2] + 1) % MOD;
		
		bw.write(String.valueOf(dp[N]));
		br.close();
		bw.close();
		
	}

}
