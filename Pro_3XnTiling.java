
public class Pro_3XnTiling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(int n) {
        int answer = 0;
        final int MOD = 1000000007;
        
        if(n >= 4){
        long[] dp = new long[n + 1];
            dp[0] = 0l;
            dp[1] = 0l;
            dp[2] = 3l;
            dp[3] = 0l;
            dp[4] = 11l;
        
            for(int idx = 5; idx <= n; ++idx) {
            	dp[idx] = ((long)dp[idx - 2] * dp[2] + (long)dp[idx - 4] * 2) % MOD;
            	if(dp[idx] != 0) dp[idx] = dp[idx] + 2;
            }
        
            answer = (int)dp[n];
            return answer;
        }
        else if(n == 2) return 3;
        else if(n == 4) return 11;
        else return 0;
    }

}
