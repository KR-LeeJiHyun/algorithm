import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Downhill {
	static int [][] map, visited_map;
	static boolean [][] visited;
	static int [] d_row = {-1, 1, 0, 0}, d_col = {0, 0, -1, 1};
	static int M, N;
	
	public static int dfs(int c_row, int c_col) {
		visited[c_row][c_col] = true;
		
		if(c_row + 1 == M && c_col + 1 == N) {
			++visited_map[c_row][c_col];
			return 1;
		}
		
		int count = 0;
		
		for(int idx = 0; idx <d_row.length; ++idx) {
			int next_row = c_row + d_row[idx], next_col = c_col + d_col[idx];
			
			if(next_row < 0 || next_col < 0 || next_row >= M || next_col >= N) continue;
			else if(map[next_row][next_col] < map[c_row][c_col] && !visited[next_row][next_col]) count += dfs(next_row, next_col);
			else if(map[next_row][next_col] < map[c_row][c_col] && visited[next_row][next_col]) count += visited_map[next_row][next_col];
		}
		
		visited_map[c_row][c_col] = count;
		return count;
	}
	
	public static int solution() {
		int answer = 0;
		
		answer = dfs(0, 0);
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st_MN = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st_MN.nextToken());
		N = Integer.parseInt(st_MN.nextToken());
		
		map = new int[M][N];
		visited_map = new int[M][N];
		visited = new boolean[M][N];
		
		
		for(int row = 0; row < M; ++row) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; ++col) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		bw.write(Integer.toString(solution()) + "\n");
		
		for(int row = 0; row < M; ++row) {	
			for(int col = 0; col < N; ++col) {
				bw.write(visited_map[row][col] + " ");
			}
			bw.write("\n");
		}
		
		br.close();
        bw.flush();
        bw.close();
	}

}
