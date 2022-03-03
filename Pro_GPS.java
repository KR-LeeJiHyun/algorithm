import java.util.ArrayList;

public class Pro_GPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int m = 10;
		int k = 6;
		int[] gps_log = {1, 2, 3, 3, 6, 7};
		int[][] edge_list = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}};
		
		solution(n, m, edge_list, k, gps_log);
		
	}
	
    public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {   
        int answer = 0;
    	
        ArrayList<Integer>[] map = new ArrayList[n + 1];
        for(int idx = 1; idx < n + 1; ++idx) { 
        	map[idx] = new ArrayList<>();
        	map[idx].add(idx);
        }
        for(int idx = 0; idx < m; ++idx) {
        	map[edge_list[idx][0]].add(edge_list[idx][1]);
        	map[edge_list[idx][1]].add(edge_list[idx][0]);
        }
        
        int[][] dp = new int[k][n + 1];
    	
    	for(int col = 1; col <= n; ++col) dp[0][col] = -1;
        dp[0][gps_log[0]] = 0;
        
        for(int row = 1; row < k; ++row) {
        	for(int col = 1; col <= n; ++col) {
        		int min = -1;
        		if(gps_log[row] != col) {
        			for(int node : map[col]) {
        				int result = dp[row - 1][node];
        				if(result != -1) {
        					if(min > result || min == -1) min = result + 1;
        				}
        			}
        		}
        		else {
        			for(int node : map[col]) {
        				int result = dp[row - 1][node];
        				if(result != -1) {
        					if(min > result || min == -1) min = result;
        				}
        			}
        		}
        		dp[row][col] = min;
        	}
        }
        
        answer = dp[k -1][gps_log[k - 1]];
        return answer;
    }
   
}
