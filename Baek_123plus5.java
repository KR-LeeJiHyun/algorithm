import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_123plus5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int MAX = 100000, MOD = 1000000009;
		int[][] dp = new int[MAX + 1][4];
		
		dp[0][0] = 1;
		dp[1][1] = 1;
		
		for(int idx = 2; idx <= MAX; ++idx) {
			for(int plus = 1; plus <= 3; ++plus) {
				if(idx - plus >= 0) {
					for(int sIdx = 0; sIdx <=3; ++sIdx) {
						if(plus != sIdx) dp[idx][plus] += dp[idx - plus][sIdx];
						dp[idx][plus] %= MOD;
					}
				}
			}
		}
			
		int T = Integer.parseInt(br.readLine());
		for(int idx = 0; idx < T; ++idx) {
			int N = Integer.parseInt(br.readLine());
			int answer = 0;
			for(int plus = 0; plus <= 3; ++plus) {
				answer += dp[N][plus];
				answer %= MOD;
			} 
			bw.write(answer + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
