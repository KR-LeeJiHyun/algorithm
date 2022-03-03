import java.util.Queue;
import java.util.LinkedList;

public class Pro_ShortestDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length, m = maps[0].length;
        int [] d_row = {-1, 1, 0, 0}, d_col = {0, 0, -1, 1};
        Queue<Integer> q_row = new LinkedList<>();
        Queue<Integer> q_col = new LinkedList<>();
        Queue<Integer> q_cnt = new LinkedList<>();
        q_row.add(0);
        q_col.add(0);
        q_cnt.add(1);
        maps[0][0] = 0;
        
        while(!q_row.isEmpty()) {
        	int row = q_row.poll();
        	int col = q_col.poll();
        	int cnt = q_cnt.poll();
        	
        	if(row + 1 == n && col + 1 == m) {
        		answer = cnt;
        		break;
        	}
        	
    		for(int idx = 0; idx < d_row.length; ++idx) {
    			int nextRow = row + d_row[idx], nextCol = col + d_col[idx];
    			if(nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m) continue;
    			if(maps[nextRow][nextCol] == 1) {
    				maps[nextRow][nextCol] = 0;
    				q_row.add(nextRow);
    				q_col.add(nextCol);
    				q_cnt.add(cnt + 1);
    			}
    		}
        }
        
        return answer;
    }

}
