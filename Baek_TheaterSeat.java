import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_TheaterSeat {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
		if(N == 1) bw.write("1\n");
		else {
			int[] VIP = new int[M];
			for(int idx = 0; idx < M; ++idx) VIP[idx] = Integer.parseInt(br.readLine());
			int[] dp = new int[N + 1];
			dp[0] = 1;
			dp[1] = 1;
			dp[2] = 2;
			for(int idx = 3; idx <= N; ++idx) dp[idx] = dp[idx - 1] + dp[idx - 2];
			int start = 1, answer = 1;
			for(int idx = 0; idx < M; ++idx) {
				int end = VIP[idx];
				if(start <= N) answer *= dp[end - start];
				start = end + 1;
			}
			
			if(start <= N) answer *= dp[(N + 1) - start];
			bw.write(answer + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
