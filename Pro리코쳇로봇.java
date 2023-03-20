import java.util.LinkedList;
import java.util.Queue;

public class Pro리코쳇로봇 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Pos {
		int row;
		int col;
		int cnt;
		
		public Pos(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
	
    public int solution(String[] board) {
        int answer = -1;
        
        final int ARROWCNT = 4;
        final int RLEN = board.length;
        final int CLEN = board[0].length();
        Queue<Pos> q = new LinkedList<>();
        final int[] dRow = {-1, 1, 0, 0};
        final int[] dCol = {0, 0, -1, 1};
        final boolean[][] visited = new boolean[RLEN][CLEN];
        
        for(int row = 0; row < RLEN; ++row) {
        	for(int col = 0; col < CLEN; ++col) {
        		if(board[row].charAt(col) == 'R') {
        			visited[row][col] = true;
        			q.add(new Pos(row, col, 0));
        		}
        	}
        }
        
        while(!q.isEmpty()) {
        	Pos current = q.poll();
        	int row = current.row;
        	int col = current.col;
        	int cnt = current.cnt;
        	if(board[row].charAt(col) == 'G') {
        		answer = cnt;
        		break;
        	}
        	for(int idx = 0; idx < ARROWCNT; ++idx) {
        		int nextRow = row;
        		int nextCol = col;
        		while(nextRow != -1 && nextRow != RLEN && nextCol != -1 && nextCol != CLEN && board[nextRow].charAt(nextCol) != 'D') {
        			nextRow += dRow[idx];
        			nextCol += dCol[idx];
        		}
        		nextRow -= dRow[idx];
    			nextCol -= dCol[idx];
    			if(!visited[nextRow][nextCol]) {
    				visited[nextRow][nextCol] = true;
    				q.add(new Pos(nextRow, nextCol, cnt + 1));
    			}
        	}
        }
        
        
        return answer;
    }
}
