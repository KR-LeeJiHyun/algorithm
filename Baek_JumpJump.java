import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_JumpJump {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N];
		Arrays.fill(dp, 10000);
		dp[0] = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) {
			int jump = Integer.parseInt(st.nextToken());
			for(int space = 1; space <= jump; ++space) {
				if(idx + space < N) {
					dp[idx + space] = Math.min(dp[idx + space], dp[idx] + 1);
				}
			}
		}
		
		if(dp[N - 1] == 10000) bw.write("-1\n");
		else bw.write(dp[N - 1] + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
