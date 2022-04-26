import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_1Grade {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int S = 21;
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N - 1][S];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		dp[0][start] = 1;
		for(int idx = 1; idx < N - 1; ++idx) {
			int num = Integer.parseInt(st.nextToken());
			for(int sIdx = 0; sIdx < S; ++sIdx) {
				if(dp[idx - 1][sIdx] > 0) {
					if(sIdx - num >= 0) dp[idx][sIdx - num] += dp[idx - 1][sIdx];
					if(sIdx + num < S) dp[idx][sIdx + num] += dp[idx - 1][sIdx];
				}
			}
		}
		int target = Integer.parseInt(st.nextToken());

		bw.write(dp[N - 2][target] + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
	
}
