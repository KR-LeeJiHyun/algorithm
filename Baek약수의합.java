import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek약수의합 {
	
	static final int MAX = 1000001;
	static long[] dp = new long[MAX];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int idx = 1; idx < MAX; ++idx) {
			for(int sIdx = 1; sIdx * idx < MAX; ++sIdx) {
				dp[idx * sIdx] += idx;
			}
			dp[idx] += dp[idx - 1];
		}
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int idx = 0; idx < T; ++idx) {
			int num = Integer.parseInt(br.readLine());
			answer.append(dp[num]);
			answer.append('\n');
		}
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}

}
