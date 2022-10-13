import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_DivdeSection {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] sum = new int[N + 1][N + 1];
		int[][] dp = new int[M + 1][N + 1];
		for(int idx = 1; idx <= N; ++idx) {
			int current =  Integer.parseInt(br.readLine());
			sum[idx][idx] = current;
			for(int sIdx = 1; sIdx < idx; ++sIdx) sum[sIdx][idx] = Math.max(current, sum[sIdx][idx - 1] + current);
			dp[1][idx] = Math.max(dp[1][idx - 1] + current, current); 
		}
		
		
		int answer = Integer.MIN_VALUE;
		for(int m = 2; m <= M; ++m) {
			for(int idx = m * 2 - 1; idx <= N; ++idx) {
				dp[m][idx] = Integer.MIN_VALUE;
				for(int sIdx = idx - 2; sIdx >= m * 2 - 3; --sIdx) {
					dp[m][idx] = Math.max(dp[m][idx], dp[m - 1][sIdx] + sum[sIdx + 2][idx]);
				}
				if(m == M) answer = Math.max(answer, dp[m][idx]);
			}
		}
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
		
	}

}
