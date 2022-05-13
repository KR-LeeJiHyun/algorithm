import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_GridPath {
	static int M, N, K;
	static int [][] map, dp;
	static int [] d_row = {1, 0}, d_col = {0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNMK = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNMK.nextToken());
		M = Integer.parseInt(stNMK.nextToken());
		K = Integer.parseInt(stNMK.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		int num = 1, wayRow = 0, wayCol = 0;
		for(int row = 0; row < N; ++row) {
			for(int col = 0; col < M; ++col) {
				if(num == K) {
					wayRow = row;
					wayCol = col;
				}
				map[row][col] = num++;
			}
		}
		
		int answer = 0;
		if(K != 0) {
			int a = dfs(0, 0, wayRow, wayCol);
			int b = dfs(wayRow, wayCol, N - 1, M - 1);
			answer = a*b;
		}
		else {
			answer = dfs(0, 0, N - 1, M - 1);
		}
		
		bw.write(answer + "\n");
		br.close();
        bw.flush();
        bw.close();
	}
	
	public static int dfs(int c_row, int c_col, int row, int col) {
		
		if(c_row == row && c_col == col) {
			++dp[c_row][c_col];
			return 1;
		}
		
		int count = 0;
		
		for(int idx = 0; idx <d_row.length; ++idx) {
			int next_row = c_row + d_row[idx], next_col = c_col + d_col[idx];
			
			if(next_row < 0 || next_col < 0 || next_row >= N|| next_col >= M) {
				continue;
			}
			else if(dp[next_row][next_col] == 0) count += dfs(next_row, next_col, row, col);
			else count += dp[next_row][next_col];
		}
		
		dp[c_row][c_col] = count;
		return count;
	}

}

