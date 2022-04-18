
public class Pro_LandGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    int solution(int[][] land) {
        int answer = 0, rLen = land.length, cLen = 4;
        int[][] dp = new int[rLen][cLen], max;
        
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        for(int row = 1; row < rLen; ++row) {
        	max = new int[2][2];
        	for(int col = 0; col < cLen; ++col) {
        		if(max[0][0] < dp[row - 1][col]) {
        			max[1][0] = max[0][0];
        			max[1][1] = max[0][1];
        			max[0][0] = dp[row - 1][col];
        			max[0][1] = col;
        		}
        		else if(max[1][0] < dp[row - 1][col]) {
        			max[1][0] = dp[row - 1][col];
        			max[1][1] = col;
        		}
        	}
        	
        	for(int col = 0; col < cLen; ++col) {
        		if(max[0][1] != col) dp[row][col] = max[0][0] + land[row][col];
        		else dp[row][col] = max[1][0] + land[row][col];
        	}
        }
        
    	for(int col = 0; col < cLen; ++col) answer = Math.max(answer, dp[rLen - 1][col]);

        return answer;
    }

}
