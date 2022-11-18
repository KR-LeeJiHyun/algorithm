import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_Handshake {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MOD = 10;
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		dp[1] = 1;
		for(int idx = 2; idx <= N; ++idx) {
			if(idx != 2) dp[idx] = (dp[idx - 1] + dp[idx - 2]) % MOD;
			else dp[idx] = 2;
		}
		bw.write(Integer.toString(dp[N]));
		br.close();
		bw.flush();
		bw.close();

	}

}
