import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Sticker {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int MAXROW = 2;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; ++t) {
			int N = Integer.parseInt(br.readLine());
			int[][] stickers = new int[MAXROW][N], dp = new int[MAXROW][N + 1];
			
			for(int idx = 0; idx < MAXROW; ++idx) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int n = 0; n < N; ++n) stickers[idx][n] = Integer.parseInt(st.nextToken());
			}
			
			dp[0][1] = stickers[0][0];
			dp[1][1] = stickers[1][0];
		
			for(int n = 1; n < N; ++n) {
				dp[0][n + 1] = Math.max(dp[1][n], dp[1][n-1]) + stickers[0][n];
				dp[1][n + 1] = Math.max(dp[0][n], dp[0][n-1]) + stickers[1][n];
			}
			
			/*System.out.print("\n");
			for(int row = 0; row < 4; ++row) {
				for(int col = 0; col < N + 1; ++col) {
					System.out.print(dp[row][col] + " ");
				}
				System.out.print("\n");
			}*/
			
			bw.write(Math.max(dp[0][N],dp[1][N]) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();

	}

}
