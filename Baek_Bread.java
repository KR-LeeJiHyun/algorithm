import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Bread {
	
	static int R, C;
	static int[] dRow = {-1, 0, 1}, dCol = {1, 1, 1};
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stRC = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stRC.nextToken());
		C = Integer.parseInt(stRC.nextToken());
		map = new boolean[R][C];
		
		for(int row = 0; row < R; ++row) {
			String rows = br.readLine();
			for(int col = 0; col < C; ++col) {
				if(rows.charAt(col) == 'x') map[row][col] = true;
			}
		}
		
		int answer = 0;
		for(int row = 0; row < R; ++row) answer += dfs(row, 0);
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
		
	}

	private static int dfs(int cRow, int cCol) {
		map[cRow][cCol] = true;
		if(cCol == C - 1) return 1;
		
		for(int idx = 0; idx < dRow.length; ++idx) {
			int nextRow = cRow + dRow[idx], nextCol = cCol + dCol[idx];
			if(nextRow < 0 || nextRow == R || map[nextRow][nextCol]) continue;
			int result = dfs(nextRow, nextCol);
			if(result == 1) return result;
		}
		
		return 0;
	}

}
