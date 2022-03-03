import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Baek_Cheese {

	static int [][] map;
	static boolean [][] visited;
	static int [] d_row = {-1, 1, 0, 0}, d_col = {0, 0, -1, 1};
	static int M, N, cnt;
	static final int cheese = 1, blank = 0, air = -3;
	
	public static void dfs(int row, int col) {
		visited[row][col] = true;
		map[row][col] = air;
		
		for(int idx = 0; idx < d_row.length; ++idx) {
			int nextRow = row + d_row[idx], nextCol = col + d_col[idx];
			if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) continue;
			if(!visited[nextRow][nextCol] && map[nextRow][nextCol] != cheese) dfs(nextRow,nextCol);
		}
	}
	
	public static int solution() {
		int answer = 0;
		
		Queue<Integer> airRows = new LinkedList<Integer>(), airCols = new LinkedList<Integer>();
		airRows.offer(0);
		airCols.offer(0);
		
		while(cnt > 0) {
			++answer;
			while(!airRows.isEmpty()) {
				int airRow = airRows.poll(), airCol = airCols.poll();
				dfs(airRow, airCol);
			}
			
			for(int row = 1; row < N - 1; ++row) {
				for(int col = 1; col < M - 1; ++col) {
					if(map[row][col] == cheese) {
						int airCnt = 0;
						for(int idx = 0; idx < d_row.length; ++idx) {
							if(airCnt > 1) break;
							int nextRow = row + d_row[idx], nextCol = col + d_col[idx];
							if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) continue;
							if(map[nextRow][nextCol] == air) ++airCnt;
						}
						if(airCnt > 1) {
							--cnt;
							airRows.offer(row);
							airCols.offer(col);
						}
					}
				}
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
		visited = new boolean[N][M];
		
		
		for(int row = 0; row < N; ++row) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < M; ++col) {
				map[row][col] = Integer.parseInt(st.nextToken());
				if(map[row][col] == cheese) ++cnt;
			}
		}
		
		bw.write(Integer.toString(solution()) + "\n");
		
		br.close();
        bw.flush();
        bw.close();
	}

}
