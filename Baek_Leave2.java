import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Leave2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N + 1], P = new int[N + 1];
		
		for(int idx = 1; idx < N + 1; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[idx] = idx + Integer.parseInt(st.nextToken()) - 1;
			if(T[idx] <= N) P[idx] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N + 2];
		dp[N] = P[N];
		for(int idx = N - 1; idx > 0; --idx) {
			if(T[idx] <= N) dp[idx] = Math.max(dp[T[idx] + 1] + P[idx], dp[idx + 1]);
			else dp[idx] = dp[idx + 1];
		}
		
		bw.write(dp[1] + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
