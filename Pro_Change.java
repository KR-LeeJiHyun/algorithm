
public class Pro_Change {

	public static void main(String[] args) {
		int n = 5;
		int[] money = {1, 2, 3};
		solution(n, money);
	}
	
    public static int solution(int n, int[] money) {
        int answer, len = money.length, mod = 1000000007;
        long[][] dp = new long[n + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
   
        int current = 0;
        
    	for(int idx = 0; idx < len; ++idx) {
    		int prev = (current + 1) % 2;
    		int m = money[idx];
    		for(int change = 1; change <= n; ++change) {
    			dp[change][current] = dp[change][prev];
    			if(change >= m) {
    				dp[change][current] += dp[change - m][current];
    			}
    		}    	            
    		current = prev;
    	}
        
     
        answer = (int)dp[n][(current + 1) % 2] % mod;
        return answer;
    }

}
