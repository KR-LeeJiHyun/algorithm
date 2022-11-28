import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Dynamic {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int MOD = 1000000007;
		int[] dRow = {0, 1, 1}, dCol = {1, 0, 1};
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stNM.nextToken());
		int m = Integer.parseInt(stNM.nextToken());
		int[][] dp = new int[n][m];
		dp[0][0] = 1;
		
		for(int row = 0; row < n; ++row) {
			for(int col = 0; col < m; ++ col) {
				for(int idx = 0; idx < dRow.length; ++idx) {
					int nRow = row + dRow[idx];
					int nCol = col + dCol[idx];
					if(nRow == n || nCol == m) continue;
					dp[nRow][nCol] += dp[row][col];
					dp[nRow][nCol] %= MOD;
				}
			}
		}
		
		bw.write(Integer.toString(dp[n - 1][m - 1]));
		br.close();
		bw.close();

	}

}
