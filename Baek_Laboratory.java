import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_Laboratory {

	static class Pair {
		int row;
		int col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st_NM = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st_NM.nextToken()), M = Integer.parseInt(st_NM.nextToken()); 
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		int blank = N * M, answer = 0;
		ArrayList<Pair> list = new ArrayList<>();
		Queue<Pair> virus = new LinkedList<>();

		for(int row = 0; row < N; ++row) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < M; ++col) {
				int loc = Integer.parseInt(st.nextToken());
				map[row][col] = loc;
				if(loc == 0) list.add(new Pair(row, col));
				else {
					--blank;
					if(loc == 2) virus.add(new Pair(row, col));
				}
			}
		}

		blank -= 3;
		for(int f_idx = 0; f_idx < list.size() - 2; ++f_idx) {
			Pair f = list.get(f_idx);
			map[f.row][f.col] = 1;
			for(int s_idx = f_idx + 1; s_idx < list.size() - 1; ++s_idx) {
				Pair s = list.get(s_idx);
				map[s.row][s.col] = 1;
				for(int t_idx = s_idx + 1; t_idx < list.size(); ++t_idx) {
					Pair t = list.get(t_idx);
					map[t.row][t.col] = 1;
					answer = Math.max(answer, bfs(new LinkedList(virus), map, blank, N, M));
					map[t.row][t.col] = 0;
				}
				map[s.row][s.col] = 0;
			}
			map[f.row][f.col] = 0;
		}

		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();

	}

	private static int bfs(Queue<Pair> virus, int[][] map, int blank, int N, int M) {

		int[] d_row = {1, -1, 0, 0}, d_col = {0, 0, 1, -1};
		boolean[][] visited = new boolean[N][M];
		while(!virus.isEmpty()) {
			Pair current = virus.poll();
			visited[current.row][current.col] = true;
			for(int idx = 0; idx < d_row.length; ++idx) {
				int n_row = current.row + d_row[idx], n_col = current.col + d_col[idx];
				if(n_row < 0 || n_row == N || n_col < 0 || n_col == M || visited[n_row][n_col] || map[n_row][n_col] != 0) continue;
				else {
					visited[n_row][n_col] = true;
					virus.add(new Pair(n_row, n_col));
					--blank;
				}
			}
		}

		return blank;

	}

}
