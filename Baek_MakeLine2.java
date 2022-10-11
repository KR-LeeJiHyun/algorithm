import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_MakeLine2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int max = 0;
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 1; idx <= N; ++idx) {
			int current = Integer.parseInt(st.nextToken());
			dp[current] = dp[current - 1] + 1;
			max = Math.max(max, dp[current]);
		}

		bw.write(Integer.toString(N - max));
		br.close();
		bw.flush();
		bw.close();

	}

}
