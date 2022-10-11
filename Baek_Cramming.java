import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Cramming {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNT = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNT.nextToken());
		int T = Integer.parseInt(stNT.nextToken());
		int[][] dp = new int[N + 1][T + 1];
		
		for(int idx = 1; idx <= N; ++idx) {
			StringTokenizer stKS = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(stKS.nextToken());
			int S = Integer.parseInt(stKS.nextToken());
			
			for(int time = 1; time <= T; ++time) {
				dp[idx][time] = dp[idx - 1][time];
				if(K <= time) dp[idx][time] = Math.max(dp[idx][time], S + dp[idx - 1][time - K]);
			}
		}
		
		bw.write(Integer.toString(dp[N][T]));
		br.close();
		bw.flush();
		bw.close();
		
		
	}

}
