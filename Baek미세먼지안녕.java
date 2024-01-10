import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek미세먼지안녕 {

	static final int DIV = 5;
	static final int DLEN = 4;
	static final int[] dRow = {-1, 1, 0, 0};
	static final int[] dCol = {0, 0, -1, 1};
	static int[][] map;
	static int R;
	static int C;
	static int T;

	static class Pos {
		int row;
		int col;
		int v;

		public Pos(int row, int col, int v) {
			this.row = row;
			this.col = col;
			this.v = v;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer input = new StringTokenizer(br.readLine());

		R = Integer.parseInt(input.nextToken());
		C = Integer.parseInt(input.nextToken());
		T = Integer.parseInt(input.nextToken());
		map = new int[R][C];
		int up = -1;
		int down = -1;

		Queue<Pos> q = new LinkedList<>();

		for(int row = 0; row < R; ++row) {
			input = new StringTokenizer(br.readLine());
			for(int col = 0; col < C; ++col) {
				map[row][col] = Integer.parseInt(input.nextToken());
				if(map[row][col] == -1) {
					if(up == -1)up = row;
					else down = row;
				}
				else if(map[row][col] >= DIV) {
					q.add(new Pos(row, col, map[row][col]));
				}
			}
		}

		while(T > 0) {
			--T;
			while(!q.isEmpty()) {
				Pos current = q.poll();
				int v = current.v / 5;
				for(int idx = 0; idx < DLEN; ++idx) {
					int nr = current.row + dRow[idx];
					int nc = current.col + dCol[idx];

					if(nr < 0 || nr == R || nc < 0 || nc == C || map[nr][nc] == -1) continue;
					map[current.row][current.col] -= v;
					map[nr][nc] += v;
				}
			}

			moveReverse(up, 0);
			move(down, 0);
			
			for(int row = 0; row < R; ++row) {
				for(int col = 0; col < C; ++col) {
					if(map[row][col] >= DIV) {
						q.add(new Pos(row, col, map[row][col]));
					}
				}
			}
		}
		
		int answer = 2;
		for(int row = 0; row < R; ++row) {
			for(int col = 0; col < C; ++col) {
				answer += map[row][col];
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

	private static void moveReverse(int row, int col) {
		int cr = row;
		int cc = col + 1;
		int cv = map[cr][cc];
		map[cr][cc] = 0;

		//오른쪽 바람
		while(cc != C - 1) {
			int nv = map[cr][cc + 1];
			map[cr][++cc] = cv;
			cv = nv;
		}
		//위쪽 바람
		while(cr != 0) {
			int nv = map[cr - 1][cc];
			map[--cr][cc] = cv;
			cv = nv;
		}
		//왼쪽 바람
		while(cc != 0) {
			int nv = map[cr][cc - 1];
			map[cr][--cc] = cv;
			cv = nv;
		}
		//아래쪽 바람
		while(cr != row - 1) {
			int nv = map[cr + 1][cc];
			map[++cr][cc] = cv;
			cv = nv;
		}
	}

	private static void move(int row, int col) {
		int cr = row;
		int cc = col + 1;
		int cv = map[cr][cc];
		map[cr][cc] = 0;

		//오른쪽 바람
		while(cc != C - 1) {
			int nv = map[cr][cc + 1];
			map[cr][++cc] = cv;
			cv = nv;
		}
		//아래쪽 바람
		while(cr != R - 1) {
			int nv = map[cr + 1][cc];
			map[++cr][cc] = cv;
			cv = nv;
		}
		//왼쪽 바람
		while(cc != 0) {
			int nv = map[cr][cc - 1];
			map[cr][--cc] = cv;
			cv = nv;
		}
		//위쪽 바람
		while(cr != row + 1) {
			int nv = map[cr - 1][cc];
			map[--cr][cc] = cv;
			cv = nv;
		}

	}
}
