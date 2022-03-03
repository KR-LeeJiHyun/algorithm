import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_SafeZone {
	
	static int [][] map;
	static boolean [][] visited;
	static int [] d_row = {-1, 1, 0, 0}, d_col = {0, 0, -1, 1};
	static int maxh = 101;
	static int N;
	
	public static void dfs(int row, int col, int h) {
		visited[row][col] = true;
		
		for(int idx = 0; idx <d_row.length; ++idx) {
			int next_row = row + d_row[idx], next_col = col + d_col[idx];
			
			if(next_row < 0 || next_col < 0 || next_row >= N || next_col >= N) continue;
			else if(map[next_row][next_col] > h && !visited[next_row][next_col]) dfs(next_row, next_col, h);
		}
	}
	
	public static int solution(int N, int h) {
		int answer = 0;
		visited = new boolean [N][N];
		
		for(int row = 0; row < N; ++row) {
			for(int col = 0; col < N; ++col) {
				if(map[row][col] > h && !visited[row][col]) {
					++answer;
					dfs(row, col, h);
				}
			}
		}
		
		return answer;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int max = 0;
		String sN = br.readLine();
		
		N = Integer.parseInt(sN);
		
		map = new int[N][N];
		
		
		for(int row = 0; row < N; ++row) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; ++col) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int h = 0; h < maxh; ++h) {
			max = Math.max(solution(N, h), max);
		}
		
		bw.write(Integer.toString(max));
		
		br.close();
        bw.flush();
        bw.close();
	}

}
