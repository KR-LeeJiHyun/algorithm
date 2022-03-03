import java.util.ArrayList;
import java.util.Arrays;

public class Pro_CycleOfLight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] grid = {"R","R"};
		solution(grid);
	}
	
	static final int up = 0, down = 1, left = 2, right = 3;
	static boolean[][][] visited;
	
    public static int[] solution(String[] grid) {
        int[] answer = {};
        ArrayList<Integer> tmpAnswer = new ArrayList();
        visited = new boolean[grid.length][grid[0].length()][4];
        
        for(int row = 0; row < grid.length; ++row) {
        	for(int col = 0; col < grid[row].length(); ++col) {
        		int nodeNum = row * grid[row].length() + col;
        		for(int arrow = 0; arrow < 4; ++arrow) {
        			if(!visited[row][col][arrow]) tmpAnswer.add(dfs(row, col, arrow, grid, 0));
        		}
        	}
        }
        
        answer = new int[tmpAnswer.size()];
        for(int idx = 0; idx < tmpAnswer.size(); ++idx) answer[idx] = tmpAnswer.get(idx);
        Arrays.sort(answer);
        return answer;
    }
    
    public static int dfs(int row, int col, int arrow, String[] grid, int dep) {
    	while(true) {
    		++dep;
    		visited[row][col][arrow] = true;
    		int nextRow = row, nextCol = col;

    		if(grid[row].charAt(col) == 'S') {	
    			if(arrow == up) {
    				if(nextRow != 0) --nextRow;
    				else nextRow = grid.length - 1;
    			}
    			else if(arrow == down) {
    				nextRow = (nextRow + 1) % grid.length;
    			}
    			else if(arrow == left) {
    				if(nextCol != 0) --nextCol;
    				else nextCol = grid[0].length() - 1;
    			}
    			else {
    				nextCol = (nextCol + 1) % grid[0].length();
    			}
    		}
    		else if(grid[row].charAt(col) == 'L') {
    			//방향 변경
    			if(arrow == up) arrow = left;
    			else if(arrow == down) arrow = right;
    			else if(arrow == left) arrow = down;
    			else arrow = up;

    			if(arrow == up) {
    				if(nextRow != 0) --nextRow;
    				else nextRow = grid.length - 1;
    			}
    			else if(arrow == down) {
    				nextRow = (nextRow + 1) % grid.length;
    			}
    			else if(arrow == left) {
    				if(nextCol != 0) --nextCol;
    				else nextCol = grid[0].length() - 1;
    			}
    			else {
    				nextCol = (nextCol + 1) % grid[0].length();
    			}
    		}
    		else {
    			//방향 변경
    			if(arrow == up) arrow = right;
    			else if(arrow == down) arrow = left;
    			else if(arrow == left) arrow = up;
    			else arrow = down;

    			if(arrow == up) {
    				if(nextRow != 0) --nextRow;
    				else nextRow = grid.length - 1;
    			}
    			else if(arrow == down) {
    				nextRow = (nextRow + 1) % grid.length;
    			}
    			else if(arrow == left) {
    				if(nextCol != 0) --nextCol;
    				else nextCol = grid[0].length() - 1;
    			}
    			else {
    				nextCol = (nextCol + 1) % grid[0].length();
    			}
    		}

    		if(!visited[nextRow][nextCol][arrow]) {
    			row = nextRow;
    			col = nextCol;
    		}
    		else break;
    	}
    	return dep;
    } 

}
