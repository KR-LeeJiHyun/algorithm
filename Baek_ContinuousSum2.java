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
		
//		int N = Integer.parseInt(br.readLine());
//		int[] nums = new int[N];
//		int[][] dp = new int[N][3];
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		for(int idx = 0; idx < N; ++idx) nums[idx] = Integer.parseInt(st.nextToken());
//		
//		dp[0][0] = nums[0];
//		dp[0][1] = nums[0];
//		int answer = nums[0];
//		
//		for(int idx = 1; idx < N; ++idx) {
//			dp[idx][0] = Math.max(dp[idx - 1][0], dp[idx - 1][1]) + nums[idx];
//			dp[idx][1] = nums[idx];
//			dp[idx][2] = Math.max(dp[idx - 1][2] + nums[idx], Math.max(dp[idx - 1][0], dp[idx - 1][1]));
//			answer = Math.max(answer, Math.max(dp[idx][0], Math.max(dp[idx][1], dp[idx][2])));
//		}
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N], dp = new int[N], rdp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums[0] = Integer.parseInt(st.nextToken());
		dp[0] = nums[0];
		int answer = nums[0];
		
		for(int idx = 1; idx < N; ++idx) {
			nums[idx] = Integer.parseInt(st.nextToken());
			dp[idx] = Math.max(nums[idx], dp[idx - 1] + nums[idx]);
			answer = Math.max(answer, dp[idx]);
		}
		
		rdp[N - 1] = nums[N - 1];
		for(int idx = N - 2; idx >= 0; --idx) rdp[idx] = Math.max(nums[idx], rdp[idx + 1] + nums[idx]);
		
		for(int idx = 1; idx < N - 1; ++idx) answer = Math.max(answer, dp[idx - 1] + rdp[idx + 1]);
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();

	}

}
