
public class Pro_2XnTiling {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(8);
	}
	
    public static int solution(int n) {
        int answer = 0;
        long num = 1000000007l;
        long[] dp = new long[n + 1];
        
        dp[0] = 0l;
        dp[1] = 1l;
        dp[2] = 2l;
        
        for(int idx = 3; idx <= n; ++idx) dp[idx] = ((long)dp[idx - 1] + (long)dp[idx - 2] * 2) % num;
        
        answer = (int)dp[n];
        return answer;
    }
}
