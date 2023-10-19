import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek벽부수고이동하기4 {
	
	static int N;
	static int M;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		N = Integer.parseInt(input.nextToken());
		M = Integer.parseInt(input.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int row = 0; row < N; ++row) {
			String str = br.readLine();
			for(int col = 0; col < M; ++col) {
				map[row][col] = str.charAt(col) - '0';
			}
		}
		
		Queue<Integer> q1 = new LinkedList();
		Queue<Integer> q2 = new LinkedList();
		for(int row = 0; row < N; ++row) {
			for(int col = 0; col < M; ++col) {
				if(map[row][col] == 0 && !visited[row][col]) {
					int cnt = 0;
					visited[row][col] = true;
					q1.add(row);
					q1.add(col);
					
					while(!q1.isEmpty()) {
						int cr = q1.poll();
						int cc = q1.poll();
						++cnt;
						
						for(int idx = 0; idx < 4; ++idx) {
							int nr = cr + dRow[idx];
							int nc = cc + dCol[idx];
							
							if(nr < 0 || nr == N || nc < 0 || nc == M || visited[nr][nc]) continue;
							else if(map[nr][nc] == 0) {
								visited[nr][nc] = true;
								q1.add(nr);
								q1.add(nc);
							}
							else {
								visited[nr][nc] = true;
								q2.add(nr);
								q2.add(nc);
							}
						}
					}
					
					while(!q2.isEmpty()) {
						int cr = q2.poll();
						int cc = q2.poll();
						
						map[cr][cc] += cnt;
						visited[cr][cc] = false;
					}
				}
			}
		}
		
		for(int row = 0; row < N; ++row) {
			for(int col = 0; col < M; ++col) {
				bw.write(String.valueOf(map[row][col] % 10));
			}
			bw.write('\n');
		}
		
		br.close();
		bw.close();
	}


}
