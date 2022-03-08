import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Pro_ItemRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] rectangle = {{2,2,5,5},{1,3,6,4},{3,1,4,6}};
		int characterX = 1;
		int characterY = 4;
		int itemX = 6;
		int itemY = 3;
		
		solution(rectangle, characterX, characterY, itemX, itemY);
	}
	
	static final int MAX = 50;
	
    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        boolean[][] visited = new boolean[MAX + 1][MAX + 1];
        int[] dX = {0, 0, 1, -1}, dY = {1, -1, 0, 0};
        Queue<Integer> q = new LinkedList<>();
        q.add(characterX);
        q.add(characterY);
        q.add(0);      
        
        while(!q.isEmpty()) {
        	int x = q.poll(), y = q.poll(), count = q.poll();
        	
        	if(x == itemX && y == itemY) {
        		answer = count;
        		return answer;
        	}
        	
        	visited[x][y] = true;
        	
        	for(int idx = 0; idx < dX.length; ++idx) {
        		int nextX = x + dX[idx], nextY = y + dY[idx];
        		
            	if (nextX != 0 && nextX <= MAX && nextY != 0 && nextY <= MAX && check(x, y, nextX, nextY, rectangle, visited) ) {
            		q.add(nextX);
            		q.add(nextY);
            		q.add(count + 1);
            	}
        	}
        }
        
        return answer;
    }

	private static boolean check(int prevX, int prevY, int x, int y, int[][] rectangle, boolean[][] visited) {
		boolean result = false;
		if(visited[x][y]) return false;
		for(int idx = 0; idx < rectangle.length; ++idx) {
			int sX = rectangle[idx][0], sY = rectangle[idx][1], eX = rectangle[idx][2], eY = rectangle[idx][3];
			double hX = (double)(x + prevX) / 2, hY = (double)(y + prevY) / 2;
			if(sX < hX && hX < eX && sY < hY && hY < eY) return false;
			else if(sX <= prevX && prevX <= eX && sY <= prevY && prevY <= eY) {
				if((sX == x || eX == x) && sY <= y && y <= eY) result = true;
				else if((sY == y || eY == y) && sX < x && x <= eX) result = true;
			}
		}
		
		return result;
	}
}
