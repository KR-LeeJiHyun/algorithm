import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek점수따먹기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken());
		int M = Integer.parseInt(stNM.nextToken());
		
		int[][] map = new int[N + 1][M + 1];
		int answer = Integer.MIN_VALUE;
		
		for(int row = 1; row <= N; ++row) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 1; col <= M; ++col) {
				map[row][col] = Integer.parseInt(st.nextToken()) + map[row - 1][col] + map[row][col - 1] - map[row - 1][col - 1];
				answer = Math.max(answer, map[row][col]);
			}
		}
		
		
		
		for(int row = 1; row <= N; ++row) {
			for(int col = 1; col <= M; ++col) {
				for(int srow = 0; srow < row; ++srow) {
					for(int scol = 0; scol < col; ++scol) {
						answer = Math.max(answer, map[row][col] + map[srow][scol] - map[row][scol] - map[srow][col]);
					}
				}
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
		
	}
}
