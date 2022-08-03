import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_CardGame2 {
	
	static int N;
	static int[][] dp;
	static int[] cards;

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; ++t) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			dp = new int[N][N];
			cards = new int[N];
			
			for(int idx = 0; idx < N; ++idx) cards[idx] = Integer.parseInt(st.nextToken());
			
			dfs(0, N - 1, true);
			
			sb.append(dp[0][N - 1]);
			sb.append('\n');
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		br.close();
	}

	private static void dfs(int left, int right, boolean turn) {
		
		if(left == right) {
			if(turn) dp[left][right] = cards[left];
			return;
		}
		
		if(dp[left + 1][right] == 0) dfs(left + 1, right, !turn);
		if(dp[left][right - 1] == 0) dfs(left, right - 1, !turn);
		
		if(turn) dp[left][right] = Math.max(dp[left + 1][right] + cards[left], dp[left][right - 1] + cards[right]);
		else dp[left][right] =  Math.min(dp[left + 1][right], dp[left][right - 1]);
		
	}

}
