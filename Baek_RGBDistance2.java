import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_RGBDistance2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] RGB = new int[N][3], dp = new int[N][3], nums =  new int[3][2];
		
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			RGB[idx][0] = Integer.parseInt(st.nextToken());
			RGB[idx][1] = Integer.parseInt(st.nextToken());
			RGB[idx][2] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][0] = RGB[0][0];
		dp[0][1] = RGB[0][1];
		dp[0][2] = RGB[0][2];
		
		int answer = Integer.MAX_VALUE;
		for(int start = 0; start < 3; ++start) {
			
			for(int color = 0; color < 3; ++color) {
				if(color != start) dp[1][color] = RGB[0][start] + RGB[1][color];
				else dp[1][color] = Integer.MAX_VALUE;
			}
			
			for(int idx = 2; idx < N - 1; ++idx) {
				dp[idx][0] = Math.min(dp[idx - 1][1], dp[idx - 1][2]) + RGB[idx][0];
				dp[idx][1] = Math.min(dp[idx - 1][0], dp[idx - 1][2]) + RGB[idx][1];
				dp[idx][2] = Math.min(dp[idx - 1][1], dp[idx - 1][0]) + RGB[idx][2];
			}
			
			for(int color = 0; color < 3; ++color) {
				if(color != start) {
					for(int prev = 0; prev < 3; ++prev) {
						if(color != prev && dp[N - 2][prev] != Integer.MAX_VALUE) answer = Math.min(answer, dp[N - 2][prev] + RGB[N - 1][color]);
					}
				}
			}
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
