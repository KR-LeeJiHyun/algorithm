import java.util.PriorityQueue;

public class Pro_UuinhabitedIslandTravel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	boolean[][] visited;
	int[] dRow = {-1, 1, 0, 0};
	int[] dCol = {0, 0, -1, 1};
	
    public int[] solution(String[] maps) {
        int[] answer = {-1};
        int rowLen = maps.length;
        int colLen = maps[0].length();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        visited = new boolean[rowLen][colLen];
        
        for(int row = 0; row < rowLen; ++row) {
        	for(int col = 0; col < colLen; ++col) {
        		if(!visited[row][col] && maps[row].charAt(col) != 'X') pq.add(dfs(row, col, rowLen, colLen, maps));
        	}
        }
        
        if(!pq.isEmpty()) {
        	answer = new int[pq.size()];
        
        	int idx = 0;
        	while(!pq.isEmpty()) answer[idx++] = pq.poll();
        }
        
        return answer;
    }

	private Integer dfs(int row, int col, int rowLen, int colLen, String[] maps) {
		int result = maps[row].charAt(col) - '0';
		visited[row][col] = true;
		
		for(int idx = 0; idx < dRow.length; ++idx) {
			int nr = row + dRow[idx];
			int nc = col + dCol[idx];
			
			if(nr < 0 || nc < 0 || nr == rowLen || nc == colLen || maps[nr].charAt(nc) == 'X' || visited[nr][nc]) continue;
			
			result += dfs(nr, nc, rowLen, colLen, maps);
		}
		
		return result;
	}

}
