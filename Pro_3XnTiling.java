
public class Pro_3XnTiling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(solution(6));
	}
	
    public static int solution(int n) {
        int answer = 0;
        final int MOD = 1000000007;
        
        if(n != 0 && n % 2 == 0){
        long[] dp = new long[n + 1];
            dp[2] = 3l;
            
            for(int idx = 4; idx <= n; idx += 2) {
            	dp[idx] = dp[idx - 2] * dp[2]; 
            	for(int sIdx = 4; sIdx < idx; sIdx += 2) {
            		dp[idx] += dp[idx - sIdx] * 2;
            	}
            	dp[idx] += 2;
            }
        
            answer = (int)dp[n] % MOD;
            return answer;
        }
        else return answer;
    }

}
