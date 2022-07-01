import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_RicecakeAndTiger {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final int MAX = 100000 / 2;
		
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()); 
		int[][] dp = new int[N][2];
		dp[0][0] = 1;
		dp[1][1] = 1;
		
		for(int idx = 2; idx < N; ++idx) {
			dp[idx][0] = dp[idx - 1][0] + dp[idx - 2][0];
			dp[idx][1] = dp[idx - 1][1] + dp[idx - 2][1];
		}
		
		for(int a = 1; a <= MAX; ++a) {
			double b = (double)(K - dp[N - 1][0] * a) / (double)dp[N - 1][1];
			if(Double.compare(b, (int)b) == 0) {
				bw.write(a + "\n");
				bw.write(b + "\n");
				br.close();
				bw.flush();
				bw.close();
				return;
			}
		}

	}

}
