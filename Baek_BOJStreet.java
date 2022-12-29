import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baek_BOJStreet {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String road = br.readLine();
		int[] dp = new int[N];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		
		for(int idx = 1; idx < N; ++idx) {
			char c = road.charAt(idx);
			if(c == 'B') {
				for(int sIdx = 2; sIdx < idx; ++sIdx) {
					if(dp[sIdx] != -1 && road.charAt(sIdx) == 'J') {
						int energy = dp[sIdx] + (idx - sIdx) * (idx - sIdx);
						if(dp[idx] == -1 || dp[idx] > energy) dp[idx] = energy;
					}
				}
			}
			
			else if(c == 'O') {
				for(int sIdx = 0; sIdx < idx; ++sIdx) {
					if(dp[sIdx] != -1 && road.charAt(sIdx) == 'B') {
						int energy = dp[sIdx] + (idx - sIdx) * (idx - sIdx);
						if(dp[idx] == -1 || dp[idx] > energy) dp[idx] = energy;
					}
				}
			}
			
			else {
				for(int sIdx = 1; sIdx < idx; ++sIdx) {
					if(dp[sIdx] != -1 && road.charAt(sIdx) == 'O') {
						int energy = dp[sIdx] + (idx - sIdx) * (idx - sIdx);
						if(dp[idx] == -1 || dp[idx] > energy) dp[idx] = energy;
					}
				}
			}
		}
		
		bw.write(String.valueOf(dp[N - 1]));
		br.close();
		bw.close();

	}

}
