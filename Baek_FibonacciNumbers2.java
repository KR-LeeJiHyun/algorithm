import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Baek_FibonacciNumbers2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		if(n == 0) {
			bw.write(0 + "\n");
			br.close();
			bw.flush();
			bw.close();
			return;
		}
		
		if(n == 1) {
			bw.write(1 + "\n");
			br.close();
			bw.flush();
			bw.close();
			return;
		}
		
		BigInteger[] dp = new BigInteger[n + 1];
		dp[0] = new BigInteger("0");
		dp[1] = new BigInteger("1");
		for(int idx = 2; idx <= n; ++idx) dp[idx] = dp[idx - 1].add(dp[idx - 2]);
		
		bw.write(dp[n] + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
