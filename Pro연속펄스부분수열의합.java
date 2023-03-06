
public class Pro연속펄스부분수열의합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public long solution(int[] sequence) {
        long answer = 0;
        final int LEN = sequence.length;
        long[] dp = new long[LEN];
        
        answer = Math.max(sequence[0], sequence[0] * -1);
        dp[0] = sequence[0];
        int pulse = -1;
        for(int idx = 1; idx < LEN; ++idx) {
        	dp[idx] = Math.max(dp[idx - 1] + sequence[idx] * pulse, sequence[idx] * pulse);
        	pulse *= -1;
        	answer = Math.max(answer, dp[idx]);
        }
        
        dp[0] = sequence[0] * -1;
        pulse = 1;
        for(int idx = 1; idx < LEN; ++idx) {
        	dp[idx] = Math.max(dp[idx - 1] + sequence[idx] * pulse, sequence[idx] * pulse);
        	pulse *= -1;
        	answer = Math.max(answer, dp[idx]);
        }
        
        return answer;
    }

}
