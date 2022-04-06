import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_BigestRec {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), max = 0;
		int[][] dp = new int[n + 1][m + 1];
		
		for(int row = 1; row <= n; ++row) {
			String str = br.readLine();
			for(int col = 1; col <= m; ++col) {
				char c = str.charAt(col - 1);
				if(c == '1') {
					dp[row][col] = Character.getNumericValue(c) + Math.min(dp[row - 1][col], Math.min(dp[row][col - 1], dp[row - 1][col - 1]));
					max = Math.max(max, dp[row][col]);
				}
			}
		}
		bw.write(max * max + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
