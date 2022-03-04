
public class Pro_Fatigue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] visited = new boolean [dungeons.length];
        
        answer = dfs(k, 0, dungeons, visited);
        
        return answer;
    }
    
    public int dfs(int k, int cnt, int[][] dungeons,  boolean[] visited) {
    	int result = cnt;
    	for(int idx = 0; idx < dungeons.length; ++idx) {
    		if(dungeons[idx][0] <= k && !visited[idx]) {
    			boolean[] tmp = visited.clone();
    			tmp[idx] = true;
    			result = Math.max(result, dfs(k - dungeons[idx][1], cnt + 1, dungeons, tmp));
    		}
    	}
    	return result;
    }

}
