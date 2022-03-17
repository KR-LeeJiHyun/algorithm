import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_Coin2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = 0, k = 0;
		final int MAX = 100001;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[MAX];
		Arrays.fill(dp, MAX);
		for(int idx = 0; idx < n; ++idx) {
			dp[Integer.parseInt(br.readLine())] = 1;
		}
		
		for(int idx = 2; idx <= k; ++idx) {
			for(int sIdx = 1; sIdx < idx; ++sIdx) {
				dp[idx] = Math.min(dp[idx], dp[sIdx] + dp[idx - sIdx]);
			}
		}
		
		if(dp[k] != MAX) bw.write(dp[k] + "\n");
		else bw.write("-1\n");
		
		br.close();
		bw.flush();
		bw.close();
	}
}
