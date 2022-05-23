import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Coin {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; ++t) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(br.readLine());
			int[][] dp = new int[N + 1][M + 1];
			int[] coins = new int[N + 1];
			dp[0][0] = 1;
			for(int idx = 1; idx <= N; ++idx) {
				coins[idx] = Integer.parseInt(st.nextToken());
				dp[idx][0] = 1;
			}
			
			for(int n = 1; n <= N; ++n) {
				for(int m = 1; m <= M; ++m) {
					dp[n][m] = dp[n - 1][m];
					if(m >= coins[n]) dp[n][m] += dp[n][m - coins[n]]; 
				}
			}
			
			bw.write(dp[N][M] + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
