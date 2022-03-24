import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_CardPair {

	public static void main(String[] args) {
		int[][] board = {{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}};
		int r = 0, c = 1;
		
		solution(board, r, c);
	}
	
	final static int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
	final static int SIZE = 4, CARDCNT = 6;
	static int cnt = 0;
	
    public static int solution(int[][] board, int r, int c) {
        int answer = 0;
        boolean[] cards = new boolean[CARDCNT + 1];
        ArrayList<Integer> path = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int row = 0; row < SIZE; ++row) {
        	for(int col = 0; col < SIZE; ++col) {
        		if(board[row][col] != 0) {
        			cards[board[row][col]] = true;
        			if(!map.containsKey(board[row][col])) map.put(board[row][col], new ArrayList<>());
        			map.get(board[row][col]).add(row);
        			map.get(board[row][col]).add(col);
        			++cnt;
        		}	
        	}
        }
        cards[0] = false;
        answer = permu(board, r, c, path, cards, map);
        
        return answer;
    }
    
    public static int permu(int[][] board, int r, int c, ArrayList<Integer> path, boolean[] cards, HashMap<Integer, ArrayList<Integer>> map) {
    	int result = 0;
    	
    	if(path.size() != cnt * 2) {
    		result = Integer.MAX_VALUE;
    		for(int idx = 1; idx <= CARDCNT; ++idx) {
    			if(cards[idx]) {
    				ArrayList<Integer> rc = map.get(idx);
    				ArrayList<Integer> t1Path = (ArrayList<Integer>) path.clone();
    				t1Path.add(rc.get(0));
    				t1Path.add(rc.get(1));
    				t1Path.add(rc.get(2));
    				t1Path.add(rc.get(3));
    				ArrayList<Integer> t2Path = (ArrayList<Integer>) path.clone();
    				t2Path.add(rc.get(2));
    				t2Path.add(rc.get(3));
    				t2Path.add(rc.get(0));
    				t2Path.add(rc.get(1));
    				cards[idx] = false;
    				result = Math.min(result, permu(board, r, c, t1Path, cards, map));
    				result = Math.min(result, permu(board, r, c, t2Path, cards, map));
    				cards[idx] = true;
    			}
    		}
    	}
    	
    	else {
    		int[][] cBoard = new int[SIZE][SIZE];
    		for(int idx = 0; idx < SIZE; ++idx)  cBoard[idx] = board[idx].clone();
    		for(int idx = 0; idx < path.size(); idx += 4) {
    			int move = bfs(cBoard, r, c, path.get(idx), path.get(idx + 1)) + bfs(cBoard, path.get(idx), path.get(idx + 1), path.get(idx + 2), path.get(idx + 3)) + 2;
    			if(result + move == 15) {
    				int casd = 0;
    			}
    			result += move;
    			cBoard[path.get(idx)][path.get(idx + 1)] = 0;
    			cBoard[path.get(idx + 2)][path.get(idx + 3)] = 0;
    		}
    	}
    	
    	if(result == 15) {
    		int a = 0;
    	}
    	return result;
    }
    
    /*public static int permu(int[][] board, int r, int c, ArrayList<Integer> path, boolean[] cards, HashMap<Integer, ArrayList<Integer>> map) {
    	int result = 0;
    	
    	if(path.size() != cnt / 2) {
    		result = Integer.MAX_VALUE;
    		for(int idx = 1; idx <= CARDCNT; ++idx) {
    			if(cards[idx]) {
    				ArrayList<Integer> tPath = (ArrayList<Integer>) path.clone();
    				tPath.add(idx);
    				cards[idx] = false;
    				result = Math.min(result, permu(board, r, c, tPath, cards, map));
    				cards[idx] = true;
    			}
    		}
    	}
    	
    	else {
    		int[][] cBoard = new int[SIZE][SIZE];
    		for(int idx = 0; idx < SIZE; ++idx)  cBoard[idx] = board[idx].clone();
    		for(int idx = 0; idx < path.size(); ++idx) {
    			ArrayList<Integer> rc = map.get(path.get(idx));
    			int move = 0;
    			int first = bfs(cBoard, r, c, rc.get(0), rc.get(1)) + bfs(cBoard, rc.get(0), rc.get(1), rc.get(2), rc.get(3)) + 2;
    			int second = bfs(cBoard, r, c, rc.get(2), rc.get(3)) + bfs(cBoard, rc.get(2), rc.get(3), rc.get(0), rc.get(1)) + 2;
    			if(first < second) {
    				r = rc.get(2);
    				c = rc.get(3);
    				move = first;
    			}
    			else {
    				r = rc.get(0);
    				c = rc.get(1);
    				move = second;
    			}
    			result += move;
    			cBoard[rc.get(0)][rc.get(1)] = 0;
    			cBoard[rc.get(2)][rc.get(3)] = 0;
    		}
    	}
    	
    	return result;
    }*/

	private static int bfs(int[][] board, int sr, int sc, int dr, int dc) {
		boolean[][] visited = new boolean[SIZE][SIZE];
		Queue<Integer> q = new LinkedList<>();
		q.add(sr);
		q.add(sc);
		q.add(0);
		
		while(!q.isEmpty()) {
			int row = q.poll(), col = q.poll(), move = q.poll();
			if(row == dr && col == dc) return move;
			if(!visited[row][col]) {
				visited[row][col] = true;
				for(int idx = 0; idx < dRow.length; ++idx) {
					int nR = row + dRow[idx], nC = col + dCol[idx];
					if(nR < 0 || nC < 0 || nR == SIZE || nC == SIZE) continue;
					
					if(!visited[nR][nC]) {
						q.add(nR);
						q.add(nC);
						q.add(move + 1);
					}
					
					while(!(nR + dRow[idx] < 0 || nC + dCol[idx] < 0 || nR + dRow[idx] == SIZE || nC + dCol[idx] == SIZE) && board[nR][nC] == 0) {
						nR += dRow[idx];
						nC += dCol[idx];
					}
					if(nR < 0) ++nR;
					if(nR == SIZE) --nR;
					if(nC < 0) ++nC;
					if(nC == SIZE) --nC;
					if(!visited[nR][nC]) {
						q.add(nR);
						q.add(nC);
						q.add(move + 1);
					}
				}
			}
		}
		
		return -1;
	}

}
