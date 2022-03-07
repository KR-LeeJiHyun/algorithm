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
        Queue<Integer> q = new LinkedList<>();
        q.add(characterX);
        q.add(characterY);
        q.add(0);      
        Queue<ArrayList<Integer>> qList = new LinkedList<>();
        qList.add(new ArrayList<>());
        
        while(!q.isEmpty()) {
        	int x = q.poll(), y = q.poll(), count = q.poll();
        	ArrayList<Integer> path = qList.poll();
        	path.add(x);
        	path.add(y);
        	
        	if(x == itemX && y == itemY) {
        		answer = count;
        		for(int idx = 0; idx < path.size(); idx += 2) System.out.print(path.get(idx) + "," + path.get(idx + 1) + " -> ");
        		System.out.println();
        		return answer;
        	}
        	
        	visited[x][y] = true;
        	
        	//up
        	if(y != MAX && check(x, y, x, y + 1, rectangle, visited) ) {
        		q.add(x);
        		q.add(y + 1);
        		q.add(count + 1);
        		qList.add((ArrayList<Integer>) path.clone());
        	}
        	//down
        	if(y != 0 && check(x, y, x, y - 1, rectangle, visited)) {
        		q.add(x);
        		q.add(y - 1);
        		q.add(count + 1);
        		qList.add((ArrayList<Integer>) path.clone());
        	}
        	//right
        	if(x != MAX && check(x, y, x + 1, y, rectangle, visited)) {
        		q.add(x + 1);
        		q.add(y);
        		q.add(count + 1);
        		qList.add((ArrayList<Integer>) path.clone());
        	}
        	//left
        	if(x != 0 && check(x, y, x - 1, y, rectangle, visited)) {
        		q.add(x - 1);
        		q.add(y);
        		q.add(count + 1);
        		qList.add((ArrayList<Integer>) path.clone());
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
