import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_TriangleGraph {
	
	static int[][] map;
	static int[][] dp;
	static int n;
	static final int m = 3;



	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int k = 1;
		StringBuilder sb = new StringBuilder();

		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			map = new int[n][m];
			for(int row = 0; row < n; ++row) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int col = 0; col < m; ++col) map[row][col] = Integer.parseInt(st.nextToken());
			}
			dp = new int[n][m];
			dp[1][0] = map[0][1] + map[1][0];
			dp[1][1] = Math.min(map[0][1], Math.min(map[0][1] + map[0][2], dp[1][0])) + map[1][1];
			dp[1][2] = Math.min(map[0][1], Math.min(map[0][1] + map[0][2], dp[1][1])) + map[1][2];
			
			for(int idx = 2; idx < n; ++idx) {
				dp[idx][0] = Math.min(dp[idx - 1][0] + map[idx][0], dp[idx - 1][1] + map[idx][0]);
				dp[idx][1] = Math.min(dp[idx - 1][0] + map[idx][1], Math.min(dp[idx - 1][1] + map[idx][1], dp[idx - 1][2] + map[idx][1]));
				dp[idx][2] = Math.min(dp[idx - 1][1] + map[idx][2], dp[idx - 1][2] + map[idx][2]);
				
				dp[idx][1] = Math.min(dp[idx][1], dp[idx][0] + map[idx][1]);
				dp[idx][2] = Math.min(dp[idx][2], dp[idx][1] + map[idx][2]);
			}
			
			int answer = dp[n - 1][1];
			
			sb.append(k++);
			sb.append(". ");
			sb.append(answer);
			sb.append('\n');
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}

}
