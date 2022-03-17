import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Move {

	public static void main(String[] args) throws IOException {
		int[] dRow = {1, 0, 1}, dCol = {0, 1, 1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = 0, M = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M], dp = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		for(int row = 0; row < N; ++row) {
			StringTokenizer stR = new StringTokenizer(br.readLine());
			for(int col = 0; col < M; ++col) {
				map[row][col] = Integer.parseInt(stR.nextToken());
			}
		}
		dp[0][0] = map[0][0];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		q.add(0);
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int row = q.poll(), col = q.poll();
	
			for(int idx = 0; idx < dRow.length; ++idx) {
				int nextR = row + dRow[idx], nextC = col + dCol[idx];
				if(nextR < 0 || nextC < 0 || nextR == N || nextC == M) continue;
				dp[nextR][nextC] = Math.max(dp[nextR][nextC], dp[row][col] + map[nextR][nextC]);
				if(!visited[nextR][nextC]) {
					visited[nextR][nextC] = true;
					q.add(nextR);
					q.add(nextC);
				}
			}
		}
		
		bw.write(dp[N - 1][M - 1] + "\n");
		br.close();
        bw.flush();
        bw.close();
	}

}
