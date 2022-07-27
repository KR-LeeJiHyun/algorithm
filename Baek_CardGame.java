import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_CardGame {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st_A = new StringTokenizer(br.readLine()), st_B = new StringTokenizer(br.readLine());
		int [] A = new int[N + 1], B = new int[N + 1];
		int[][] dp = new int[N + 1][N + 1];
		int answer = 0;
		
		for(int idx = 0; idx < N; ++idx) {
			A[idx] = Integer.parseInt(st_A.nextToken());
			B[idx] = Integer.parseInt(st_B.nextToken());
		}
		
		for(int a_idx = 0; a_idx <= N; ++a_idx) {
			for(int b_idx = 1; b_idx <= N; ++b_idx) {
				int max = -1;
				if(a_idx > 0 && dp[a_idx - 1][b_idx] != -1) max = dp[a_idx - 1][b_idx];
				if(a_idx > 0 && b_idx > 0 && dp[a_idx - 1][b_idx - 1] != -1) max = Math.max(max, dp[a_idx - 1][b_idx - 1]);
				if(b_idx > 0 && A[a_idx] > B[b_idx - 1] && dp[a_idx][b_idx - 1] != -1) max = Math.max(max, dp[a_idx][b_idx - 1] + B[b_idx - 1]);
				
				dp[a_idx][b_idx] = max;
				answer = Math.max(answer, max);
			}
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();
		
	}

}
