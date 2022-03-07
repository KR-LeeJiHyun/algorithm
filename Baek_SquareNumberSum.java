import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_SquareNumberSum {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		int check = 1;
		for(int idx = 1; idx <= N; ++idx) {
			if(idx / check != check) {
				for(int sIdx = 1; sIdx <= idx/2; ++sIdx) dp[idx] = Math.min(dp[idx], dp[idx - sIdx] + dp[sIdx]);
			}
			else {
				dp[idx] = 1;
				++check;
			}
		}
		
		bw.write(dp[N] + "\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
