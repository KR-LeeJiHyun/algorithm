import java.util.LinkedList;
import java.util.Queue;

public class Pro_BlockMove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Robot {
		int lRow;
		int lCol;
		int rRow;
		int rCol;
		int cnt;
		boolean horizon;
		
		public Robot(int lRow, int lCol, int rRow, int rCol, int cnt, boolean horizon) {
			this.lRow = lRow;
			this.lCol = lCol;
			this.rRow = rRow;
			this.rCol = rCol;
			this.cnt = cnt;
			this.horizon = horizon;
		}
	}
	
    public int solution(int[][] board) {
        int answer = 0;
        
        answer = bfs(board.length, board);
        
        return answer;
    }

	private int bfs(int N, int[][] board) {
		final int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1}; 
		Queue<Robot> q = new LinkedList<>();
		boolean[][] hVisited = new boolean[N][N], vVisited = new boolean[N][N];
		q.add(new Robot(0, 0, 0, 1, 0, true));
		
		while(!q.isEmpty()) {
			Robot current = q.poll();
			if((current.lRow + 1 == N && current.lCol + 1 == N) || (current.rRow + 1 == N && current.rCol + 1 == N)) return current.cnt;
			if(current.horizon && !(hVisited[current.lRow][current.lCol] && hVisited[current.rRow][current.rCol])) {
				hVisited[current.lRow][current.lCol] = true;
				hVisited[current.rRow][current.rCol] = true;
				//상하좌우
				for(int idx = 0; idx < dr.length; ++idx) {
					Robot next = new Robot(current.lRow + dr[idx], current.lCol + dc[idx], current.rRow + dr[idx], current.rCol + dc[idx], current.cnt + 1, current.horizon);
					if(next.lRow < 0 || next.rRow < 0 || next.lCol < 0 || next.rCol < 0 || next.lRow == N || next.rRow == N || next.lCol == N || next.rCol == N) continue;
					if(board[next.lRow][next.lCol] == 0 && board[next.rRow][next.rCol] != 1 && !(hVisited[next.lRow][next.lCol] && hVisited[next.rRow][next.rCol])) q.add(next);
				}
				//회전
				final int[] lRot = {-1, 1};
				for(int idx = 0; idx < lRot.length; ++idx) {
					Robot next = new Robot(current.lRow, current.lCol, current.rRow + lRot[idx], current.lCol, current.cnt + 1, !current.horizon);
					if(next.rRow < 0 || next.rRow == N) continue;
					if(board[next.rRow][current.rCol] == 0 && board[next.rRow][next.rCol] == 0 && !(vVisited[next.lRow][next.lCol] && vVisited[next.rRow][next.rCol])) q.add(next);
				}
				for(int idx = 0; idx < lRot.length; ++idx) {
					Robot next = new Robot(current.lRow + lRot[idx], current.rCol, current.rRow, current.rCol, current.cnt + 1, !current.horizon);
					if(next.lRow < 0 || next.lRow == N) continue;
					if(board[next.lRow][current.lCol] == 0 && board[next.lRow][next.lCol] == 0 && !(vVisited[next.lRow][next.lCol] && vVisited[next.rRow][next.rCol])) q.add(next);
				}
			}
			else if(!current.horizon && !(vVisited[current.lRow][current.lCol] && vVisited[current.rRow][current.rCol])) {
				//상하좌우
				vVisited[current.lRow][current.lCol] = true;
				vVisited[current.rRow][current.rCol] = true;
				for(int idx = 0; idx < dr.length; ++idx) {
					Robot next = new Robot(current.lRow + dr[idx], current.lCol + dc[idx], current.rRow + dr[idx], current.rCol + dc[idx], current.cnt + 1, current.horizon);
					if(next.lRow < 0 || next.rRow < 0 || next.lCol < 0 || next.rCol < 0 || next.lRow == N || next.rRow == N || next.lCol == N || next.rCol == N) continue;
					if(board[next.lRow][next.lCol] != 1 && board[next.rRow][next.rCol] != 1 && !(hVisited[next.lRow][next.lCol] && hVisited[next.rRow][next.rCol])) q.add(next);
				}
				//회전
				final int[] lRot = {-1, 1};
				for(int idx = 0; idx < lRot.length; ++idx) {
					Robot next = new Robot(current.lRow, current.lCol, current.lRow, current.rCol + lRot[idx], current.cnt + 1, !current.horizon);
					if(next.rCol < 0 || next.rCol == N) continue;
					if(board[current.rRow][next.rCol] == 0 && board[next.rRow][next.rCol] == 0 && !(hVisited[next.lRow][next.lCol] && hVisited[next.rRow][next.rCol])) q.add(next);
				}
				for(int idx = 0; idx < lRot.length; ++idx) {
					Robot next = new Robot(current.rRow, current.lCol + lRot[idx], current.rRow, current.rCol, current.cnt + 1, !current.horizon);
					if(next.lCol < 0 || next.lCol == N) continue;
					if(board[current.lRow][next.lCol] == 0 && board[next.lRow][next.lCol] == 0 && !(hVisited[next.lRow][next.lCol] && hVisited[next.rRow][next.rCol])) q.add(next);
				}
			}
		}
		return -1;
	}

    
}
