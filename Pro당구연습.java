
public class Pro당구연습 {

	public static void main(String[] args) {
		int m = 10;
		int n = 10;
		int startX = 3;
		int startY = 7;
		int[][] balls = {{7, 3}};
		
		Pro당구연습 S = new Pro당구연습();
		S.solution(m, n, startX, startY, balls);
	}
	
	final int UP = 0;
	final int DOWN = 1;
	final int LEFT = 2;
	final int RIGHT = 3;
	final int ARROW_LEN = 4;
	final int X = 0;
	final int Y = 1;
	
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
    	final int LEN = balls.length;
        int[] answer = new int[LEN];
        int[][] pos = new int[ARROW_LEN][2];
        
        pos[UP][X] = startX;
        pos[UP][Y] = 2*n - startY;
        pos[DOWN][X] = startX;
        pos[DOWN][Y] = -startY;
        pos[LEFT][X] = -startX;
        pos[LEFT][Y] = startY;
        pos[RIGHT][X] = 2*m - startX;
        pos[RIGHT][Y] = startY;
     
        for(int idx = 0; idx < LEN; ++idx) {
        	answer[idx] = Integer.MAX_VALUE;
        	//상
        	if(startX != balls[idx][X] || startY > balls[idx][Y]) {
        		answer[idx] = Math.min(answer[idx], distance(pos[UP][X], pos[UP][Y], balls[idx][X], balls[idx][Y]));
        	}
        	//하
        	if(startX != balls[idx][X] || startY < balls[idx][Y]) {
        		answer[idx] = Math.min(answer[idx], distance(pos[DOWN][X], pos[DOWN][Y], balls[idx][X], balls[idx][Y]));
        	}
        	//좌
        	if(startY != balls[idx][Y] || startX < balls[idx][X]) {
        		answer[idx] = Math.min(answer[idx], distance(pos[LEFT][X], pos[LEFT][Y], balls[idx][X], balls[idx][Y]));
        	}
        	//우
        	if(startY != balls[idx][Y] || startX > balls[idx][X]) {
        		answer[idx] = Math.min(answer[idx], distance(pos[RIGHT][X], pos[RIGHT][Y], balls[idx][X], balls[idx][Y]));
        	}
        }
        
        return answer;
    }

	private int distance(int x1, int y1, int x2, int y2) {
		return (int)((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}


}
