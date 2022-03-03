import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_123Plus {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; ++t) {
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int[N + 1];
			dp[0] = 1;
			dp[1] = 1;
			
			for(int idx = 2; idx < N + 1; ++idx) {
				if(idx > 2) dp[idx] = dp[idx - 1] + dp[idx - 2] + dp[idx - 3];
				else dp[idx] = dp[idx - 1] + dp[idx - 2];
			}
			
			bw.write(dp[N] + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
