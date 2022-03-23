
public class Pro_NotDestroyBuilding {

	public static void main(String[] args) {
		int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
		int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
		solution(board, skill);
	}
    public static int solution(int[][] board, int[][] skill) {
        int rlen = board.length, clen = board[0].length, answer = rlen * clen;
        int[][] sum = new int[rlen][clen];
        for(int sIdx = 0; sIdx < skill.length; ++sIdx) {
        	int type = skill[sIdx][0], sr = skill[sIdx][1], sc = skill[sIdx][2], er = skill[sIdx][3], ec = skill[sIdx][4], power = skill[sIdx][5];
        	if(type == 1) power *= -1;
        	sum[sr][sc] += power;
        	if(er + 1 < rlen && ec + 1 < clen) sum[er + 1][ec + 1] += power;
        	if(er + 1 < rlen) sum[er + 1][sc] += -power;
        	if(ec + 1 < clen) sum[sr][ec + 1] += -power;
        }
      
        for(int row = 0; row < rlen - 1; ++row) {
        	for(int col = 0; col < clen; ++col) {
        		sum[row + 1][col] += sum[row][col];
        	}
        }
        
        for(int col = 0; col < clen - 1; ++col) {
        	for(int row = 0; row < rlen; ++row) {
        		sum[row ][col + 1] += sum[row][col];
        	}
        }
        
        for(int row = 0; row < rlen; ++row) {
        	for(int col = 0; col < clen; ++col) {
        		if(board[row][col] + sum[row][col] <= 0) --answer; 
        	}
        }
        
        return answer;
    }

}
