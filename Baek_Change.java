import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baek_Change {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N + 1];
		Arrays.fill(dp, -1);
		if(N >= 2) dp[2] = 1;
		if(N >= 5) dp[5] = 1;
		
		for(int idx = 3; idx <= N; ++idx) {
			if(idx > 5 && dp[idx - 5] != -1) dp[idx] = dp[idx - 5] + 1;
			else if(dp[idx - 2] != -1) dp[idx] = dp[idx - 2] + 1;
		}
		
		bw.write(dp[N] + "\n");
		br.close();
		bw.flush();
		bw.close();

	}

}
