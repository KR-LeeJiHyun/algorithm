import java.util.HashSet;

public class Pro카운트다운 {

	public static void main(String[] args) {
		int target = 21;
		Pro카운트다운 S = new Pro카운트다운();
		S.solution(target);
	}
	
    public int[] solution(int target) {
        int[] answer = {0, 0};
        int[][] dp = new int[target + 1][2];
        final int BOOL = 50;
        
        HashSet<Integer> scores = new HashSet<>();
        for(int score = 1; score <= Math.min(target, 20); ++score) {
        	scores.add(score);
        	dp[score][0] = 1;
        	dp[score][1] = 1;
        	if(score * 2 <= target) {
        		dp[score * 2][0] = 1;
        		scores.add(score * 2);
        	}
        	if(score * 3 <= target) {
        		dp[score * 3][0] = 1;
        		scores.add(score * 3);
        	}
        }
        
        if(target >= BOOL) {
        	dp[BOOL][0] = 1;
        	dp[BOOL][1] = 1;
        	scores.add(BOOL);
        }
        
        for(int total = 23; total <= target; ++total) {
        	if(dp[total][0] != 0) {
        		continue;
        	}
        	int min = Integer.MAX_VALUE;
        	int sum = 0;
        	
        	for(int score : scores) {
        		if(total <= score) {
        			break;
        		}
        		if(min > dp[score][0] + dp[total - score][0]) {
        			min = dp[score][0] + dp[total - score][0];
        			sum = dp[score][1] + dp[total - score][1];
        		}
        		if(min == dp[score][0] + dp[total - score][0] && sum < dp[score][1] + dp[total - score][1]) {
        			min = dp[score][0] + dp[total - score][0];
        			sum = dp[score][1] + dp[total - score][1];
        		}
        	}
        	dp[total][0] = min;
        	dp[total][1] = sum;
        }
        
        answer[0] = dp[target][0];
        answer[1] = dp[target][1];
        
        return answer;
    }

}
