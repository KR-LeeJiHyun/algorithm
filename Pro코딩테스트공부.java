import java.util.Arrays;

public class Pro코딩테스트공부 {

	public static void main(String[] args) {
		Pro코딩테스트공부 S = new Pro코딩테스트공부();
		int alp = 10;
		int cop = 10;
		int[][] problems = {{10,15,2,1,2},{20,20,3,3,4}};
		S.solution(alp, cop, problems);

	}
	
    public int solution(int alp, int cop, int[][] problems) {
        int answer = Integer.MAX_VALUE;
        final int MAX = 450;
        int[][] dp = new int[MAX + 1][MAX + 1];
        for(int idx = 0; idx <= MAX; ++idx) {
        	Arrays.fill(dp[idx], (int)1e9);
        }
        
        dp[alp][cop] = 0;
        
        int maxAlp = 0;
        int maxCop = 0;
        for(int idx = 0; idx < problems.length; ++idx) {
        	maxAlp = Math.max(maxAlp, problems[idx][0]);
        	maxCop = Math.max(maxCop, problems[idx][1]);
        }
        
        if(maxAlp <= alp && maxCop <= cop) {
        	return 0;
        }
        
        for(int a = alp; a <= MAX; ++a) {
        	for(int c = cop; c <= MAX; ++c) {	
        		if(a - 1 >= 0) {
        			dp[a][c] = Math.min(dp[a][c], dp[a - 1][c] + 1);
        		}
        		if(c - 1 >= 0) {
        			dp[a][c] = Math.min(dp[a][c], dp[a][c - 1] + 1);
        		}
        		for(int idx = 0; idx < problems.length; ++idx) {
        			int alp_req = problems[idx][0];
        			int cop_req = problems[idx][1]; 
        			int alp_rwd = problems[idx][2]; 
        			int cop_rwd = problems[idx][3];
        			int cost = problems[idx][4];
        			
        			if(alp_req <= a - alp_rwd && cop_req <= c - cop_rwd) {
        				dp[a][c] = Math.min(dp[a][c], dp[a - alp_rwd][c - cop_rwd] + cost);
        			}
                }
        	}
        }
        
        
        for(int a = maxAlp; a <= MAX; ++a) {
        	for(int c = maxCop; c <= MAX; ++c) {
        		answer = Math.min(answer, dp[a][c]);
        	}
        }

        return answer;
    }

}
