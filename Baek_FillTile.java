import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_FillTile {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MAX = 25;
		int[] dp = new int[MAX];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 5;
		
		for(int idx = 3; idx < MAX; ++idx) {
			dp[idx] = dp[idx - 1] + dp[idx - 2] * 4;
			for(int sIdx = 3; idx - sIdx > -1; ++sIdx) {
				if(sIdx % 2 == 0) dp[idx] += dp[idx - sIdx] * 3;
				else dp[idx] += dp[idx - sIdx] * 2;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		while(T > 0) {
			--T;
			int N = Integer.parseInt(br.readLine());
			bw.write(String.valueOf(dp[N]));
			bw.write('\n');
		}
		br.close();
		bw.close();

	}

}
