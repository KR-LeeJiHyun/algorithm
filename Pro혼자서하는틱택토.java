
public class Pro혼자서하는틱택토 {

	public static void main(String[] args) {
		String[] board = {"XOX", "OXO", "OXO"}; 
		Pro혼자서하는틱택토 s = new Pro혼자서하는틱택토();
		s.solution(board);
	}
	
	final int LEN = 3;
	boolean[][] visited = new boolean[LEN][LEN];
	int O = 0;
	int X = 0;
	int OCnt = 0;
	int XCnt = 0;
	int[] dRow = {1, 0, 1, 1};
	int[] dCol = {0, 1, 1, -1};
	
    public int solution(String[] board) {
        
        for(int row = 0; row < LEN; ++row) {
        	for(int col = 0; col < LEN; ++col) {
        		char c = board[row].charAt(col);
        		if(c == 'O') {
        			++OCnt;
                    for(int arrow = 0; arrow < 4; ++arrow) {
                        visited = new boolean[LEN][LEN];
        				dfs(row, col, 0, c, arrow, board);
        			}
        		} else if(c == 'X'){
        			++XCnt;
                    for(int arrow = 0; arrow < 4; ++arrow) {
                        visited = new boolean[LEN][LEN];
        				dfs(row, col, 0, c, arrow, board);
        			}
        		}
        	}
        }
        
        if (OCnt < XCnt || OCnt > XCnt + 1) {
            return 0;
        }
        if (O > 0) {
            if (OCnt == XCnt || O > 2) {
                return 0;
            }
        }
        if (X > 0) {
            if (OCnt > XCnt || X > 1) {
                return 0;
            }
        }
        return 1;
    }

	private void dfs(int row, int col, int cnt, char c, int arrow, String[] board) {
		++cnt;
		visited[row][col] = true;
		if(cnt == 3) {
			if(c == 'O') {
				++O;
			} else {
				++X;
			}
            return;
		}
		
		int nextR = row + dRow[arrow];
		int nextC = col + dCol[arrow];
		
		if(nextR < 0 || nextC < 0 || nextR == 3 || nextC == 3 || visited[nextR][nextC]) {
			return;
		}
		
		char next = board[nextR].charAt(nextC);
		if(next == c) {
			dfs(nextR, nextC, cnt, c, arrow, board);
		}
	}

}
