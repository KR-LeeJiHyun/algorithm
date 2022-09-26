import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_Fibonacci7 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MOD = 1000000007, MAX = 1000000;
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[MAX + 1];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int idx = 2; idx <= n; ++idx) dp[idx] = (dp[idx - 1] + dp[idx - 2]) % MOD;
		
		bw.write(Integer.toString(dp[n]));
		br.close();
		bw.flush();
		bw.close();
		
	}

}
