import java.util.Queue;
import java.util.LinkedList;

public class Pro_Puzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] game_board = {{0,0,0},{1,1,0},{1,1,1}};
		int[][] table = {{1,1,1},{1,0,0},{0,0,0}};
		solution(game_board, table);
	}
	
	static int[] dRow = {1, -1, 0, 0};
	static int[] dCol = {0, 0, 1, -1};
	
    public static int solution(int[][] game_board, int[][] table) {
    	int answer = 0;
    	for(int row = 0; row < game_board.length; ++row) {
        	for(int col = 0; col < game_board[row].length; ++col) {
        		if(game_board[row][col] == 0) ++answer;
        	}
        }
    	
        for(int row = 0; row < game_board.length; ++row) {
        	for(int col = 0; col < game_board[row].length; ++col) {
        		if(game_board[row][col] == 0) {
        			int cnt = 0;
        			while(cnt <= 3) {
        				System.out.println("table");
        				print(table);
 
        				for(int tR = 0; tR < table.length; ++tR) {
        					for(int tC = 0; tC < table.length; ++tC) {
        						if(table[tR][tC] == 1 && game_board[row][col] == 0) {
        							System.out.println("table");
        	        				print(table);
        							piece(row, col, tR, tC, game_board, table);
        						}
        					}
        				}
        				rotation(table);
        				++cnt;
        			}
        		}
        	}
        }
        
    	for(int row = 0; row < game_board.length; ++row) {
        	for(int col = 0; col < game_board[row].length; ++col) {
        		if(game_board[row][col] == 0) --answer;
        	}
        }
        
        return answer;
    }

	private static void print(int[][] table) {
		//System.out.println("");
		for(int row = 0; row < table.length; ++row) {
			for(int col = 0; col < table.length; ++col) {
				System.out.print(table[row][col] + " ");
			}
			System.out.println("");
		}
		
	}

	private static void rotation(int[][] table) {
		int[][] result = new int[table.length][table.length];
		for(int row = 0; row < table.length; ++row) result[row] = table[row].clone();
		for(int row = 0; row < table.length; ++row) {
        	for(int col = 0; col < table[row].length; ++col) {
        		table[col][table.length - row - 1] = result[row][col];
        	}
        }
	}

	private static void piece(int row, int col, int tR, int tC, int[][] game_board, int[][] table) {
		Queue<Integer> boardQ = new LinkedList<Integer>(), tableQ = new LinkedList<Integer>(), boardP = new LinkedList<Integer>(), tableP = new LinkedList<Integer>();
		boardQ.add(row);
		boardQ.add(col);
		tableQ.add(tR);
		tableQ.add(tC);
		
		boolean check = false;
		
		while(!boardQ.isEmpty() && !tableQ.isEmpty()) {
			int bR = boardQ.poll(), bC = boardQ.poll(), taR = tableQ.poll(), taC = tableQ.poll();
			if(bR - row != taR - tR || bC - col != taC - tC) {
				check = true;
				break;
			}
			game_board[bR][bC] = 1;
			table[taR][taC] = 0;
			boardP.add(bR);
			boardP.add(bC);
			tableP.add(taR);
			tableP.add(taC);
			
			for(int idx = 0; idx < dRow.length; ++idx) {
				int nBR = bR + dRow[idx], nBC = bC + dCol[idx], nTaR = taR + dRow[idx], nTac = taC + dCol[idx];
				
				if(!(nBR < 0 || nBC < 0 || nBR == game_board.length || nBC == game_board.length) && game_board[nBR][nBC] == 0) {
					boardQ.add(nBR);
					boardQ.add(nBC);
				}
				if(!(nTaR < 0 || nTac < 0 || nTaR == table.length || nTac == table.length) && table[nTaR][nTac] == 1) {
					tableQ.add(nTaR);
					tableQ.add(nTac);
				}
				
				if(tableQ.size() != boardQ.size()) {
					check = true;
					break;
				}
			}
			
			
		}
		
		if(check){
			while(!boardP.isEmpty()) {
				int bR = boardP.poll(), bC = boardP.poll(), taR = tableP.poll(), taC = tableP.poll();
				game_board[bR][bC] = 0;
				table[taR][taC] = 1;
			}
		}
	}

}
