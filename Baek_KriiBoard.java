import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_KriiBoard {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MAX = 101;
		long[] dp = new long[MAX];
		dp[1] = 1;
		
		for(int idx = 2; idx < MAX; ++idx) {
			dp[idx] = dp[idx - 1] + 1;
			int cnt = 2;
			for(int s_idx = idx - 3; s_idx > 0; --s_idx) {
				dp[idx] = Math.max(dp[idx], dp[s_idx] * cnt++);
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		bw.write(dp[N] + "\n");
		br.close();
		bw.flush();
		bw.close();
		
	}

}
