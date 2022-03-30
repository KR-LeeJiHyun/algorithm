import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_SectionSum5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = 0, M = 0;
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNM.nextToken());
		M = Integer.parseInt(stNM.nextToken());
		int[][] map = new int[N + 1][N + 1], dp = new int[N + 1][N + 1];
		
		for(int row = 1; row < N + 1; ++row) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 1; col < N + 1; ++col) {
				map[row][col] = Integer.parseInt(st.nextToken());
				dp[row][col] = map[row][col];
			}
		}
		
		for(int row = 1; row < N + 1; ++row) {
			for(int col = 1; col < N + 1; ++col) {
				dp[row][col] += dp[row - 1][col];
			}
		}
		
		for(int row = 1; row < N + 1; ++row) {
			for(int col = 1; col < N + 1; ++col) {
				dp[row][col] += dp[row][col - 1];
			}
		}
		
		for(int idx = 0; idx < M; ++idx) {
			int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
			
			StringTokenizer stXY = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(stXY.nextToken());
			y1 = Integer.parseInt(stXY.nextToken());
			x2 = Integer.parseInt(stXY.nextToken());
			y2 = Integer.parseInt(stXY.nextToken());

			bw.write(dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1] + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
