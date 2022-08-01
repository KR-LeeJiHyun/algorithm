import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_123Plus4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		final int MAX = 10000;
		int[][] dp = new int[MAX + 1][4];
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		for(int idx = 4; idx <= MAX; ++idx) {
			for(int s_idx = 1; s_idx <= 3; ++s_idx) {
				for(int t_idx = 1; t_idx <= s_idx; ++t_idx) dp[idx][s_idx] += dp[idx - s_idx][t_idx];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; ++t) {
			int N = Integer.parseInt(br.readLine());
			int answer = 0;
			for(int idx = 1; idx <= 3; ++idx) answer += dp[N][idx];
			sb.append(answer);
			sb.append('\n');
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}

}
