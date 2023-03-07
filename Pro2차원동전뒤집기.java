import java.util.Arrays;

public class Pro2차원동전뒤집기 {

	public static void main(String[] args) {
		int[][] b = {{0, 1, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 1, 1, 1, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
		int[][] t = {{0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};
		
		Pro2차원동전뒤집기 S = new Pro2차원동전뒤집기();
		S.solution(b, t);

	}
	
    public int solution(int[][] beginning, int[][] target) {
        int answer = Integer.MAX_VALUE;
        int RLEN = beginning.length;
        int CLEN = beginning[0].length;
        int[][] beginning2 = new int[RLEN][CLEN];
        int[][] beginning3 = new int[RLEN][CLEN];
        int[][] beginning4 = new int[RLEN][CLEN];
        int tmp = 0;
        int tmp2 = 0;
        int tmp3 = 0;
        int tmp4 = 0;
        
        final int ROW = 0;
        final int COL = 0;
        
        for(int row = 0; row < RLEN; ++row) {
        	for(int col = 0; col < CLEN; ++col) {
        		beginning2[row][col] = beginning[row][col];
        		beginning3[row][col] = beginning[row][col];
        		beginning4[row][col] = beginning[row][col];
        	}
        }
        
        for(int line = 0; line < RLEN; ++line) {
        	if(beginning[line][COL] != target[line][COL]) {
        		reverse(beginning, line, 0);
    			++tmp;
        	}
        	
        	if(beginning2[line][COL] == target[line][COL]) {
        		reverse(beginning2, line, 0);
    			++tmp2;
        	}
        }
        
        for(int line = 0; line < CLEN; ++line) {
        	if(beginning[ROW][line] != target[ROW][line]) {
        		reverse(beginning, line, 1);
    			++tmp;
        	}
        	if(beginning2[ROW][line] != target[ROW][line]) {
        		reverse(beginning2, line, 1);
    			++tmp2;
        	}
        }
        
        for(int line = 0; line < CLEN; ++line) {
        	if(beginning3[ROW][line] != target[ROW][line]) {
        		reverse(beginning3, line, 1);
    			++tmp3;
        	}
        	if(beginning4[ROW][line] == target[ROW][line]) {
        		reverse(beginning4, line, 1);
    			++tmp4;
        	}
        }
        for(int line = 0; line < RLEN; ++line) {
        	if(beginning3[line][COL] != target[line][COL]) {
        		reverse(beginning3, line, 0);
    			++tmp3;
        	}
        	
        	if(beginning4[line][COL] != target[line][COL]) {
        		reverse(beginning4, line, 0);
    			++tmp4;
        	}
        }
        

        
        if(Arrays.deepEquals(beginning, target)) {
        	answer = tmp;
        }
        if(Arrays.deepEquals(beginning2, target)) {
        	answer = Math.min(answer, tmp2);
        }
        if(Arrays.deepEquals(beginning3, target)) {
        	answer = Math.min(answer, tmp3);
        }
        if(Arrays.deepEquals(beginning4, target)) {
        	answer = Math.min(answer, tmp4);
        }
        if(answer == Integer.MAX_VALUE) {
        	answer = -1;
        }
        
        return answer;
    }

	private void reverse(int[][] beginning, int line, int trans) {
		if(trans == 0) {
			for(int col = 0; col < beginning[0].length; ++col) {
				beginning[line][col] = (beginning[line][col] - 1) * (-1); 
			}
		}
		
		else {
			for(int row = 0; row < beginning.length; ++row) {
				beginning[row][line] = (beginning[row][line] - 1) * (-1); 
			}
		}
	}

}
