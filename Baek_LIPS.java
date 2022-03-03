import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_LIPS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] seq = new int[N];
		
		
		for(int idx = 0; idx < N; ++idx) seq[idx] = Integer.parseInt(st.nextToken());
		
		/*
		2차원 버전 152ms
		int[][] dp = new int[2][N];
		dp[0][0] = 0;
		dp[1][0] = 1;
		for(int idx = 1; idx < N; ++idx) {
			dp[1][idx] = 1;
			for(int s_idx = 0; s_idx < idx; ++s_idx) {
				if(seq[s_idx] < seq[idx]) dp[1][idx] = Math.max(dp[1][idx], dp[1][s_idx] + 1);
				else dp[0][idx] = Math.max(dp[0][idx], dp[1][s_idx]);
			}
		}
		int answer = Math.max(dp[0][N-1], dp[1][N-1]);
		*/
		
		//1차원 버전 152ms
		int answer = 1;
		int[] dp = new int[N];
		dp[0] = 1;
		for(int idx = 1; idx < N; ++idx) {
			dp[idx] = 1;
			for(int s_idx = 0; s_idx < idx; ++s_idx) {
				if(seq[s_idx] < seq[idx]) dp[idx] = Math.max(dp[idx], dp[s_idx] + 1);
			}
			answer = Math.max(answer, dp[idx]);
		}
		
		bw.write(Integer.toString(answer));
		
		br.close();
        bw.flush();
        bw.close();
	}

}
