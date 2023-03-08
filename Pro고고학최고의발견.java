
public class Pro고고학최고의발견 {

	public static void main(String[] args) {
		int[][] clockHands = {
				{0, 1, 3, 0},
				{1, 2, 0, 0},
				{3, 0, 2, 2},
				{0, 2, 0, 0}
		};
		Pro고고학최고의발견 S = new Pro고고학최고의발견();
		S.solution(clockHands);
	}
	
	int len;
	int[] dRow = {-1, 1, 0, 0};
	int[] dCol = {0, 0, -1, 1};
	
    public int solution(int[][] clockHands) {
        int answer = 0;
        len = clockHands.length;
        int[] rot = new int[len];
        
        answer = dfs(0, rot, clockHands);
        
        return answer;
    }

	private int dfs(int col, int[] rot, int[][] clockHands) {
		int result = Integer.MAX_VALUE;
		if(col == len) {
			int[][] tmpClockHands = new int[len][len];
			for(int row = 0; row < len; ++row) {
				tmpClockHands[row] = clockHands[row].clone();
			}
			return rotationTable(rot, tmpClockHands);
		}
		for(int idx = 0; idx < 4; ++idx) {
			rot[col] = idx;
			result = Math.min(result, dfs(col + 1, rot, clockHands));
		}
		return result;
	}


	private int rotationTable(int[] rot, int[][] clockHands) {
		int result = 0;
		for(int row = 0; row < len; ++row) {
			for(int col = 0; col < len; ++col) {
				if(row != 0) {
					int cnt = (4 - clockHands[row - 1][col]) % 4;
					if(cnt != 0) {
						result += cnt;
						rotation(cnt, row, col, clockHands);
					}
				}
				else if(rot[col] != 0){
					result += rot[col];
					rotation(rot[col], row, col, clockHands);
				}
			}
		}
		
		if(isEnd(clockHands)) {
			return result;
		}
		else {
			return Integer.MAX_VALUE;
		}
		
	}

	private void rotation(int cnt, int row, int col, int[][] clockHands) {
		clockHands[row][col] = (clockHands[row][col] + cnt) % 4;
		
		for(int idx = 0; idx < dRow.length; ++idx) {
			int nRow = row + dRow[idx];
			int nCol = col + dCol[idx];
			
			if(nRow < 0 || nCol < 0 || nRow == len || nCol == len) continue;
			else {
				clockHands[nRow][nCol] = (clockHands[nRow][nCol] + cnt) % 4;
			}
		}
		
	}

	private boolean isEnd(int[][] clockHands) {
		for(int row = 0; row < len; ++row) {
			for(int col = 0; col < len; ++col) {
				if(clockHands[row][col] != 0) {
					return false;
				}
			}
		}
		return true;
	}

}
