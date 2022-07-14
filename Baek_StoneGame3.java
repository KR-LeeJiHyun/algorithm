import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_StoneGame3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int MAX = 1000;
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[MAX + 1];
		String[] players = {"SK", "CY"};
		
		dp[2] = 1;
		
		for(int idx = 5; idx <= N; ++idx) {
			dp[idx] = 1;
			if(dp[idx - 1] == 1 || dp[idx - 3] == 1 || dp[idx - 4] == 1) dp[idx] = 0;
		}
		
		bw.write(players[dp[N]] + "\n");
		br.close();
		bw.flush();
		bw.close();

	}

}
