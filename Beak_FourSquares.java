import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Beak_FourSquares {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int num = 1;
		for(int idx = 1; idx <= N; ++idx) {
			if(idx == num*num) {
				dp[idx] = 1;
				++num;
			}
			else {
				dp[idx] = Integer.MAX_VALUE;
				for(int sIdx = 1; sIdx*sIdx < idx; ++sIdx) {
					dp[idx] = Math.min(dp[idx], dp[idx - sIdx*sIdx] + dp[sIdx*sIdx]);
				}
			}
		}
		
		bw.write(dp[N] + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
