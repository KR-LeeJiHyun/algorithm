import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek사과나무 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[][] apples = new int[N + 1][N + 1];
		int answer = Integer.MIN_VALUE;

		for(int row = 1; row <= N; ++row){
			StringTokenizer input = new StringTokenizer(br.readLine());
			for(int col = 1; col <= N; ++col) {
				int apple = Integer.parseInt(input.nextToken());
				apples[row][col] = apple + apples[row - 1][col] + apples[row][col - 1] - apples[row - 1][col - 1];
				answer = Math.max(answer, apple);
			}
		}

		for(int k = 1; k < N; ++k) {
			for(int row = 1; row <= N - k; ++row){
				for(int col = 1; col <= N - k; ++col) {
					int endR = row + k;
					int endC = col + k;

					answer = Math.max(answer, apples[endR][endC] - apples[endR][col - 1] - apples[row - 1][endC] + apples[row - 1][col - 1]);
				}
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();

	}
}
