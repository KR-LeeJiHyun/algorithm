
public class Pro_StickerCollect {

	public static void main(String[] args) {
		int[] sticker = {1, 2};
		solution(sticker);
	}
	
    public static int solution(int sticker[]) {
        int answer = 0;
        int len = sticker.length;
        
        if(len == 1) return sticker[0];
        
        int[] dp = new int[len + 1];
        
        dp[1] = sticker[0];
        dp[2] = sticker[1];
        for(int idx = 3; idx < len; ++idx) {
        	dp[idx] = Math.max(dp[idx - 2], dp[idx - 3]) + sticker[idx - 1];
        	answer = Math.max(answer, dp[idx]);
        }
        
        dp[1] = sticker[1];
        dp[2] = sticker[2];
        for(int idx = 3; idx < len; ++idx) {
        	dp[idx] = Math.max(dp[idx - 2], dp[idx - 3]) + sticker[idx];
        	answer = Math.max(answer, dp[idx]);
        }
        
        return answer;
    }

}
