import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek비숍 {
	
	static int N;
	static int partition = 0;
	static int[][] board;
	static int[][] chess;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		chess = new int[N][N];
		
		for(int row = 0; row < N; ++row) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; ++col) {
				board[row][col] = Integer.parseInt(input.nextToken());
			}
		}
		
		dfs(0, 0, 0);
		int answer = partition;
		partition = 0;
		if(N != 1) dfs(0, 1, 0);
		answer += partition;
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

	private static void dfs(int crow, int ccol, int cnt) {
		if(crow == N) {
			partition = Math.max(partition, cnt);
			return;
		}
		
		int nrow = crow;
		int ncol = ccol + 2;
		if(ncol >= N) {
			if(ncol % 2 == 0) {
				ncol = 1;
			}
			else {
				ncol = 0;
			}
			++nrow;
		}
		
		if(board[crow][ccol] == 1) {
			visit(crow, ccol, -1);
			chess[crow][ccol] = 1;
			dfs(nrow, ncol, cnt + 1);
			chess[crow][ccol] = 0;
			visit(crow, ccol, 1);
		}
		dfs(nrow, ncol, cnt);
	}

	private static void visit(int crow, int ccol, int marking) {
		board[crow][ccol] += marking;
		int row = crow - 1;
		int col = ccol - 1;
		while(row > -1 && col > -1) {
			board[row][col] += marking;
			--row;
			--col;
		}
		
		row = crow - 1;
		col = ccol + 1;
		while(row > -1 && col < N) {
			board[row][col] += marking;
			--row;
			++col;
		}
		
		row = crow + 1;
		col = ccol + 1;
		while(row < N && col < N) {
			board[row][col] += marking;
			++row;
			++col;
		}
		
		row = crow + 1;
		col = ccol - 1;
		while(row < N && col > -1) {
			board[row][col] += marking;
			++row;
			--col;
		}
	}

}
