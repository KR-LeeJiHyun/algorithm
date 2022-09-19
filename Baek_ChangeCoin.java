import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_ChangeCoin {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[][] dp = new int[k + 1][T + 1];
		dp[0][0] = 1;
		for(int idx = 1; idx <= k; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int coin = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			for(int cash = 0; cash <= T; ++cash) {
				dp[idx][cash] = dp[idx - 1][cash];
			}
			for(int cnt = 1; cnt <= C; ++cnt) {
				int currentCash = cnt * coin;
				for(int cash = currentCash; cash <= T; ++cash) {
					dp[idx][cash] += dp[idx - 1][cash - currentCash];
				}
			} 
		}
		
		bw.write(Integer.toString(dp[k][T]));
		br.close();
		bw.flush();
		bw.close();
	}

}
