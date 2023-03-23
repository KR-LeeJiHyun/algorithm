import java.util.HashSet;

public class Pro연속부분수열합의갯수 {

	public static void main(String[] args) {
		int[] ele = {7,9,1,1,4};
		Pro연속부분수열합의갯수 S = new Pro연속부분수열합의갯수();
		S.solution(ele);
	}
	
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        final int LEN = elements.length;
        
        int[][] dp = new int[LEN][LEN];
        
        for(int idx = 0; idx < LEN; ++idx) {
        	dp[idx][idx] = elements[idx];
        	set.add(dp[idx][idx]);
        }
        
        for(int idx = 0; idx < LEN; ++idx) {
        	for(int sIdx = idx + 1; sIdx < LEN; ++sIdx) {
        		dp[idx][sIdx] = dp[idx][sIdx - 1] + dp[sIdx][sIdx];
        		set.add(dp[idx][sIdx]);
        	}
        }
        
        for(int idx = 2; idx < LEN; ++idx) {
        	for(int sIdx = 0; sIdx <= idx - 2; ++sIdx) {
        		set.add(dp[idx][LEN - 1] + dp[0][sIdx]);
        	}
        }
        
        answer = set.size();
        return answer;
    }

}
