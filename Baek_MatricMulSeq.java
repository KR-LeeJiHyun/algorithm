import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_MatricMulSeq {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); 
		int [][][] dp = new int[N][N][3];
		
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dp[idx][idx][1] = Integer.parseInt(st.nextToken());
			dp[idx][idx][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int cnt = 1; cnt < N; ++cnt) {
			for(int start = 0; start < N - cnt; ++start) {
				int end = start + cnt;
				for(int mid = start; mid < end; ++mid) {
					int result = dp[start][mid][0] + dp[mid + 1][end][0] + (dp[start][mid][1] * dp[start][mid][2] * dp[mid + 1][end][2]);
					if(dp[start][end][0] == 0 || dp[start][end][0] > result) {
						dp[start][end][0] = result;
						dp[start][end][1] = dp[start][mid][1];
						dp[start][end][2] = dp[mid + 1][end][2];
					}
				}
			}
		}
		
		bw.write(dp[0][N - 1][0] + "\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
