import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_GridPanda {
	
	static int [][] map, visited_map;
	static boolean [][] visited;
	static int [] d_row = {-1, 1, 0, 0}, d_col = {0, 0, -1, 1};
	static int N;
	
	public static int dfs(int row, int col) {
		visited[row][col] = true;
		int cnt = 1, tmp = 1;
		
		for(int idx = 0; idx < d_row.length; ++idx) {
			int next_row = row + d_row[idx], next_col = col + d_col[idx];
			if(next_row < 0 || next_col < 0 || next_row >= N || next_col >= N) continue;
			else if(map[row][col] < map[next_row][next_col]) {
				if(!visited[next_row][next_col]) cnt = Math.max(cnt, dfs(next_row, next_col) + tmp); 
				else cnt = Math.max(cnt, visited_map[next_row][next_col] + tmp);
			}
		}
		
		visited_map[row][col] = cnt;
		return cnt;
	}
	
	public static int solution() {
		int answer = 0;
		
		for(int row = 0; row < N; ++row) {
			for(int col = 0; col < N; ++col) {
				if(!visited[row][col]) answer = Math.max(answer, dfs(row, col));
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited_map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int row = 0; row < N; ++row) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; ++col) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		bw.write(Integer.toString(solution()) + "\n");
		
		br.close();
        bw.flush();
        bw.close();
	}

}
