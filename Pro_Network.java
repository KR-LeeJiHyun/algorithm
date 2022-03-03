
public class Pro_Network {
	
	boolean[] visited;
	
	public void dfs(int n, int computer, int[][] computers) {
		visited[computer] = true;
		
		for(int next_computer = 0; next_computer < n; ++next_computer) {
			if(computer != next_computer && computers[computer][next_computer] == 1 && !visited[next_computer]) dfs(n, next_computer, computers);
		}
	}
	
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int idx = 0; idx < n; ++idx) {
        	if (!visited[idx]) {
        		++answer;
        		dfs(n, idx, computers);
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
