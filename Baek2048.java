import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek2048 {
	
	static int answer = 0;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		for(int row = 0; row < N; ++row) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; ++col) {
				board[row][col] = Integer.parseInt(input.nextToken());
			}
		}
		
		up(board, 0);
		down(board, 0);
		left(board, 0);
		right(board, 0);
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

	private static void up(int[][] board, int cnt) {
		if(cnt == 5) {
			for(int row = 0; row < N; ++row) {
				for(int col = 0; col < N; ++col) {
					answer = Math.max(answer, board[row][col]);
				}
			}
			return;
		}
		
		int[][] tmp = new int[N][N];
		boolean[][] sum = new boolean[N][N];
		tmp[0] = board[0].clone();
		for(int row = 1; row < N; ++row) {
			tmp[row] = board[row].clone();
			for(int col = 0; col < N; ++col) {
				int uRow = row - 1; 
				while(uRow > -1 && tmp[uRow][col] == 0) {
					--uRow;
				}
				if(uRow != -1) {
					if(tmp[uRow][col] == tmp[row][col] && !sum[uRow][col]) {
						tmp[uRow][col] += tmp[row][col];
						tmp[row][col] = 0;
						sum[uRow][col] = true;
					}
					else {
						int num = tmp[row][col];
						tmp[row][col] = 0;
						tmp[uRow + 1][col] = num;
					}
				}
				else {
					tmp[0][col] = tmp[row][col];
					tmp[row][col] = 0;
				}
			}
		}
		
		up(tmp, cnt + 1);
		down(tmp, cnt + 1);
		left(tmp, cnt + 1);
		right(tmp, cnt + 1);
	}
	
	private static void down(int[][] board, int cnt) {
		if(cnt == 5) {
			for(int row = 0; row < N; ++row) {
				for(int col = 0; col < N; ++col) {
					answer = Math.max(answer, board[row][col]);
				}
			}
			return;
		}
		
		int[][] tmp = new int[N][N];
		boolean[][] sum = new boolean[N][N];
		tmp[N - 1] = board[N - 1].clone();
		for(int row = N - 2; row > -1; --row) {
			tmp[row] = board[row].clone();
			for(int col = 0; col < N; ++col) {
				int dRow = row + 1; 
				while(dRow < N && tmp[dRow][col] == 0) {
					++dRow;
				}
				if(dRow != N) {
					if(tmp[dRow][col] == tmp[row][col] && !sum[dRow][col]) {
						tmp[dRow][col] += tmp[row][col];
						tmp[row][col] = 0;
						sum[dRow][col] = true;
					}
					else {
						int num = tmp[row][col];
						tmp[row][col] = 0;
						tmp[dRow - 1][col] = num;
					}
				}
				else {
					tmp[N - 1][col] = tmp[row][col];
					tmp[row][col] = 0;
				}
			}
		}
		
		up(tmp, cnt + 1);
		down(tmp, cnt + 1);
		left(tmp, cnt + 1);
		right(tmp, cnt + 1);
	}
	
	private static void left(int[][] board, int cnt) {
		if(cnt == 5) {
			for(int row = 0; row < N; ++row) {
				for(int col = 0; col < N; ++col) {
					answer = Math.max(answer, board[row][col]);
				}
			}
			return;
		}
		
		int[][] tmp = new int[N][N];
		boolean[][] sum = new boolean[N][N];
		for(int row = 0; row < N; ++row) {
			tmp[row] = board[row].clone();
			for(int col = 1; col < N; ++col) {
				int lCol = col - 1; 
				while(lCol > -1 && tmp[row][lCol] == 0) {
					--lCol;
				}
				if(lCol != -1) {
					if(tmp[row][lCol] == tmp[row][col] && !sum[row][lCol]) {
						tmp[row][lCol] += tmp[row][col];
						tmp[row][col] = 0;
						sum[row][lCol] = true;
					}
					else {
						int num = tmp[row][col];
						tmp[row][col] = 0;
						tmp[row][lCol + 1] = num;
					}
				}
				else {
					tmp[row][0] = tmp[row][col];
					tmp[row][col] = 0;
				}
			}
		}
		
		up(tmp, cnt + 1);
		down(tmp, cnt + 1);
		left(tmp, cnt + 1);
		right(tmp, cnt + 1);
	}
	
	private static void right(int[][] board, int cnt) {
		if(cnt == 5) {
			for(int row = 0; row < N; ++row) {
				for(int col = 0; col < N; ++col) {
					answer = Math.max(answer, board[row][col]);
				}
			}
			return;
		}
		
		int[][] tmp = new int[N][N];
		boolean[][] sum = new boolean[N][N];
		for(int row = 0; row < N; ++row) {
			tmp[row] = board[row].clone();
			for(int col = N - 2; col > -1; --col) {
				int rCol = col + 1; 
				while(rCol < N && tmp[row][rCol] == 0) {
					++rCol;
				}
				if(rCol != N) {
					if(tmp[row][rCol] == tmp[row][col] && !sum[row][rCol]) {
						tmp[row][rCol] += tmp[row][col];
						tmp[row][col] = 0;
						sum[row][rCol] = true;
					}
					else {
						int num = tmp[row][col];
						tmp[row][col] = 0;
						tmp[row][rCol - 1] = num;
					}
				}
				else {
					tmp[row][N - 1] = tmp[row][col];
					tmp[row][col] = 0;
				}
			}
		}
		
		up(tmp, cnt + 1);
		down(tmp, cnt + 1);
		left(tmp, cnt + 1);
		right(tmp, cnt + 1);
	}
}
