import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_RemoteRobot {
	static final int ARROWS = 3;
	static final int DOWN = 0, RIGHT = 1, LEFT = 2;
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[] d_row = {1, 0, 0}, d_col = {0, 1, -1};
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stNM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNM.nextToken());
		M = Integer.parseInt(stNM.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		dp = new int[N][M][ARROWS];

		for(int row = 0; row < N; ++row) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < M; ++col) {
				map[row][col] = Integer.parseInt(st.nextToken());
				Arrays.fill(dp[row][col], Integer.MIN_VALUE);
			}
		}
		
		for(int idx = 0; idx < ARROWS; ++idx) dp[N - 1][M - 1][idx] = map[N - 1][M - 1];

		bw.write(dfs(0, 0, 0) + "\n");

		br.close();
		bw.flush();
		bw.close();
	}

	private static int dfs(int c_row, int c_col, int arrow) {
		if(dp[c_row][c_col][arrow] == Integer.MIN_VALUE) {
			visited[c_row][c_col] = true;
			
			for(int idx = 0; idx < d_row.length; ++idx) {
				int n_row = c_row + d_row[idx], n_col = c_col + d_col[idx];
				if(n_row < 0 || n_row == N || n_col < 0 || n_col == M || visited[n_row][n_col]) continue;
				int result = dfs(n_row, n_col, idx);
				if(result != Integer.MIN_VALUE) dp[c_row][c_col][arrow] = Math.max(dp[c_row][c_col][arrow], result + map[c_row][c_col]);  
			}
			
			visited[c_row][c_col] = false;
		}
		return dp[c_row][c_col][arrow];
	}

}
