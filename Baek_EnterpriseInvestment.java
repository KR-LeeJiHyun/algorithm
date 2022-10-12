import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_EnterpriseInvestment {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken());
		int M = Integer.parseInt(stNM.nextToken());
		
		int[][] investments = new int[N + 1][M + 1];
		for(int idx = 1; idx <= N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			for(int sIdx = 1; sIdx <= M; ++sIdx) investments[idx][sIdx] = Integer.parseInt(st.nextToken());
		}
		
		int[][][] dp = new int[N + 1][M + 1][M + 1];
		for(int price = 1; price <= N; ++price) {
			dp[price][1][0] = investments[price][1];
			dp[price][1][1] = price;
			for(int enter = 2; enter <= M; ++enter) {
				for(int div = 0; div <= price; ++div) {
					if(dp[price][enter][0] < dp[div][enter - 1][0] + investments[price - div][enter]) {
						dp[price][enter][0] = dp[div][enter - 1][0] + investments[price - div][enter];
						for(int idx = 1; idx <= M; ++idx) dp[price][enter][idx] = dp[div][enter - 1][idx];
						dp[price][enter][enter] += price - div;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(dp[N][M][0]);
		sb.append('\n');
		for(int idx = 1; idx <= M; ++idx) {
			sb.append(dp[N][M][idx]);
			sb.append(' ');
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
