import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_PushBox {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()), answer = 1;
		int[] dp = new int[N], nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int idx = 0; idx < N; ++idx) nums[idx] = Integer.parseInt(st.nextToken());
		dp[0] = 1;
		for(int idx = 1; idx < N; ++idx) {
			int max = 0;
			for(int sIdx = 0; sIdx < idx; ++sIdx) {
				if(max < dp[sIdx] && nums[sIdx] < nums[idx]) max = dp[sIdx];
			}
			dp[idx] = max + 1;
			answer = Math.max(answer, dp[idx]);
		}
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
