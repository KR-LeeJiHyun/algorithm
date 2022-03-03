import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_BridgePlacement {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long answer = 1;
			long N = Long.parseLong(st.nextToken()), M = Long.parseLong(st.nextToken());
			long[] dp = new long[(int)N + 1];
			dp[0] = 1;
			for(int idx = 1; idx <= N; ++idx) {
				dp[idx] = dp[idx - 1] * (M + 1 - idx) / idx;  
			}
			
			answer = dp[(int)N];
			bw.write(answer + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
