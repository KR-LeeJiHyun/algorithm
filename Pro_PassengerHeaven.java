import java.util.Arrays;

public class Pro_PassengerHeaven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 3;
		int n = 6;
		int[][] cityMap = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
		
		solution(m, n, cityMap);
	}
	
    static int MOD = 20170805;
    static int[] dr = {1, 0};
	static int[] dc = {0, 1};
    static int[][][] visited;
    
    public static int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        visited = new int[m][n][dr.length];
        for(int row = 0; row < m; ++row) {
        	for(int col = 0; col < n; ++col) Arrays.fill(visited[row][col], -1);
        }
        visited[m - 1][n - 1][0] = 1;
        visited[m - 1][n - 1][1] = 1;
        
        
        answer = dfs(0, 0, -1, m, n, cityMap);
        
        return answer;
    }
    
    public static int dfs(int row, int col, int arrow, int m, int n, int[][] cityMap) {
    	int result = 0;
		
    	for(int idx = 0; idx <dr.length; ++idx) {
			int next_row = row + dr[idx], next_col = col + dc[idx];
			if(next_row < 0 || next_col < 0 || next_row >= m || next_col >= n || cityMap[next_row][next_col] == 1) continue;
			
			if(cityMap[row][col] == 0) {
				if(visited[next_row][next_col][idx] == -1) result += dfs(next_row, next_col, idx, m, n, cityMap);
				else result += visited[next_row][next_col][idx];
			}
			else if (cityMap[row][col] == 2) {
				if(arrow == -1 || arrow == idx) {
					if(visited[next_row][next_col][idx] == -1) result += dfs(next_row, next_col, idx, m, n, cityMap);
					else result += visited[next_row][next_col][idx];
				}
			}
		}
    	result %= MOD;
    	if(arrow != -1)visited[row][col][arrow] = result;
    	else {
    		visited[row][col][0] = result;
    	}
    	return result;
    }

}
