import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Painting {

	static int [][] map;
	static boolean [][] visited;
	static int [] d_row = {-1, 1, 0, 0}, d_col = {0, 0, -1, 1};
	static int M, N;
	static final int painting = 1;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st_MN = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st_MN.nextToken());
		M = Integer.parseInt(st_MN.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		
		for(int row = 0; row < N; ++row) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < M; ++col) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] answer = solution();
		bw.write(Integer.toString(answer[0]) + "\n");
		bw.write(Integer.toString(answer[1]) + "\n");
		
		br.close();
        bw.flush();
        bw.close();

	}
	
	public static int[] solution() {
		int[] answer = {0, 0};
		
		for(int row = 0; row < N; ++row) {
			for(int col = 0; col < M; ++col) {
				if(!visited[row][col] && map[row][col] == painting) { 
					int tmpMax = dfs(row, col);
					++answer[0];
					answer[1] = Math.max(answer[1], tmpMax);
				}
			}
		}
		
		return answer;
	}
	
	public static int dfs(int row, int col) {
		visited[row][col] = true;
		int cnt = 1;
		
		for(int idx = 0; idx < d_row.length; ++idx) {
			int nextRow = row + d_row[idx], nextCol = col + d_col[idx];
			if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) continue;
			else if(!visited[nextRow][nextCol] && map[nextRow][nextCol] == painting) cnt += dfs(nextRow, nextCol);
		}
		
		return cnt;
	}

}
