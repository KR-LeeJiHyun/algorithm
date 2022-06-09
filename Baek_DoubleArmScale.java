import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_DoubleArmScale {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int MAX = 40000;
		
		int N = Integer.parseInt(br.readLine());
		boolean[][] dp = new boolean[MAX + 1][N + 1];
		int[] weights = new int[N + 1];
		StringTokenizer stW = new StringTokenizer(br.readLine());
		for(int idx = 1; idx <= N; ++idx) weights[idx] = Integer.parseInt(stW.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		int[] beads = new int[M];
		StringTokenizer stB = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < M; ++idx) beads[idx] = Integer.parseInt(stB.nextToken());
		
		for(int idx = 1; idx <= N; ++idx) {
			int weight = weights[idx];
			for(int sIdx = 1; sIdx <= MAX; ++sIdx) {
				if(dp[sIdx][idx - 1]) {
					dp[sIdx][idx] = true;
					if(sIdx > weight) dp[sIdx - weight][idx] = true;
					if(weight > sIdx) dp[weight - sIdx][idx] = true;
					if(sIdx + weight <= MAX) dp[sIdx + weight][idx] = true;
				}
			}
			dp[weight][idx] = true;
		}
		
		StringBuilder sb = new StringBuilder("");
		for(int idx = 0; idx < M; ++idx) {
			if(dp[beads[idx]][N]) sb.append("Y ");
			else sb.append("N ");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}
