import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek직사각형으로나누기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken());
		int M = Integer.parseInt(stNM.nextToken());

		long[][] preSum = new long[N + 1][M + 1];

		for(int row = 1; row <= N; ++row) {
			String input = br.readLine();
			for(int col = 1; col <= M; ++col) {
				preSum[row][col] = Character.getNumericValue(input.charAt(col - 1)) + preSum[row - 1][col] + preSum[row][col - 1] - preSum[row - 1][col - 1];
			}
		}

		long answer = 0;
		for(int pos1 = 1; pos1 < M - 1; ++pos1) {
			for(int pos2 = pos1 + 1; pos2 < M; ++pos2) {
				answer = Math.max(answer, preSum[N][pos1] * (preSum[N][pos2] - preSum[N][pos1]) * (preSum[N][M] - preSum[N][pos2]));
			}
		}
		for(int pos1 = 1; pos1 < N - 1; ++pos1) {
			for(int pos2 = pos1 + 1; pos2 < N; ++pos2) {
				answer = Math.max(answer, preSum[pos1][M] * (preSum[pos2][M] - preSum[pos1][M]) * (preSum[N][M] - preSum[pos2][M]));
			}
		}
		for(int x = 1; x < N; ++x) {
			for(int y = 1; y < M; ++y) {
				long area1 = preSum[x][y];
				long area2 = preSum[x][M] - area1;
				long area3 = preSum[N][y] - area1;
				long area4 = preSum[N][M] - area2 - area3 - area1;

				answer = Math.max(answer, area1 * area2 * (area3 + area4));
				answer = Math.max(answer, area1 * area3 * (area2 + area4));
				answer = Math.max(answer, area3 * area4 * (area1 + area2));
				answer = Math.max(answer, area2 * area4 * (area1 + area3));
			}
		}

		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

}
