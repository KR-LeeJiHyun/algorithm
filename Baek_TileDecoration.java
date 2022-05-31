import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_TileDecoration {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N + 1];
		dp[1] = 1;
		
		for(int idx = 2; idx <= N; ++idx) {
			dp[idx] = dp[idx - 1] + dp[idx - 2];
		}
		long answer = (dp[N]+ dp[N - 1]) * 2 + dp[N] * 2; 
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();

	}

}
