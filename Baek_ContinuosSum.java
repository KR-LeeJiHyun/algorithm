import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_ContinuosSum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int answer = -1001;
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int idx = 0; idx < n; ++idx) {
			int tmp = Integer.parseInt(st.nextToken());
			if(idx != 0) dp[idx] = Math.max(dp[idx - 1] + tmp, tmp);
			else dp[idx] = tmp;
			answer = Math.max(answer, dp[idx]);
		}
		
		bw.write(answer + "\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
