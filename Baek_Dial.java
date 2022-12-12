import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_Dial {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		char[][] dials = new char[N][M];

		Queue<Integer> q = new LinkedList<Integer>();
		for(int row = 0; row < N; ++row) {
			String input = br.readLine();
			for(int col = 0; col < M; ++col) dials[row][col] = input.charAt(col);
		}


		String word = br.readLine();
		int len = word.length();
		int[][][] dp = new int[len][N][M];

		for(int row = 0; row < N; ++row) {
			for(int col = 0; col < M; ++col) {
				if(word.charAt(0) == dials[row][col]) dp[0][row][col] = 1;
			}
		}

		for(int pos = 1; pos < len; ++pos) {
			for(int row = 0; row < N; ++row) {
				for(int col = 0; col < M; ++col) {
					if(word.charAt(pos) == dials[row][col]) {
						for(int idx = 1; idx <= K; ++idx) {
							if(row + idx < N) dp[pos][row][col] += dp[pos - 1][row + idx][col];
							if(row - idx >= 0) dp[pos][row][col] += dp[pos - 1][row - idx][col];
							if(col + idx < M) dp[pos][row][col] += dp[pos - 1][row][col + idx];
							if(col - idx >= 0) dp[pos][row][col] += dp[pos - 1][row][col - idx];
						}
					}
				}
			}
		}

		int answer = 0;

		for(int row = 0; row < N; ++row) {
			for(int col = 0; col < M; ++col) answer += dp[len - 1][row][col];
		}

		bw.write(String.valueOf(answer));
		br.close();
		bw.close();

	}

}
