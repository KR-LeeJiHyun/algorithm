import java.util.LinkedList;
import java.util.Queue;

public class Pro미로탈출 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class POS {
		int row;
		int col;
		int cnt;
		
		POS(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
	
    int ROW_LEN;
    int COL_LEN;
    final int D_LEN = 4;
    final int[] dRow = {-1, 1, 0, 0};
    final int[] dCol = {0, 0, -1, 1};
	
    public int solution(String[] maps) {
        int answer = -1;
        ROW_LEN = maps.length;
        COL_LEN = maps[0].length();
        
        int startRow = 0;
        int startCol = 0;
        for(int row = 0; row < ROW_LEN; ++row) {
        	for(int col = 0; col < COL_LEN; ++col) {
        		if(maps[row].charAt(col) == 'S') {
        			startRow = row;
        			startCol = col;
                    break;
        		}
        	}
        }
        
        POS tmp = null;
        tmp = bfs(startRow, startCol, 'L', 0, maps);
        if(tmp != null) {
        	tmp = bfs(tmp.row, tmp.col, 'E', tmp.cnt, maps);
        	if(tmp != null) {
        		answer = tmp.cnt;
        	}
        }
        return answer;
    }

	private POS bfs(int startRow, int startCol, char d, int startCnt, String[] maps) {
		boolean[][] visited = new boolean[ROW_LEN][COL_LEN];
		Queue<POS> q = new LinkedList<>();
		visited[startRow][startCol] = true;
		q.add(new POS(startRow, startCol, startCnt));
		
		while(!q.isEmpty()) {
			POS p = q.poll();
			int row = p.row;
			int col = p.col;
			int cnt = p.cnt;
			
			if(maps[row].charAt(col) == d) {
				return p;
			}
			
			for(int idx = 0; idx < D_LEN; ++idx) {
				int nextR = row + dRow[idx];
				int nextC = col + dCol[idx];
				
				if(nextR < 0 || nextC < 0 || nextR == ROW_LEN || nextC == COL_LEN || maps[nextR].charAt(nextC) == 'X' || visited[nextR][nextC]) {
        			continue;
        		}
				
				visited[nextR][nextC] = true;
				q.add(new POS(nextR, nextC, cnt + 1));
			}
		}
		
		return null;
	}
    
    

}
