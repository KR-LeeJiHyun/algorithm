public class Pro_Friends4Block {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 6, n = 6;
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		solution(m, n, board);
	}
	
    public static int solution(int m, int n, String[] board) {
        int answer = 0, prevAnswer = -1;
        while(answer != prevAnswer) {
        	boolean[][] del = new boolean[m][n];
        	prevAnswer = answer;
        	for(int row = 0; row < m - 1; ++row) {
        		for(int col = 0; col < n - 1; ++col) {
        			if(check(row, col, board)) {
        				del[row][col] = true;
        				del[row][col + 1] = true;
        				del[row + 1][col] = true;
        				del[row + 1][col + 1] = true;
        			}
        		}
        	}
        	int count = update(m, n, board, del);
        	answer += count;
        }
        return answer;
    }
    
    private static int update(int m, int n, String[] board, boolean[][] del) {
    	int result = 0;
    	
    	for(int row = 0; row < m; ++row) {	
    		for(int col = 0; col < n; ++col) {
    			if(del[row][col]) {
    				++result;
    				for(int idx = row; idx >= 0; --idx) {
    					StringBuilder sb = new StringBuilder(board[idx]);
    					if(idx != 0) sb.setCharAt(col, board[idx - 1].charAt(col));
    					else sb.setCharAt(col, '-');
    					board[idx] = sb.toString();
    				}
    			}
    		}	
    	}
		return result;
	}

	public static boolean check(int row, int col, String[] board) {
    	char current = board[row].charAt(col);
    	if(current == '-') return false;
    	if(board[row].charAt(col + 1) == current && board[row + 1].charAt(col) == current && board[row + 1].charAt(col + 1) == current) return true;
    	return false;
    }

}
