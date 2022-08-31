import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_FibonacciExpand {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MAX = 1000001, MOD = 1000000000;
		
		int[][] dp = new int[MAX][2];
		
		dp[1][0] = 1;
		dp[1][1] = 1;
		
		for(int idx = 2; idx < MAX; ++idx) {
			dp[idx][0] = (dp[idx - 1][0] + dp[idx - 2][0]) % MOD;
			dp[idx][1] = (dp[idx - 2][1] - dp[idx - 1][1]) % MOD; 
		}
		
		int num = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		if(num >= 0) {
			if(dp[num][0] > 0 ) {
				sb.append(1);
				sb.append('\n');
				sb.append(dp[num][0]);
			}
			else {
				sb.append(0);
				sb.append('\n');
				sb.append(dp[num][0]);
			}
		}
		else {
			if(dp[Math.abs(num)][1] > 0) {
				sb.append(1);
				sb.append('\n');
				sb.append(dp[Math.abs(num)][1]);
			}
			else {
				sb.append(-1);
				sb.append('\n');
				sb.append(Math.abs(dp[Math.abs(num)][1]));
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}

}
