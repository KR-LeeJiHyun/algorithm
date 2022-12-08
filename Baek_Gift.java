import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_Gift {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MOD = 1000000000;
		final int MAX = 1000000;
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[MAX + 1];
		dp[1] = 0;
		dp[2] = 1;
		
		for(int idx = 3; idx <= N; ++idx) dp[idx] = ((idx - 1) * (dp[idx - 1] + dp[idx - 2])) % MOD;
		
		bw.write(String.valueOf(dp[N]));
		br.close();
		bw.close();

	}

}
