import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_MaximumSubarray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; ++t) {
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			dp[0] = Integer.parseInt(st.nextToken());
			int answer = dp[0];
			
			for(int idx = 1; idx < N; ++idx) {
				dp[idx] = Integer.parseInt(st.nextToken());
				dp[idx] = Math.max(dp[idx], dp[idx - 1] + dp[idx]);
				answer = Math.max(answer, dp[idx]);
			}
			
			sb.append(answer);
			sb.append('\n');
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
