import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_AdjBit {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int MAX = 101;
		int[][][] dp = new int[MAX][MAX][2];
		dp[1][0][0] = 1;
		dp[1][0][1] = 1;
		
		for(int cnt = 2; cnt < MAX; ++cnt) {
			for(int adj = 0; adj < cnt; ++adj) {
				dp[cnt][adj][0] = dp[cnt - 1][adj][0] + dp[cnt - 1][adj][1];
				if(adj != 0) dp[cnt][adj][1] = dp[cnt - 1][adj][0] + dp[cnt - 1][adj - 1][1];
				else dp[cnt][adj][1] = dp[cnt - 1][adj][0];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder answer = new StringBuilder();
		while(T > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			answer.append(dp[n][k][0] + dp[n][k][1]);
			answer.append('\n');
			--T;
		}
		
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();

	}

}
