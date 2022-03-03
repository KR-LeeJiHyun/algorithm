import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Coin1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N + 1][K + 1];
		dp[0][0] = 1;
		
		for(int idx = 1; idx <= N; ++idx) {
			int coin = Integer.parseInt(br.readLine());
			dp[idx][0] = 1;
			for(int k = 1; k <= K; ++k) {
				for(int cnt = 0; cnt*coin <= k; ++cnt) {
					dp[idx][k] += dp[idx - 1][k - cnt*coin];
				}
			}
		}
		
		bw.write(dp[N][K] + "\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
