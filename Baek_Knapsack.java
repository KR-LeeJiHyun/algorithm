import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Knapsack {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNK = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNK.nextToken()), K = Integer.parseInt(stNK.nextToken());
		int[] w = new int[N + 1], v = new int[N + 1];
		for(int idx = 1; idx <= N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w[idx] = Integer.parseInt(st.nextToken());
			v[idx] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N + 1][K + 1];
		
		for(int n = 1; n <= N; ++n) {
			for(int k = 1; k <= K; ++k) {
				dp[n][k] = dp[n - 1][k];
				if(w[n] <= k) {
					dp[n][k] = Math.max(dp[n][k], dp[n - 1][k - w[n]] + v[n]);
				}
			}
		}
		
		bw.write(dp[N][K] + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
