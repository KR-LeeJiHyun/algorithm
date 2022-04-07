
public class Pro_LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdcba";
		solution(s);
	}
	
    public static int solution(String s) {
        int answer = 1, len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int idx = 0; idx < len; ++idx) dp[idx][idx] = true;
        
        for(int l = 1; l < len; ++l) {
        	for(int start = 0; start < len - l; ++start) {
        		int end = start + l;
        		if(s.charAt(start) == s.charAt(end)) {
        			if(start + 1 > end - 1 || dp[start + 1][end - 1]) {
        				dp[start][end] = true;
        				answer = l + 1;
        			}
        		}
        	}
        }
        
        return answer;
    }

}
