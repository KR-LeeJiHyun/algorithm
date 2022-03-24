import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_Jump {
	static int[] dr = {1, 0}, dc = {0, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		long[][] dp = new long[N][N];
		
		
		for(int row = 0; row < N; ++row) {
			Arrays.fill(dp[row], -1);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; ++col) {
				board[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		dp[N - 1][N - 1] = 1;
		
		dfs(0, 0, N, board, dp);
		
		bw.write(dp[0][0] + "\n");
		
		br.close();
		bw.flush();
		bw.close(); 
	}

	private static long dfs(int r, int c, int N, int[][] board, long[][] dp) {
		dp[r][c] = 0;
		int move =  board[r][c];
		for(int idx = 0; idx < dr.length; ++idx) {
			 int nr = move * dr[idx] + r, nc = move * dc[idx] + c;
			 if(nr >= N || nc >= N) continue;
			 if(dp[nr][nc] == -1) {
				 dp[r][c] += dfs(nr, nc, N, board, dp);
			 }
			 else dp[r][c] += dp[nr][nc];
		}
		
		return dp[r][c];
	}

}
