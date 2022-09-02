import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_StoneGame4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int MAX = 1000;
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[MAX + 1];
		String[] players = {"SK", "CY"};
		
		dp[1] = 1;
		dp[2] = 0;
		dp[3] = 1;
		dp[4] = 0;
		
		for(int idx = 5; idx <= N; ++idx) {
			if(dp[idx - 1] == 1  || dp[idx - 3] == 1 || dp[idx - 4] == 1) dp[idx] = 0;
			else dp[idx] = 1;
		}
		
		bw.write(players[dp[N]]);
		br.close();
		bw.flush();
		bw.close();
		
	}

}
