import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek피리부는사나이 {
	
	static int N;
	static int M;
	static int[] dRow = {-1, 1, 0 , 0};
	static int[] dCol = {0 , 0, -1, 1};
	static int[][] map;
	static int[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		N = Integer.parseInt(input.nextToken());
		M = Integer.parseInt(input.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		
		for(int row = 0; row < N; ++row) {
			String rows = br.readLine();
			for(int col = 0; col < M; ++col) {
				char c = rows.charAt(col);
				if(c == 'U') {
					map[row][col] = 0;
				}
				else if(c == 'D') {
					map[row][col] = 1;
				}
				else if(c == 'L') {
					map[row][col] = 2;
				}
				else {
					map[row][col] = 3;
				}
			}
		}
		
		int answer = 0;
		int cycle = 0;
		for(int row = 0; row < N; ++row) {
			for(int col = 0; col < M; ++col) {
				if(visited[row][col] == 0) {
					if(dfs(row, col, ++cycle)) {
						++answer;
					}
				}
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

	private static boolean dfs(int row, int col, int cycle) {
		visited[row][col] = cycle;
		int nextRow = row + dRow[map[row][col]];
		int nextCol = col + dCol[map[row][col]];
		if(visited[nextRow][nextCol] == 0) {
			return dfs(nextRow, nextCol, cycle);
		}
		else if(visited[nextRow][nextCol] != cycle) {
			return false;
		}
		return true;
	}

}
