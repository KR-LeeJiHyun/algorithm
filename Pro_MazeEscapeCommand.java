
public class Pro_MazeEscapeCommand {

	public static void main(String[] args) {
		
		int n = 2, m = 1, x = 2, y = 1, r = 1, c = 1, k = 3;
		
		Pro_MazeEscapeCommand PME = new Pro_MazeEscapeCommand();
		System.out.println(PME.solution(n, m, x, y, r, c, k));

	}
	
	int[] dRow = {1, 0, 0, -1}, dCol = {0, -1, 1, 0};
	int[] pair = {3, 2, 1, 0};
	char[] arrow = {'d', 'l', 'r', 'u'};
	final int LEN = 4;
	
	public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        
        int[] aCnt = new int[LEN];
        aCnt[0] = Math.max(0, r - x);
        aCnt[1] = Math.max(0, y - c);
        aCnt[2] = Math.max(0, c - y);
        aCnt[3] = Math.max(0, x - r);
        int cnt = aCnt[0] + aCnt[1] + aCnt[2] + aCnt[3];
        
        if(k >= cnt) answer = dfs(n, m, x, y, r, c, k, aCnt, "");
        else answer = "impossible";
        
        return answer;
    }

	private String dfs(int n, int m, int x, int y, int r, int c, int k, int[] aCnt, String answer) {
		
		int cnt = aCnt[0] + aCnt[1] + aCnt[2] + aCnt[3];
		
		if(cnt > k) return "impossible";
		
		else if(k != cnt) {
			for(int idx = 0; idx < LEN; ++idx) {
				int nr = x + dRow[idx];
				int nc = y + dCol[idx];
				
				if(nr < 1 || nc < 1 || nr > n || nc > m) continue;
				
				if(aCnt[idx] != 0) {
					--aCnt[idx];
				}
				else {
					++aCnt[pair[idx]];
				}
				
				return dfs(n, m, nr, nc, r, c, --k, aCnt, answer + arrow[idx]);
			}
		}
		 
		else {
            int idx = 0;
			while(k > 0) {
				int nr = x + dRow[idx];
				int nc = y + dCol[idx];
				
				if(nr < 1 || nc < 1 || nr > n || nc > m || aCnt[idx] == 0) {
                    ++idx;
                    continue;
                }
				
                x = nr;
                y = nc;
                
				--aCnt[idx];
				answer += arrow[idx]; 
				idx = 0;
				--k;
			}
			
			return answer;
			/* for문이 더 빠름
			for(int idx = 0; idx < LEN; ++idx) {
				if(k == 0) break;
				
				int nr = x + dRow[idx];
				int nc = y + dCol[idx];
				
				if(nr < 1 || nc < 1 || nr > n || nc > m || aCnt[idx] == 0) continue;
				
                x = nr;
                y = nc;
                
				--aCnt[idx];
				answer += arrow[idx]; 
				idx = -1;
				--k;
			}
			
			return answer;
			*/
		}
		
		return "impossible";
	}

}
