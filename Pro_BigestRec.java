
public class Pro_BigestRec {

	public static void main(String[] args) {
		int[][] board = {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
		solution(board);
	}
	
    public static int solution(int [][]board){
    	int answer = 0, rLen = board.length, cLen = board[0].length;
    	int[][] dp = new int[rLen][cLen];
    	for(int row = 0; row < rLen; ++row) {
    		if(board[row][0] == 1) {
    			dp[row][0] = 1;
    			answer = 1;
    		}
    	}
		for(int col = 1; col < cLen; ++col) {
			if(board[0][col] == 1) {
				dp[0][col] = 1;
				answer = 1;
			}
		}
    	for(int row = 1; row < rLen; ++row) {
    		for(int col = 1; col < cLen; ++col) {
    			if(board[row][col] == 1) {
    				dp[row][col] = Math.min(dp[row - 1][col - 1], Math.min(dp[row - 1][col], dp[row][col - 1])) + 1;
    			}
    		answer = Math.max(answer, dp[row][col]);
    		}
    	}
    	return answer * answer;
    }

}
