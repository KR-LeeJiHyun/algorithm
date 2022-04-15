public class Pro_Theif {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] money = {1, 2, 3, 1};
		solution(money);
	}

    public static int solution(int[] money) {
    	int answer = Math.max(money[0], Math.max(money[1], money[2]));
        int len = money.length;
        int[] dp = new int[len + 1];
        
        dp[1] = money[0];
        dp[2] = money[1];
        for(int idx = 3; idx < len; ++idx) {
        	dp[idx] = Math.max(dp[idx - 2], dp[idx - 3]) + money[idx - 1];
        	answer = Math.max(answer, dp[idx]);
        }
        
        dp[1] = money[1];
        dp[2] = money[2];
        for(int idx = 3; idx < len; ++idx) {
        	dp[idx] = Math.max(dp[idx - 2], dp[idx - 3]) + money[idx];
        	answer = Math.max(answer, dp[idx]);
        }
        
        return answer;
    }
}
 