import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Baek_Tiling {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MAX = 251;
		
		
		BigInteger[] dp = new BigInteger[MAX];
		dp[0] = BigInteger.ONE;
		dp[1] = BigInteger.ONE;
		dp[2] = BigInteger.valueOf(3);
		
		for(int idx = 3; idx < MAX; ++idx) dp[idx] = dp[idx - 1].add(dp[idx - 2].add(dp[idx - 2]));
		
		String input = "";
		while((input = br.readLine()) != null) {
			int n = Integer.parseInt(input);
			bw.write(dp[n].toString() + "\n");
		}
		
		
		br.close();
		bw.flush();
		bw.close();

	}

}
