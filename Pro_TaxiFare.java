import java.util.Arrays;

public class Pro_TaxiFare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7, s = 3, a = 4, b = 1;
		int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
		solution(n, s, a, b, fares);
	}
	
	final static int INF = 2147483646;
	
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        int[][]map = new int[n + 1][n + 1];
        for(int idx = 1; idx <= n; ++idx) {
        	Arrays.fill(map[idx], INF);
        	map[idx][idx] = 0;
        }
        for(int idx = 0; idx < fares.length; ++idx) {
        	int first = fares[idx][0], second = fares[idx][1], fare = fares[idx][2];
            if(map[first][second] > fare){
        	    map[first][second] = fare;
        	    map[second][first] = fare;
            }
        }
        
        for(int k = 1; k <= n; ++k) {
        	for(int i = 1; i <= n; ++i) {
        		for(int j = 1; j <= n; ++j) {
        			if(map[i][k] != INF && map[k][j] != INF) map[i][j] = Math.min(map[i][j], map[i][k]+ map[k][j]);
        		}
        	}
        }
        
        for(int waypoint = 1; waypoint <= n; ++waypoint) {
        	if(map[s][waypoint] != INF && map[waypoint][a] != INF && map[waypoint][b] != INF) answer = Math.min(answer, map[s][waypoint] + map[waypoint][a] + map[waypoint][b]);
        }
        
        return answer;
    }

}
