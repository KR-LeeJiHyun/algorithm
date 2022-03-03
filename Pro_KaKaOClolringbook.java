import java.util.Queue;
import java.util.LinkedList;

public class Pro_KaKaOClolringbook {
	
	public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        //»óÇÏÁÂ¿ì
        int [] d_row = {-1, 1, 0, 0}, d_col = {0, 0, -1, 1};
        boolean[][] visited = new boolean[m][n];
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int row = 0; row < m; ++row) {
        	for(int col = 0; col < n; ++col) {
        		if(picture[row][col] != 0 && !visited[row][col]) {
        		//if(picture[row][col] != 0) {
        			q.offer(row);
        			q.offer(col);
        			visited[row][col] = true;
        			++numberOfArea;
        			int count = 0;
        			int area = picture[row][col];
        			picture[row][col] = 0;
        			
        			while(!q.isEmpty()) {
        				int tmp_row = q.poll(), tmp_col = q.poll();
        				++count;
        				
        				for(int idx = 0; idx <d_row.length; ++idx) {
        					int next_row = tmp_row + d_row[idx], next_col = tmp_col + d_col[idx];
        					
        					if(next_row < 0 || next_col < 0 || next_row >= m || next_col >= n) continue;
        					else if(picture[next_row][next_col] == area && !visited[next_row][next_col]) {
        					//else if(picture[next_row][next_col] == area) {
        						q.offer(next_row);
        						q.offer(next_col);
        						visited[next_row][next_col] = true;
        						picture[next_row][next_col] = 0;
        					}
        				}
        			}
        			
        			if(maxSizeOfOneArea < count) maxSizeOfOneArea = count;
        		}
        	}
        }
        
        

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int m = 6, n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		
		solution(m, n, picture);

	}
}
