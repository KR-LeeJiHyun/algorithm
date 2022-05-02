import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_App {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		final int MAX = 100 * 100 + 1;
		int N = Integer.parseInt(stNM.nextToken()), M = Integer.parseInt(stNM.nextToken());
		int[] m = new int[N + 1], c = new int[N + 1];
		StringTokenizer stm = new StringTokenizer(br.readLine());
		StringTokenizer stc = new StringTokenizer(br.readLine());
		for(int idx = 1; idx <= N; ++idx) {
			m[idx] = Integer.parseInt(stm.nextToken());
			c[idx] = Integer.parseInt(stc.nextToken());
		}
		
		/*int[][] dp = new int[2][M + 1];
		int idx = 0;
		Arrays.fill(dp[0], MAX);
		dp[0][0] = 0;
		for(int n = 1; n <= N; ++n) {
			int current = n % 2, prev = (current + 1) % 2;
			for(int mem = 1; mem <= M; ++mem) {
				dp[current][mem] = dp[prev][mem];
				if(mem <= m[n]) {
					dp[current][mem] = Math.min(dp[current][mem], c[n]);
				}
				else if(dp[prev][mem - m[n]] != MAX) {
					dp[current][mem] = Math.min(dp[current][mem], dp[prev][mem - m[n]] + c[n]);
				}
			}
			idx = current;
		}
		
		bw.write(dp[idx][M] + "\n");*/
		
		int[][] dp = new int[N + 1][MAX];
		int answer = Integer.MAX_VALUE;
		
		for(int n = 1; n <= N; ++n) {
			int memory = m[n];
			int cost = c[n];
			for(int co = 0; co < MAX; ++co) {
				if(co >= cost) dp[n][co] = Math.max(dp[n - 1][co], dp[n - 1][co - cost] + memory);
				else dp[n][co] = dp[n - 1][co];
				
				if(dp[n][co] >= M) answer = Math.min(answer, co);
			}
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
