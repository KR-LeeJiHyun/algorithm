public class Pro_LongJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public long solution(int n) {
        long answer = 0;
        final int mod = 1234567;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int idx = 2; idx <= n; ++idx) dp[idx] = (dp[idx - 1] + dp[idx - 2]) % mod;
        
        answer = dp[n];
        return answer ;
    }
}
