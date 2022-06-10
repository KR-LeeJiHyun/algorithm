import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_ContinuousSum2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[][] dp = new int[N][3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int idx = 0; idx < N; ++idx) nums[idx] = Integer.parseInt(st.nextToken());
		
		dp[0][0] = nums[0];
		dp[0][1] = nums[0];
		int answer = nums[0];
		
		for(int idx = 1; idx < N; ++idx) {
			dp[idx][0] = Math.max(dp[idx - 1][0], dp[idx - 1][1]) + nums[idx];
			dp[idx][1] = nums[idx];
			dp[idx][2] = Math.max(dp[idx - 1][2] + nums[idx], Math.max(dp[idx - 1][0], dp[idx - 1][1]));
			answer = Math.max(answer, Math.max(dp[idx][0], Math.max(dp[idx][1], dp[idx][2])));
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();

	}

}
