import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Baek_GenerationsOfTribbles {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MAX = 67;
		BigInteger[] dp = new BigInteger[MAX + 1];
		dp[0] = BigInteger.valueOf(1);
		dp[1] = BigInteger.valueOf(1);
		dp[2] = BigInteger.valueOf(2);
		dp[3] = BigInteger.valueOf(4);
		
		for(int idx = 4; idx <= MAX; ++idx) dp[idx] = dp[idx - 1].add(dp[idx - 2].add(dp[idx - 3].add(dp[idx - 4])));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; ++t) {
			int N = Integer.parseInt(br.readLine());
			bw.write(dp[N] + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
