import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek스도쿠 {
	
	final static int LEN = 9;
	final static int[][] areas = {
			{0, 0, 2, 2}, {0, 3, 2, 5}, {0, 6, 2, 8}, 
			{3, 0, 5, 2}, {3, 3, 5, 5}, {3, 6, 5, 8}, 
			{6, 0, 8, 2}, {6, 3, 8, 5}, {6, 6, 8, 8}
		};
	static int[][] board = new int[LEN][LEN];
	static boolean[][] rVisited = new boolean[LEN][LEN + 1];
	static boolean[][] cVisited = new boolean[LEN][LEN + 1];
	static boolean[][] aVisited = new boolean[LEN][LEN + 1];
	static boolean end = false;
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int row = 0; row < LEN; ++row) {
			String input = br.readLine();
			for(int col = 0; col < LEN; ++col) {
				board[row][col] = input.charAt(col) - '0';
				int area = (row / 3) * 3 + (col / 3);
				rVisited[row][board[row][col]] = true;
				cVisited[col][board[row][col]] = true;
				aVisited[area][board[row][col]] = true;
			}
		}
		
		dfs(0, 0);
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}

	private static boolean dfs(int crow, int ccol) {
		if(crow == LEN) {
			for(int row = 0; row < LEN; ++row) {
				for(int col = 0; col < LEN; ++col) {
					answer.append(board[row][col]);
				}
				answer.append('\n');
			}
			end = true;
			return true;
		}
		if(board[crow][ccol] == 0) {
			int area = (crow / 3) * 3 + (ccol / 3);
			for(int num = 1; num <= 9; ++num) {
				if(end) {
					return true;
				} 
				if(!rVisited[crow][num] && !cVisited[ccol][num] && !aVisited[area][num]) {
					rVisited[crow][num] = true;
					cVisited[ccol][num] = true;
					aVisited[area][num] = true;
					board[crow][ccol] = num;
					int nrow = crow;
					int ncol = 0;
					if(ccol == 8) {
						nrow = crow + 1; 
					}
					else {
						ncol = ccol + 1;
					}
					dfs(nrow, ncol);
					rVisited[crow][num] = false;
					cVisited[ccol][num] = false;
					aVisited[area][num] = false;
					board[crow][ccol] = 0;
				}
			}
		}
		else {
			int nrow = crow;
			int ncol = 0;
			if(ccol == 8) {
				nrow = crow + 1; 
			}
			else {
				ncol = ccol + 1;
			}
			dfs(nrow, ncol);
		}
		
		return false;
	}

}
