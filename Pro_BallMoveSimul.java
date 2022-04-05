public class Pro_BallMoveSimul {

	public static void main(String[] args) {
		int n = 2, m = 5, x = 0, y = 1;
		int[][] queries = {{3, 1}, {2, 2}, {1, 1}, {2, 3}, {0, 1}, {2, 1}};
		solution(n, m, x, y, queries);
	}

	public static long solution(int n, int m, int x, int y, int[][] queries) {
		long answer = 0;
		final int UP = 2, DOWN = 3, LEFT = 0, RIGHT = 1;
		long sr = x, er = x, sc = y, ec = y;
		
		for(int idx = queries.length - 1; idx >= 0; --idx) {
			int arrow = queries[idx][0], dx = queries[idx][1];
			if(arrow == UP) {
				if(sr > 0) sr += dx;
				er = Math.min(n - 1, er + dx);
			}
			if(arrow == DOWN) {
				if(er < n - 1) er -= dx;
				sr = Math.max(0, sr - dx);
			}
			if(arrow ==	LEFT) {
				if(sc > 0) sc += dx;
				ec = Math.min(m - 1, ec + dx);
			}
			if(arrow == RIGHT) {
				if(ec < m - 1) ec -= dx;
				sc = Math.max(0, sc - dx);
			}
			if(sr >= n || sc >= m || er < 0 || ec < 0) return 0;
		}
		answer = (er - sr + 1) * (ec - sc + 1);
		return answer;
	}

}
