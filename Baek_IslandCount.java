import java.util.Scanner;

public class  Baek_IslandCount{
	
	static boolean[][] visited;
	static int[][] map;
	
	static void find(int row, int col) {
		visited[row][col] = true;
		//상하좌우 왼위대 오위대 왼아대 오아대
		int [] d_row = {-1, 1, 0, 0, -1, -1, 1, 1};
		int [] d_col = {0, 0, -1, 1, -1, 1, -1, 1};
		
		for(int idx = 0; idx < d_row.length; ++idx) {
			int next_row = row + d_row[idx];
			int next_col = col + d_col[idx];
			
			if(next_row < 0 || next_row == map.length || next_col < 0 || next_col == map[0].length) continue;
			else if(map[next_row][next_col] == 1 && !visited[next_row][next_col]) find(next_row, next_col);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row, col;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			col = sc.nextInt();
			row = sc.nextInt();
			
			if(row == 0 && col == 0) break;
			
			map = new int[row][col];
			visited = new boolean[row][col];

			for(int row_idx = 0; row_idx < row; ++row_idx) {
				for(int col_idx = 0; col_idx < col; ++col_idx) {
					map[row_idx][col_idx] = sc.nextInt();
				}
			}
			
			int answer = 0;
			
			for(int row_idx = 0; row_idx < row; ++row_idx) {
				for(int col_idx = 0; col_idx < col; ++col_idx) {
					if(map[row_idx][col_idx] == 1 && !visited[row_idx][col_idx]) {
						find(row_idx, col_idx);
						++answer;
					}
				}
			}
			
			System.out.println(answer);
		}
		sc.close();
	}
	
}
