import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_SoldierDeploy {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] soldiers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) soldiers[idx] = Integer.parseInt(st.nextToken());
		int[] dp = new int[N];
		dp[0] = 1;
		int max = 1;
		
		for(int idx = 1; idx < N; ++idx) {
			dp[idx] = 1;
			for(int sIdx = 0; sIdx < idx; ++sIdx) {
				if(soldiers[idx] < soldiers[sIdx]) dp[idx] = Math.max(dp[idx], dp[sIdx] + 1);
			}
			max = Math.max(max, dp[idx]);
		}
		
		bw.write(Integer.toString(N - max));
		br.close();
		bw.flush();
		bw.close();
		
	}

}
