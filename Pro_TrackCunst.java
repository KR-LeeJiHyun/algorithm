import java.util.PriorityQueue;

public class Pro_TrackCunst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {
				{0,0,0,0,0,0,0,0},
				{1,0,1,1,1,1,1,0},
				{1,0,0,1,0,0,0,0},
				{1,1,0,0,0,1,1,1},
				{1,1,1,1,0,0,0,0},
				{1,1,1,1,1,1,1,0},
				{1,1,1,1,1,1,1,0},
				{1,1,1,1,1,1,1,0}
		};
		
		solution(board);
	}
	
	final static int up = 0, down = 1, left = 2, right = 3;
	final static int [] d_row = {-1, 1, 0, 0}, d_col = {0, 0, -1, 1};
	
	static class Car implements Comparable<Car>{
		int cost;
		int arrow;
		int row ;
		int col;
		
		public Car() {
			this.cost = 0;
			this.arrow = -1;
			this.row = 0;
			this.col = 0;
		}
		
		public Car(int cost, int arrow, int row, int col) {
			this.cost = cost;
			this.arrow = arrow;
			this.row = row;
			this.col = col;
		}
		
		public int compareTo(Car o) {
			return this.cost - o.cost;
		}
		
	}
	
	
	
    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int N = board.length;
        final int straight = 100, conner = 500;
        int[][] visited = new int[N][N];
        PriorityQueue<Car> pq = new PriorityQueue<>();
        
        pq.add(new Car());
        
        while(!pq.isEmpty()) {
        	Car tmp = pq.poll();
        	
        	if(tmp.row == N - 1 && tmp.col == N - 1) {
        		int cost = tmp.cost;
        		answer = Math.min(cost, answer);
        		continue;
        	}
        	
        	if(tmp.arrow != -1) visited[tmp.row][tmp.col] = (visited[tmp.row][tmp.col] | (1 << tmp.arrow));
        	else visited[tmp.row][tmp.col] = 15;

    		for(int idx = 0; idx <d_row.length; ++idx) {
    			int next_row = tmp.row + d_row[idx], next_col = tmp.col + d_col[idx];
    			
    			if(next_row < 0 || next_col < 0 || next_row >= N || next_col >= N) continue;
    			else if(board[next_row][next_col] == 0) {
    				int cost = tmp.cost + straight;
    				if(tmp.arrow != -1 && tmp.arrow != idx) cost += conner;
    				if(((visited[next_row][next_col] >> idx) & 1) == 0) pq.add(new Car(cost, idx, next_row, next_col));
    			}
    		}
        }
        
        return answer;
    }

}
