import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_PipeMove2 {
	
	static final int H = 0, V = 1, D = 2, CNT = 3;
	static int N;
	static long[][][] dp;
	static boolean[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		dp = new long[N][N][CNT];
		map = new boolean[N][N];
		
		for(int row = 0; row < N; ++row) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; ++col) {
				if(Integer.parseInt(st.nextToken()) == 1) map[row][col] = true;
			}
		}
		
		dp[N - 1][N - 1][H] = 1;
		dp[N - 1][N - 1][V] = 1;
		dp[N - 1][N - 1][D] = 1;
		dfs(0, 1, H);
		
		bw.write(Long.toString(dp[0][1][H]));
		br.close();
		bw.flush();
		bw.close();
		
	}

	private static void dfs(int row, int col, int arrow) {
		if(dp[row][col][arrow] != 0) return;
		
		//가로
		if(arrow == H) {
			//가로 -> 가로
			if(col + 1 < N && !map[row][col + 1]) {
				dfs(row, col + 1, H);
				dp[row][col][arrow] += dp[row][col + 1][H];
			}
			//가로 -> 대각
			if(row + 1 < N && col + 1 < N && !map[row][col + 1] && !map[row + 1][col] && !map[row + 1][col + 1]) {
				dfs(row + 1, col + 1, D);
				dp[row][col][arrow] += dp[row + 1][col + 1][D];
			}
		}
		
		//세로
		else if(arrow == V) {
			//세로 -> 세로
			if(row + 1 < N && !map[row + 1][col]) {
				dfs(row + 1, col, V);
				dp[row][col][arrow] += dp[row + 1][col][V];
			}
			//세로 -> 대각
			if(row + 1 < N && col + 1 < N && !map[row][col + 1] && !map[row + 1][col] && !map[row + 1][col + 1]) {
				dfs(row + 1, col + 1, D);
				dp[row][col][arrow] += dp[row + 1][col + 1][D];
			}
		}
		
		//대각
		else {
			//대각 -> 가로
			if(col + 1 < N && !map[row][col + 1]) {
				dfs(row, col + 1, H);
				dp[row][col][arrow] += dp[row][col + 1][H];
			}
			//대각 -> 세로
			if(row + 1 < N && !map[row + 1][col]) {
				dfs(row + 1, col, V);
				dp[row][col][arrow] += dp[row + 1][col][V];
			}
			//대각 -> 대각
			if(row + 1 < N && col + 1 < N && !map[row][col + 1] && !map[row + 1][col] && !map[row + 1][col + 1]) {
				dfs(row + 1, col + 1, D);
				dp[row][col][arrow] += dp[row + 1][col + 1][D];
			}
		}
	}

}
