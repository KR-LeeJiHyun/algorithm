import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek아기상어 {
	
	static int N;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	static int[][] map;
	
	static class Shark {
		int row;
		int col;
		int cost;
		
		public Shark(int row, int col, int cost) {
			this.row = row;
			this.col = col;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int cR = 0;
		int cC = 0;
		
		for(int row = 0; row < N; ++row) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; ++col) {
				map[row][col] = Integer.parseInt(input.nextToken());
				if(map[row][col] == 9) {
					cR = row;
					cC = col;
				}
			}
		}
		
		bw.write(String.valueOf(bfs(cR, cC, 2, 0, 0)));
		br.close();
		bw.close();
	}

	private static int bfs(int cR, int cC, int size, int eat, int result) {
		Queue<Shark> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		q.add(new Shark(cR, cC, 0));
		map[cR][cC] = 0;
		visited[cR][cC] = true;
		int fCost = Integer.MAX_VALUE;
		int fRow = 0;
		int fCol = 0;
		while(!q.isEmpty()) {
			Shark current = q.poll();
			for(int idx = 0; idx < 4; ++idx) {
				int nr = current.row + dr[idx];
				int nc = current.col + dc[idx];
				int cost = current.cost + 1;
				if(nr < 0 || nr == N || nc < 0 || nc == N || visited[nr][nc] || map[nr][nc] > size) continue;
				else if(map[nr][nc] != 0 && map[nr][nc] < size && cost <= fCost) {
					if(fCost != cost) {
						fCost = cost;
						fRow = nr;
						fCol = nc;
					}
					else {
						if(nr < fRow || (nr == fRow && nc < fCol)) {
							fCost = cost;
							fRow = nr;
							fCol = nc;
						}
					}
				}
				else {
					visited[nr][nc] = true;
					q.add(new Shark(nr, nc, cost));
				}
			}
		}
		
		if(fCost != Integer.MAX_VALUE) {
			if(eat + 1 == size) {
				++size;
				eat = -1;
			}
			result = bfs(fRow, fCol, size, eat + 1, fCost + result);
		}
		
		return result;
	}

}
