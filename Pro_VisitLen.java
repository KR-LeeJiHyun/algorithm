
public class Pro_VisitLen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(String dirs) {
        int answer = 0;
        final int MAX = 11;
        boolean[][][] visited = new boolean[MAX][MAX][4];
        int x = 5, y = 5;
        
        for(int idx = 0; idx < dirs.length(); ++idx) {
        	char arrow = dirs.charAt(idx);
        	int nX = x, nY = y;
        	if(arrow == 'U') {
        		++nX;
        	}
        	else if(arrow == 'D') {
        		--nX;
        	}
        	else if(arrow == 'R') {
        		++nY;
        	}
        	else if(arrow == 'L') {
        		--nY;
        	}
        	
        	if(nX < 0 || nY < 0 || nX == MAX || nY == MAX) continue;
        	
        	if(arrow == 'U') {
        		if(!visited[x][y][0]) ++answer;
            	visited[x][y][0] = true;
            	visited[nX][nY][1] = true;
        	}
        	else if(arrow == 'D') {
        		if(!visited[x][y][1]) ++answer;
            	visited[x][y][1] = true;
            	visited[nX][nY][0] = true;
        	}
        	else if(arrow == 'R') {
        		if(!visited[x][y][2]) ++answer;
            	visited[x][y][2] = true;
            	visited[nX][nY][3] = true;
        	}
        	else if(arrow == 'L') {
        		if(!visited[x][y][3]) ++answer;
            	visited[x][y][3] = true;
            	visited[nX][nY][2] = true;
        	}
        	
        	x = nX;
        	y = nY;
        }
        
        
        return answer;
    }

}
