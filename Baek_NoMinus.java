import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baek_NoMinus {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MAX = 65, CNT = 10;
		int T = Integer.parseInt(br.readLine()), t = 0;
		StringBuilder sb = new StringBuilder();
		
		long[][] dp = new long [MAX][CNT];
		
		Arrays.fill(dp[1], 1);
		
		for(int digit = 2; digit < MAX; ++digit) {
			dp[digit][0] = 1;
			for(int cnt = 1; cnt < CNT; ++cnt) dp[digit][cnt] = dp[digit][cnt - 1] + dp[digit - 1][cnt];
		}
		
		while(t < T) {
			long sum = 0;
			int n = Integer.parseInt(br.readLine());
			for(int cnt = 0; cnt < CNT; ++cnt) sum += dp[n][cnt];
			sb.append(sum);
			sb.append('\n');
			++t;
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
		
	}

}
