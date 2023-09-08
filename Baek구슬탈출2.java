import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek구슬탈출2 {

	static class Position{
		int row;
		int col;

		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
	} 

	static int answer = Integer.MAX_VALUE;
	static int N;
	static int M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer input = new StringTokenizer(br.readLine());

		N = Integer.parseInt(input.nextToken());
		M = Integer.parseInt(input.nextToken());
		boolean[][] board = new boolean[N][M];
		Position red = null;
		Position blue = null;
		Position hole = null;

		for(int row = 0; row < N - 1; ++row) {
			String line = br.readLine();
			for(int col = 0; col < M; ++col) {
				char c = line.charAt(col); 
				if(c == '.') {
					board[row][col] = true;
				}
				else {
					if(c == 'R') {
						red = new Position(row, col);
					}
					if(c == 'B') {
						blue = new Position(row, col);
					}
					if(c == 'O') {
						hole = new Position(row, col);
					}
				}
			}
		}
		
		move(red, blue, hole, board, 0);
		
		if(answer != Integer.MAX_VALUE) {
			bw.write(String.valueOf(answer));
		}
		else {
			bw.write("-1");
		}
		
		br.close();
		bw.close();
	}
	private static void move(Position cred, Position cblue, Position hole, boolean[][] board, int cnt) {
		if(cnt == 10 || answer <= cnt + 1) {
			return;
		}

		//up
		if(cred.row <= cblue.row) {
			boolean[][] tmp = new boolean[N][M];
			for(int row = 0; row < N; ++row) {
				tmp[row] = board[row].clone();
			}
			
			Position red = new Position(cred.row, cred.col);
			Position blue =  new Position(cblue.row, cblue.col);
			
			boolean redResult = up(red, hole, tmp);
			boolean blueResult = up(blue, hole, tmp);
			
			
			if(redResult && !blueResult) {
				answer = Math.min(answer, cnt + 1);
			}
			else if(!blueResult){
				move(red, blue, hole, tmp, cnt + 1);
			}
		}
		else {
			boolean[][] tmp = new boolean[N][M];
			for(int row = 0; row < N; ++row) {
				tmp[row] = board[row].clone();
			}
			
			Position red = new Position(cred.row, cred.col);
			Position blue =  new Position(cblue.row, cblue.col);
			
			boolean blueResult = up(blue, hole, tmp);
			boolean redResult = up(red, hole, tmp);
			
			if(redResult && !blueResult) {
				answer = Math.min(answer, cnt + 1);
			}
			else if(!blueResult){
				move(red, blue, hole, tmp, cnt + 1);
			}
		}

		//down
		if(cred.row >= cblue.row) {
			boolean[][] tmp = new boolean[N][M];
			for(int row = 0; row < N; ++row) {
				tmp[row] = board[row].clone();
			}
			
			Position red = new Position(cred.row, cred.col);
			Position blue =  new Position(cblue.row, cblue.col);
			
			boolean redResult = down(red, hole, tmp);
			boolean blueResult = down(blue, hole, tmp);
			
			if(redResult && !blueResult) {
				answer = Math.min(answer, cnt + 1);
			}
			else if(!blueResult){
				move(red, blue, hole, tmp, cnt + 1);
			}
		}
		else {
			boolean[][] tmp = new boolean[N][M];
			for(int row = 0; row < N; ++row) {
				tmp[row] = board[row].clone();
			}
			
			Position red = new Position(cred.row, cred.col);
			Position blue =  new Position(cblue.row, cblue.col);
			
			boolean blueResult = down(blue, hole, tmp);
			boolean redResult = down(red, hole, tmp);
			
			if(redResult && !blueResult) {
				answer = Math.min(answer, cnt + 1);
			}
			else if(!blueResult){
				move(red, blue, hole, tmp, cnt + 1);
			}
		}

		//left
		if(cred.col <= cblue.col) {
			boolean[][] tmp = new boolean[N][M];
			for(int row = 0; row < N; ++row) {
				tmp[row] = board[row].clone();
			}
			
			Position red = new Position(cred.row, cred.col);
			Position blue =  new Position(cblue.row, cblue.col);
			
			boolean redResult = left(red, hole, tmp);
			boolean blueResult = left(blue, hole, tmp);
			
			if(redResult && !blueResult) {
				answer = Math.min(answer, cnt + 1);
			}
			else if(!blueResult){
				move(red, blue, hole, tmp, cnt + 1);
			}
		}
		else {
			boolean[][] tmp = new boolean[N][M];
			for(int row = 0; row < N; ++row) {
				tmp[row] = board[row].clone();
			}
			
			Position red = new Position(cred.row, cred.col);
			Position blue =  new Position(cblue.row, cblue.col);
			
			boolean blueResult = left(blue, hole, tmp);
			boolean redResult = left(red, hole, tmp);
			
			if(redResult && !blueResult) {
				answer = Math.min(answer, cnt + 1);
			}
			else if(!blueResult){
				move(red, blue, hole, tmp, cnt + 1);
			}
		}

		//right
		if(cred.col >= cblue.col) {
			boolean[][] tmp = new boolean[N][M];
			for(int row = 0; row < N; ++row) {
				tmp[row] = board[row].clone();
			}
			
			Position red = new Position(cred.row, cred.col);
			Position blue =  new Position(cblue.row, cblue.col);
			
			boolean redResult = right(red, hole, tmp);
			boolean blueResult = right(blue, hole, tmp);
			
			if(redResult && !blueResult) {
				answer = Math.min(answer, cnt + 1);
			}
			else if(!blueResult){
				move(red, blue, hole, tmp, cnt + 1);
			}
		}
		else {
			boolean[][] tmp = new boolean[N][M];
			for(int row = 0; row < N; ++row) {
				tmp[row] = board[row].clone();
			}
			
			Position red = new Position(cred.row, cred.col);
			Position blue =  new Position(cblue.row, cblue.col);
			
			boolean blueResult = right(blue, hole, tmp);
			boolean redResult = right(red, hole, tmp);
			
			if(redResult && !blueResult) {
				answer = Math.min(answer, cnt + 1);
			}
			else if(!blueResult){
				move(red, blue, hole, tmp, cnt + 1);
			}
		}

	}
	
	private static boolean up(Position biz, Position hole, boolean[][] board) {
		int uRow = biz.row - 1;
		while(board[uRow][biz.col]) {
			--uRow;
		}

		if(hole.row == uRow && hole.col == biz.col) {
			board[biz.row][biz.col] = true;
			return true;
		}
		else {
			++uRow;
			board[biz.row][biz.col] = true;
			board[uRow][biz.col] = false;
			biz.row = uRow;
			return false;
		}
	}
	
	private static boolean down(Position biz, Position hole, boolean[][] board) {
		int dRow = biz.row + 1;
		while(board[dRow][biz.col]) {
			++dRow;
		}

		if(hole.row == dRow && hole.col == biz.col) {
			board[biz.row][biz.col] = true;
			return true;
		}
		else {
			--dRow;
			board[biz.row][biz.col] = true;
			board[dRow][biz.col] = false;
			biz.row = dRow;
			return false;
		}
	}
	
	private static boolean left(Position biz, Position hole, boolean[][] board) {
		int lCol = biz.col - 1;
		while(board[biz.row][lCol]) {
			--lCol;
		}

		if(hole.row == biz.row && hole.col == lCol) {
			board[biz.row][biz.col] = true;
			return true;
		}
		else {
			++lCol;
			board[biz.row][biz.col] = true;
			board[biz.row][lCol] = false;
			biz.col = lCol;
			return false;
		}
	}
	
	private static boolean right(Position biz, Position hole, boolean[][] board) {
		int rCol = biz.col + 1;
		while(board[biz.row][rCol]) {
			++rCol;
		}

		if(hole.row == biz.row && hole.col == rCol) {
			board[biz.row][biz.col] = true;
			return true;
		}
		else {
			--rCol;
			board[biz.row][biz.col] = true;
			board[biz.row][rCol] = false;
			biz.col = rCol;
			return false;
		}
	}
}
