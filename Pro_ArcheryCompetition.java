public class Pro_ArcheryCompetition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
		
		solution(n, info);
	}
	
	final static int MAX = 11;
	static int diff = 0;
	static int[] answer;
	static boolean[] visited = new boolean[MAX];
	
    public static int[] solution(int n, int[] info) {
    	
        int[] rian = new int[MAX];
        
        dfs(n, info, rian);
        
        if(answer == null) {
        	int[] tAnswer = {-1};
        	return tAnswer;
        }
        return answer;
    }

	private static void dfs(int n, int[] info, int[] rian) {
		if(n == 0) {
			int rScore = 0, aScore = 0;
			for(int idx = 0; idx < MAX; ++idx) {
				if(info[idx] >= rian[idx] && info[idx] != 0) aScore += MAX - 1 - idx;
				else if(rian[idx] > info[idx]) rScore += MAX - 1 - idx;
			}
			if(aScore < rScore && diff <= rScore - aScore) {
				diff = rScore - aScore;
				answer = rian.clone();
			}
			return;
		}
		
		for(int idx = 0; idx < MAX; ++idx) {
			if(!visited[idx] && rian[idx] + n > info[idx]) {
				int arrow = info[idx] + 1;
				rian[idx] += arrow;
				visited[idx] = true;
				dfs(n - arrow, info, rian);
				visited[idx] = false;
				rian[idx] -= arrow;
			}
			else if(idx == MAX - 1) {
				rian[10] += n;
				dfs(0, info, rian);
				rian[10] -= n;
			}
		}
	}
    
    

}
