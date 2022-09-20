import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_LikeFibonacci {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n + 1];
		
		for(int idx = 1; idx <= n; ++idx) {
			if(idx > 3) dp[idx] = dp[idx - 1] + dp[idx - 3];
			else dp[idx] = 1;
		}
		
		bw.write(Long.toString(dp[n]));
		br.close();
		bw.flush();
		bw.close();

	}

}
