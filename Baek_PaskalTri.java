import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_PaskalTri {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MAX = 30;
		int[][] dp = new int[MAX][MAX];
		
		dp[1][1] = 1;
		for(int row = 2; row < MAX; ++row) {
			for(int col = 1; col <= row; ++col) {
				dp[row][col] = dp[row - 1][col - 1] + dp[row - 1][col];
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R =  Integer.parseInt(st.nextToken());
		int C =  Integer.parseInt(st.nextToken());
		int W =  Integer.parseInt(st.nextToken());
		int cnt = 1;
		int answer = 0;
		
		for(int row = R; row  < R + W; ++row) {
			for(int col = C; col < C + cnt; ++col) {
				answer += dp[row][col];
			}
			++cnt;
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();

	}

}
