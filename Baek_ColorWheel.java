import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_ColorWheel {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		final int MOD = 1000000003;
		int N = Integer.parseInt(br.readLine()), K = Integer.parseInt(br.readLine());
		if(K != 1) {
			long[][] dp = new long[N + 1][K + 1];

			for(int idx = 1; idx <= N; ++idx) dp[idx][1] = idx;


			for(int color = 2; color <= K; ++color) {
				for(int cnt = color * 2 - 1; cnt <= N; ++cnt) {
					for(int idx = cnt - 2; idx >= color - 1; --idx) {
						dp[cnt][color] += dp[idx][color - 1];
						dp[cnt][color] %= MOD;
					}
				}
			}

			long answer = 0;

			answer += dp[N - 3][K - 1] * 2 % MOD;
			for(int idx = N - 4; idx >= K - 1; --idx) {
				answer += dp[idx][K - 1];
				answer %= MOD;
			}

			bw.write(answer + "\n");
		}

		else bw.write(N + "\n");

		br.close();
		bw.flush();
		bw.close();

	}

}
