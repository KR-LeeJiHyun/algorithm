
public class Pro_Fibonacci {

	public static void main(String[] args) {
		
	}
	
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        
        for(int idx = 2; idx <= n; ++idx) dp[idx] = (dp[idx - 2] + dp[idx - 1]) % 1234567;
        answer = dp[n];
        
        return answer;
    }

}
