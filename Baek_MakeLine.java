import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_MakeLine {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()), max = 0;
		int[] nums = new int[N + 1];
		for(int idx = 1; idx <= N; ++idx) nums[idx] = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		dp[1] = 1;
		for(int idx = 2; idx <= N; ++idx) {
			dp[idx] = 1;
			for(int sIdx = 1; sIdx < idx; ++sIdx) {
				if(nums[sIdx] < nums[idx]) dp[idx] = Math.max(dp[idx], dp[sIdx] + 1);
			}
			max = Math.max(max, dp[idx]);
		}
		
		bw.write(N - max + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
