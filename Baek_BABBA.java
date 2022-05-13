import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_BABBA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine());
		int[][] dp = new int[K + 1][2];
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for(int idx = 2; idx <= K; ++idx) {
			dp[idx][0] = dp[idx - 1][1];
			dp[idx][1] = dp[idx - 1][0] + dp[idx - 1][1];
		}

		bw.write(dp[K][0] + " " + dp[K][1] + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
