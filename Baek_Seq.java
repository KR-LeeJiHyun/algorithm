import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Seq {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) seq[idx] = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N][2];
		dp[0][0] = 1;
		dp[0][1] = 1;
		int answer = 1;
		for(int idx = 1; idx < N; ++idx) {
			dp[idx][0] = 1;
			dp[idx][1] = 1;
			if(seq[idx] <= seq[idx - 1]) dp[idx][0] = dp[idx - 1][0] + 1;
			if(seq[idx] >= seq[idx - 1]) dp[idx][1] = dp[idx - 1][1] + 1;
			
			answer = Math.max(answer, Math.max(dp[idx][0], dp[idx][1]));
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
