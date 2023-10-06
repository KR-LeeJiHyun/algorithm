import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek불끄기 {
	
	static final int N = 10;
	static int answer = 1000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[][] map = new boolean[N][N];
		
		for(int row = 0; row < N; ++row) {
			String input = br.readLine();
			for(int col = 0; col < N; ++col) {
				if(input.charAt(col) == 'O') {
					map[row][col] = true;
				}
			}
		}
		
		dfs(map, 0, 0);
		
		if(answer == 1000) {
			answer = -1;
		}
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

	private static void dfs(boolean[][] map, int depth, int current) {
		if(current == 10) {
			int temp = calc(map);
			if(temp != 1000) answer = Math.min(answer ,temp + depth);
			return;
		}
		
		dfs(map, depth, current + 1);
		
		int left = current - 1;
		int right = current + 1;
		
		if(left > -1) {
			map[0][left] = !map[0][left];
		}
		if(right < N) {
			map[0][right] = !map[0][right];
		}
		map[1][current] = !map[1][current];
		map[0][current] = !map[0][current];
		
		dfs(map, depth + 1, current + 1);
		
		if(left > -1) {
			map[0][left] = !map[0][left];
		}
		if(right < N) {
			map[0][right] = !map[0][right];
		}
		map[1][current] = !map[1][current];
		map[0][current] = !map[0][current];
	}

	private static int calc(boolean[][] pmap) {
		boolean[][] map = new boolean[N][N];
		for(int row = 0; row < N; ++row) {
			map[row] = pmap[row].clone();
		}
		
		int cnt = 0;
		for(int row = 1; row < N; ++row) {
			for(int col = 0; col < N; ++col) {
				if(map[row - 1][col]) {
					++cnt;
					int left = col - 1;
					int right = col + 1;
					int down = row + 1;
					if(left > -1) {
						map[row][left] = !map[row][left];
					}
					if(right < N) {
						map[row][right] = !map[row][right];
					}
					if(down < N) {
						map[down][col] = !map[down][col];
					}
					map[row - 1][col] = !map[row - 1][col];
					map[row][col] = !map[row][col];
				}
			}
		}
		
		if(isPossible(map)) {
			return cnt;
		}
		
		return 1000;
	}

	private static boolean isPossible(boolean[][] map) {
		for(int row = 0; row < N; ++row) {
			for(int col = 0; col < N; ++col) {
				if(map[row][col]) return false;
			}
		}
		return true;
	}

}
