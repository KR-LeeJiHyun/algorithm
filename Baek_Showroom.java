import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Showroom {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNS = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNS.nextToken());
		int S = Integer.parseInt(stNS.nextToken());
		final int H = 20000000;
		int maxH = 0;
		int[] dp = new int[H + 1];
		
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(input.nextToken());
			int c = Integer.parseInt(input.nextToken());
			dp[h] = Math.max(dp[h], c);
			maxH = Math.max(maxH, h);
		}
		
		for(int idx = 1; idx <= maxH; ++idx) {
			if(idx > S) dp[idx] += dp[idx - S];
			dp[idx] = Math.max(dp[idx], dp[idx - 1]);
		}
		
		
		bw.write(String.valueOf(dp[maxH]));
		br.close();
		bw.close();

	}

}
