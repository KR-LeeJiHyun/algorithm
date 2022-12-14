import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Resource {

	public static void main(String[] args) throws IOException {
		
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N][M];
		int[] dRow = {1, 0};
		int[] dCol = {0, 1};
		
		for(int row = 0; row < N; ++row) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			for(int col = 0; col < M; ++col) {
				dp[row][col] += Integer.parseInt(input.nextToken());
				for(int idx = 0; idx < dRow.length; ++idx) {
					int nRow = row + dRow[idx];
					int nCol = col + dCol[idx];
					if(nRow == N || nCol == M) continue;
					dp[nRow][nCol] = Math.max(dp[nRow][nCol], dp[row][col]);
				}
			}
		}
		
		bw.write(String.valueOf(dp[N - 1][M - 1]));
		br.close();
		bw.close();
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N + 1][M + 1];
		String input;
		for(int row = 1; row <= N; ++row) {
			input = br.readLine();
			for(int col = 1; col <= M; ++col) {
				dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]) + Character.getNumericValue(input.charAt((col - 1) * 2));
			}
		}
		
		bw.write(String.valueOf(dp[N][M]));
		br.close();
		bw.close();
	}

}
