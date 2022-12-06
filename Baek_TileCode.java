import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_TileCode {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MAX = 31;
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[MAX];
		dp[1] = 1;
		dp[2] = 3;
		int[][] dp2 = new int[MAX][MAX];
		for(int idx = 3; idx <= N; ++idx) dp[idx] = dp[idx - 1] + dp[idx - 2] * 2;
		if(N % 2 == 0) {
			dp2[N / 2][N / 2 + 1] = 3;
			dp2[N / 2 - 1][N / 2 + 2] = 5;
			int left = N / 2 - 2;
			int right = N / 2 + 3;
			while(left >= 1 && right <= N) {
				dp2[left][right] = dp2[left + 1][right - 1] + dp2[left + 2][right - 2] * 2;
				--left;
				++right;
			}
		}
		else {
			dp2[N / 2 + 1][N / 2 + 1] = 1;
			dp2[N / 2][N / 2 + 2] = 1;
			int left = N /2 - 1;
			int right = N / 2 + 3;
			while(left >= 1 && right <= N) {
				dp2[left][right] = dp2[left + 1][right - 1] + dp2[left + 2][right - 2] * 2;
				--left;
				++right;
			}
		}
		
		bw.write(Integer.toString((dp[N] - dp2[1][N]) / 2 + dp2[1][N]));
		br.close();
		bw.close();

	}

}
