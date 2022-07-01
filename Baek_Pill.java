import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_Pill {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int PILLS = 30;
		long[] dp = new long[PILLS + 1];
		
		dp[0] = 1;
		dp[1] = 1;
	
		for(int pill = 2; pill <= PILLS; ++pill) {
			long cnt = 0;
			for(int before = 0; before < pill; ++before) cnt += dp[before]* dp[pill - 1 - before];
			dp[pill] = cnt;
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {

			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			sb.append(dp[N]);
			sb.append('\n');
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}

}
