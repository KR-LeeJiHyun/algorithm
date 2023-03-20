public class Pro최적의행렬곱셈 {

	public static void main(String[] args) {
		int[][] matrix_sizes = {{5, 3}, {3, 10}, {10, 6}};
		Pro최적의행렬곱셈 S = new Pro최적의행렬곱셈();
		S.solution(matrix_sizes);

	}
	
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        final int LEN = matrix_sizes.length;
        final int ROW = 0;
        final int COL = 1;
        int[][] dp = new int[LEN][LEN];
        
        for(int cnt = 1; cnt < LEN; ++cnt) {
        	for(int start = 0; start < LEN - cnt; ++start) {
        		int end = start + cnt;
        		for(int mid = start; mid < end; ++mid) {
        			int result = dp[start][mid] + dp[mid + 1][end] + (matrix_sizes[start][ROW] * matrix_sizes[mid][COL] * matrix_sizes[end][COL]);
        			if(dp[start][end] == 0 || dp[start][end] > result) {
        				dp[start][end] = result;
        			}
        		}
        	}
        }
        
        answer = dp[0][LEN - 1];
        return answer;
    }


}
