import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Baek_IgnitionType {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		BigInteger[] dp = new BigInteger[N + 1];
		
		dp[0] = BigInteger.ONE;
		
		for(int idx = 1; idx <= N; ++idx) {
			dp[idx] = BigInteger.ZERO;
			for(int n = 0; n < idx; ++n) dp[idx] = dp[idx].add(dp[n].multiply(dp[idx - n - 1]));
		}
		
		bw.write(dp[N].toString());
		br.close();
		bw.flush();
		bw.close();

	}

}
