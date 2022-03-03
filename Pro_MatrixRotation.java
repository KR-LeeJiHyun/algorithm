
public class Pro_MatrixRotation {
	
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int [queries.length];
        int[][] board = new int[rows + 1][columns + 1];
        int count = 1;
        for(int row = 1; row <= rows; ++row) {
        	for(int col = 1; col <= columns; ++col) {
        		board[row][col] = count++;
        	}
        }
        
        for(int idx = 0; idx < queries.length; ++idx) {
        	int tmp = 0, s_row = queries[idx][0], s_col = queries[idx][1], d_row = queries[idx][2], d_col = queries[idx][3];
        	int min = rows * columns;
        	//열 증가
        	int trans = board[s_row][s_col];
        	if(trans < min) min = trans;
        	for(int col = s_col + 1; col <= d_col; ++col) {
        		tmp = board[s_row][col];
        		if(tmp < min) min = tmp;
        		board[s_row][col] = trans;
        		trans = tmp;
        	}
        	//행 증가
        	for(int row = s_row + 1; row <= d_row; ++row) {
        		tmp = board[row][d_col];
        		if(tmp < min) min = tmp;
        		board[row][d_col] = trans;
        		trans = tmp;
        	}
        	//열감소
        	for(int col = d_col - 1; col >= s_col; --col) {
        		tmp = board[d_row][col];
        		if(tmp < min) min = tmp;
        		board[d_row][col] = trans;
        		trans = tmp;
        	}
        	//행감소
        	for(int row = d_row -1; row >= s_row; --row) {
        		tmp = board[row][s_col];
        		if(tmp < min) min = tmp;
        		board[row][s_col] = trans;
        		trans = tmp;
        	}
        	answer[idx] = min;
        }
        
        return answer;
    }
    
    public static void print_map(int[][] board) {
    	System.out.print("\n");
    	for(int row = 1; row < board.length; ++row) {
    		for(int col = 1; col < board[row].length; ++col) {
    			System.out.print(board[row][col] + " ");
    		}
    		System.out.print("\n");
    	}
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}};
		solution(rows, columns, queries);
	}

}
