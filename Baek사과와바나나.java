import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek사과와바나나 {
	
	static int RLEN;
	static int CLEN;
	static int[][] dp;
	static int[][] bananas;
	static int[][] apples;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stRC = new StringTokenizer(br.readLine());
		RLEN = Integer.parseInt(stRC.nextToken());
		CLEN = Integer.parseInt(stRC.nextToken());
		
		dp = new int[RLEN + 1][CLEN + 1];
		bananas = new int[RLEN + 1][CLEN + 1];
		apples = new int[RLEN + 1][CLEN + 1];
		
		for(int row = 1; row <= RLEN; ++row) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 1; col <= CLEN; ++col) {
				String s = st.nextToken();
				int cnt = Integer.parseInt(s.substring(1));
				if(s.charAt(0) == 'A') {
 					apples[row][col] = cnt;
				}
				else {
					bananas[row][col] = cnt;
				}
				apples[row][col] += apples[row - 1][col];
				bananas[row][col] += bananas[row - 1][col];
			}
		}
		
		for(int row = 1; row < RLEN; ++row) {
			dp[row][1] = apples[RLEN][1] - apples[row][1];
		}
		
		for(int col = 2; col <= CLEN; ++col) {
			dp[1][col] = dp[1][col - 1] + calcApple(1, col);
		}
		
		for(int row = 2; row <= RLEN; ++row) {
			for(int col = 2; col <= CLEN; ++col) {
				dp[row][col] = dp[row - 1][col] - calcApple(row - 1, col) + calcApple(row, col);
				dp[row][col] = Math.max(dp[row][col], dp[row - 1][col - 1] + calcApple(row, col) + bananas[row - 1][col]);
				dp[row][col] = Math.max(dp[row][col], dp[row][col - 1] + calcApple(row, col) + bananas[row - 1][col]);
			}
		}
		
		bw.write(String.valueOf(dp[RLEN][CLEN]));
		br.close();
		bw.close();
	}

	private static int calcApple(int row, int col) {
		return apples[RLEN][col] - apples[row][col];
	}
}
