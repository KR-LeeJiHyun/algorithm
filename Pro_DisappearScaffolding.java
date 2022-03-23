public class Pro_DisappearScaffolding {

	public static void main(String[] args) {
		int[][] board = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
		int[] aloc = {1, 0}, bloc = {1, 2};
		solution(board, aloc, bloc);
	}
	
	
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};	
	
	static class Result {
		boolean win;
		int cnt;
		
		public Result(boolean win, int cnt) {
			this.win = win;
			this.cnt = cnt;
		}
	}
	
    public static int solution(int[][] board, int[] aloc, int[] bloc) {
        int answer = -1;
        
        answer = turnA(board, aloc, bloc, 0).cnt;
        
        return answer;
    }

	private static Result turnA(int[][] board, int[] aloc, int[] bloc, int cnt) {
		int min = 5*5, max = 0, ar = aloc[0], ac = aloc[1];
		boolean win = false;
		
		if(board[ar][ac] == 0) return new Result(win, cnt);
		for(int idx = 0; idx < dr.length; ++idx){
			int nr = ar + dr[idx], nc = ac + dc[idx];
			if(nr < 0 || nc < 0 || nr == board.length || nc == board[0].length) continue;
			if(board[nr][nc] == 1) {
				board[ar][ac] = 0;
				int[] naloc = {nr, nc};
				Result result = turnB(board,naloc, bloc, cnt + 1);
				win |= !result.win;
				if(!result.win) min = Math.min(min, result.cnt);
				if(result.win) max = Math.max(max, result.cnt);
				board[ar][ac] = 1; 
			}
		}
		
		if(win) return new Result(win, min);
		else return new Result(win, max);
	}
	

	private static Result turnB(int[][] board, int[] aloc, int[] bloc, int cnt) {
		int min = 5*5, max = cnt, br = bloc[0], bc = bloc[1];
		boolean win = false;
		if(board[br][bc] == 0) return new Result(win, cnt);
		for(int idx = 0; idx < dr.length; ++idx){
			int nr = br + dr[idx], nc = bc + dc[idx];
			if(nr < 0 || nc < 0 || nr == board.length || nc == board[0].length) continue;
			if(board[nr][nc] == 1) {
				board[br][bc] = 0;
				int[] nbloc = {nr, nc};
				Result result = turnA(board, aloc, nbloc, cnt + 1);
				win |= !result.win;
				if(!result.win) min = Math.min(min, result.cnt);
				if(result.win) max = Math.max(max, result.cnt);
				board[br][bc] = 1; 
			}
		}
		
		if(win) return new Result(win, min);
		else return new Result(win, max);
	}

}
