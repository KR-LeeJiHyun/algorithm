import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_Padovan {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int MAX = 101;
		
		int[] dp = new int[MAX];
		int T = Integer.parseInt(br.readLine());
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		
		for(int idx = 6; idx < MAX; ++idx) {
			dp[idx] = dp[idx - 1] + dp[idx - 5];
		}
		
		for(int idx = 0; idx < T; ++idx) {
			int N = Integer.parseInt(br.readLine());
			bw.write(dp[N] + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
