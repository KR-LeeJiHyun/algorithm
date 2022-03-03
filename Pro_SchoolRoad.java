
public class Pro_SchoolRoad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3, m = 4;
		int[][] puddles = {{}};
		System.out.print(solution(m, n, puddles));

	}
	
	static int[][] map;
	static int num = 1000000007;
	
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        map = new int[n][m];
        
        
        for(int idx = 0; idx < puddles.length; ++idx) {
        	if(puddles[idx].length != 0) map[puddles[idx][1] - 1][puddles[idx][0] - 1] = -1;
        }
        
        answer = dfs(0, 0, n, m);
        
        return answer;
    }
    
    public static int dfs(int cRow, int cCol, int n, int m) {
    	if(n == cRow + 1 && m == cCol + 1) {
    		map[cRow][cCol] = 1;
    		return 1;
    	}

    	int result = 0;
    	int[] dRow = {1, 0}, dCol = {0, 1};

    	for(int idx = 0; idx < dRow.length; ++idx) {
    		int nRow = cRow + dRow[idx], nCol = cCol + dCol[idx];
    		if(nRow == n || nCol == m) continue;
    		if(map[nRow][nCol] != -1) {
    			if(map[nRow][nCol] == 0) result = (result + dfs(nRow, nCol, n, m)) % num;
    			else result = (result + map[nRow][nCol]) % num;
    		}
    	}
        
        map[cRow][cCol] = result;
    	
    	return result;
    }
}
