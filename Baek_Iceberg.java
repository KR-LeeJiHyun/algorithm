import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Iceberg {

	static int [][] map, visited_map;
	static boolean [][] visited;
	static int [] d_row = {-1, 1, 0, 0}, d_col = {0, 0, -1, 1};
	static int M, N;
	
	public static boolean after_year() {
		boolean check = false;
		
		int[][] tmp_map = new int[N][M];
		for(int idx = 0; idx < N; ++idx) tmp_map[idx] = map[idx].clone();
		
		for(int row = 0; row < N; ++row) {
			for(int col = 0; col < M; ++col) {
				if(tmp_map[row][col] != 0) {
					for(int idx = 0; idx < d_row.length; ++idx) {
						int next_row = row + d_row[idx], next_col = col + d_col[idx];
						
						if(next_row < 0 || next_row >= N || next_col < 0 || next_col >= M) continue;
						if(tmp_map[next_row][next_col] == 0 && map[row][col] != 0) --map[row][col];
					}
					if(tmp_map[row][col] != 0) check = true;
				}
			}
		}
		
		return check;
	}
	
	public static void find_island(int row, int col) {
		visited[row][col] = true;
		for(int idx = 0; idx < d_row.length; ++idx) {
			int next_row = row + d_row[idx], next_col = col + d_col[idx];
			if(next_row < 0 || next_row >= N || next_col < 0 || next_col >= M) continue;
			else if(!visited[next_row][next_col] && map[next_row][next_col] != 0) find_island(next_row, next_col);
		}
	}
	
	public static void print_map() {
		System.out.print("\n");
		for(int row = 0; row < N; ++row) {
			for(int col = 0; col < M; ++col) {
				System.out.print(map[row][col] + " ");
			}
			System.out.print("\n");
		}
	}
	
	public static int solution() {
		int answer = 0;
		
		while(true) {
			print_map();
			visited = new boolean[N][M];
			int count = 0;
			for(int row = 0; row < N; ++row) {
				for(int col = 0; col < M; ++col) {
					if(map[row][col] != 0 && !visited[row][col]) {
						find_island(row, col);
						++count;
						if(count > 1) return answer;
					}
				}
			}
			
			++answer;
			if(!after_year()) {
				answer = 0;
				break;
			} 
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st_MN = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st_MN.nextToken());
		M = Integer.parseInt(st_MN.nextToken());
		
		map = new int[N][M];
		
		
		for(int row = 0; row < N; ++row) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < M; ++col) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		bw.write(Integer.toString(solution()) + "\n");
		
		br.close();
        bw.flush();
        bw.close();
	}

}
