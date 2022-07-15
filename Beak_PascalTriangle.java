import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Beak_PascalTriangle {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		
		final int MAX = 31;
		int[][] dp = new int[MAX][MAX];
		
		dp[1][1] = 1;
		
		for(int row = 2; row < MAX; ++row) for(int col = 1; col <= row; ++col) dp[row][col] = dp[row - 1][col - 1] + dp[row - 1][col];
		
		bw.write(dp[n][k] + "\n");
		br.close();
		bw.flush();
		bw.close();

	}

}
