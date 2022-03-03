import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_RedGreenColorWeakness {
	static char [][] map;
	static boolean [][] visited;
	static int [] d_row = {-1, 1, 0, 0}, d_col = {0, 0, -1, 1};
	static int N = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = "";
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];	
		
		for(int h = 0; h < N; ++h) {
			input = br.readLine();
			for(int w = 0; w < N; ++w) {
				map[h][w] = input.charAt(w);
			}
		}
		
		int answer[] = solution();
		
		bw.write(Integer.toString(answer[0]) + " ");
		bw.write(Integer.toString(answer[1]));
		
		br.close();
        bw.flush();
        bw.close();
	}
	
	public static int[] solution() {
		int[] answer = {0, 0};
		
		visited = new boolean[N][N];
		for(int h = 0; h < N; ++h) {
			for(int w = 0; w < N; ++w) {
				if(!visited[h][w]) {
					dfs(false, h, w);
					++answer[0];
				}
			}
		}
		
		visited = new boolean[N][N];
		for(int h = 0; h < N; ++h) {
			for(int w = 0; w < N; ++w) {
				if(!visited[h][w]) {
					dfs(true, h, w);
					++answer[1];
				}
			}
		}
		
		return answer;
	}
	
	public static void dfs(boolean mod, int row, int col) {
		visited[row][col] = true;
		
		for(int idx = 0; idx <d_row.length; ++idx) {
			int next_row = row + d_row[idx], next_col = col + d_col[idx];
			
			if(next_row < 0 || next_col < 0 || next_row >= N || next_col >= N) continue;
			else if(!mod) {
				if(map[next_row][next_col] == map[row][col] && !visited[next_row][next_col]) dfs(mod, next_row, next_col);	
			}
			else {
				if(map[next_row][next_col] == map[row][col] && !visited[next_row][next_col]) dfs(mod, next_row, next_col);
				else if((map[row][col] == 'R' || map[row][col] == 'G') && (map[next_row][next_col] == 'R' || map[next_row][next_col] == 'G') && !visited[next_row][next_col]) dfs(mod, next_row, next_col);	
			}
		}
	}

}
