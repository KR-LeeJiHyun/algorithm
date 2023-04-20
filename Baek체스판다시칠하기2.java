import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek체스판다시칠하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNMK = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNMK.nextToken());
		int M = Integer.parseInt(stNMK.nextToken());
		int K = Integer.parseInt(stNMK.nextToken());
		
		int[][] blackBoard = new int[N + 1][M + 1];
		char[] colors = {'B', 'W'};
		
		int bnext = 0;
		for(int row = 1; row <= N; ++row) {
			String str = br.readLine();
			for(int col = 1; col <= M; ++col) {
				char c = str.charAt(col - 1);
				blackBoard[row][col] = c == colors[bnext] ? 0 : 1;
				blackBoard[row][col] += blackBoard[row - 1][col] + blackBoard[row][col - 1] - blackBoard[row - 1][col - 1];
				bnext = (bnext + 1) % 2;
			}
			if(M % 2 == 0) {
				bnext = (bnext + 1) % 2;
			}
		}
		
		int answer = Integer.MAX_VALUE;
		int square = K * K;
		for(int row = 1; row <= N - K + 1; ++row) {
			for(int col = 1; col <= M - K + 1; ++col) {
				int endRow = row + K - 1;
				int endCol = col + K - 1;
				int cnt = blackBoard[endRow][endCol] - blackBoard[row - 1][endCol] - blackBoard[endRow][col - 1] + blackBoard[row - 1][col - 1];
				answer = Math.min(answer, cnt);
				answer = Math.min(answer, square - cnt);
				
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

}
