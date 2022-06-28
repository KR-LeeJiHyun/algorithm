import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_Plum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken());
		
		int [][] dp = new int[T][W + 1];
		int[] trees = new int[T];
		trees[0] = Integer.parseInt(br.readLine());
		
		if(trees[0] == 1) dp[0][0] = 1;
		else dp[0][1] = 1;
		
		
		int answer = 1;
		for(int idx = 1; idx < T; ++idx) {
			boolean move = false, non_move = false;
			trees[idx] = Integer.parseInt(br.readLine());
			Arrays.fill(dp[idx], 1);
			for(int s_idx = idx - 1; s_idx >= 0; --s_idx) {
				if(non_move && move) break;
				if(trees[idx] == trees[s_idx] && !non_move) {
					for(int cnt = 0; cnt <= W; ++cnt) dp[idx][cnt] = Math.max(dp[idx][cnt], dp[s_idx][cnt] + 1);
					non_move = true;
				}
				else if(trees[idx] != trees[s_idx] && !move) {
					for(int cnt = 1; cnt <= W; ++cnt) dp[idx][cnt] = Math.max(dp[idx][cnt], dp[s_idx][cnt - 1] + 1);
					move = true;
				}
			}
		}
		
		for(int cnt = 0; cnt <= W; ++cnt) answer = Math.max(answer, dp[T - 1][cnt]);
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
