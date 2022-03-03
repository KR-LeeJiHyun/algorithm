import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Alphabet {
	
	static char [][] map;
	static boolean [] visited;
	static int [] d_row = {-1, 1, 0, 0}, d_col = {0, 0, -1, 1};
	static int nRow, nCol;
	
	public static int dfs(int row, int col, int count) {
		visited[map[row][col] - 'A'] = true;
		++count;
		int max = count;
		for(int idx = 0; idx <d_row.length; ++idx) {
			int next_row = row + d_row[idx], next_col = col + d_col[idx];
			
			if(next_row < 0 || next_col < 0 || next_row >= nRow || next_col >= nCol) continue;
			else if(!visited[map[next_row][next_col] - 'A']) {
				int tmp = dfs(next_row, next_col, count);
				if(max < tmp) max = tmp;
			}
		}
		
		visited[map[row][col] - 'A'] = false;
		return max;
	}
	
	public static int solution() {
		int answer = 0;
		
		answer = dfs(0, 0, 0);
		
		return answer;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		nRow = Integer.parseInt(st.nextToken());
		nCol = Integer.parseInt(st.nextToken());
		
		map = new char[nRow][nCol];
		visited = new boolean[26];
		
		for(int row = 0; row < nRow; ++row) {
			String input = br.readLine();
			for(int col = 0; col < nCol; ++col) {
				map[row][col] = input.charAt(col);
			}
		}
		
		bw.write(Integer.toString(solution()));
		
		br.close();
        bw.flush();
        bw.close();
	}

}
