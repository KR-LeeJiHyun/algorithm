import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_ContinuousMul {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		double[] dp = new double[N];
		
		for(int idx = 0; idx < N; ++idx) dp[idx] = Double.parseDouble(br.readLine());
		
		double max = dp[0];
		for(int idx = 1; idx < N; ++idx) {
			if(dp[idx - 1] > 1) dp[idx] = dp[idx - 1] * dp[idx];
			max = Math.max(max, dp[idx]);
		}
		
		bw.write(String.format("%.3f", max));
		br.close();
		bw.flush();
		bw.close();
	}

}
