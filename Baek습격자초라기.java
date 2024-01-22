import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek습격자초라기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int U = 0;
		final int D = 1;
		int T = Integer.parseInt(br.readLine());
		while(T > 0) {
			--T;
			StringTokenizer input = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(input.nextToken());
			int W = Integer.parseInt(input.nextToken());
			int[][]map = new int[N + 1][2];
			int[][] dp = new int[N + 1][3];
			
			input = new StringTokenizer(br.readLine());
			StringTokenizer input2 = new StringTokenizer(br.readLine());
			
			for(int row = 1; row <= N; ++row) {
				map[row][U] = Integer.parseInt(input.nextToken());
				map[row][D] = Integer.parseInt(input2.nextToken());
			}
			
			int answer = 0;
			dp[1][0] = 2;
			if(map[1][U] + map[1][D] <= W) dp[1][0] = 1;
			dp[1][1] = 1;
			dp[1][2] = 1;
			if(N == 1) {
				bw.write(String.valueOf(dp[N][0]));
				bw.write('\n');
				continue;
			}
			
			//0 : 위아래(8가지), 1: 위쪽(2가지), 2 : 아래쪽(2가지)
			for(int idx = 2; idx <= N; ++idx) {
				dp[idx][0] = dp[idx - 2][0] + 4;
				dp[idx][0] = Math.min(dp[idx][0],dp[idx - 1][0] + 2);
				dp[idx][0] = Math.min(dp[idx][0], dp[idx - 1][1] + 3);
				dp[idx][0] = Math.min(dp[idx][0], dp[idx - 1][2] + 3);
				if(map[idx][U] + map[idx][D] <= W) dp[idx][0] = Math.min(dp[idx][0],dp[idx - 1][0] + 1);
				if(map[idx][U] + map[idx - 1][U] <= W) dp[idx][0] = Math.min(dp[idx][0], dp[idx - 1][2] + 2);
				if(map[idx][D] + map[idx - 1][D] <= W) dp[idx][0] = Math.min(dp[idx][0], dp[idx - 1][1] + 2);
				if(map[idx][U] + map[idx - 1][U] <= W && map[idx][D] + map[idx - 1][D] <= W) dp[idx][0] = Math.min(dp[idx][0], dp[idx - 2][0] + 2);
				
				dp[idx][1] = dp[idx - 1][0] + 1;
				if(map[idx][U] + map[idx - 1][U] <= W) dp[idx][1] = Math.min(dp[idx][1], dp[idx - 1][2] + 1);
				dp[idx][2] = dp[idx - 1][0] + 1;
				if(map[idx][D] + map[idx - 1][D] <= W) dp[idx][2] = Math.min(dp[idx][2], dp[idx - 1][1] + 1);
			}
			
			answer = dp[N][0];
			if(map[1][U] + map[N][U] <= W && map[1][D] + map[N][D] <= W) {
				dp[2][0] = 2;
				if(map[2][U] + map[2][D] <= W) dp[2][0] = 1;
				dp[2][1] = 1;
				dp[2][2] = 1;
				
				//0 : 위아래(8가지), 1: 위쪽(2가지), 2 : 아래쪽(2가지)
				for(int idx = 3; idx <= N - 1; ++idx) {
					dp[idx][0] = dp[idx - 2][0] + 4;
					dp[idx][0] = Math.min(dp[idx][0],dp[idx - 1][0] + 2);
					dp[idx][0] = Math.min(dp[idx][0], dp[idx - 1][1] + 3);
					dp[idx][0] = Math.min(dp[idx][0], dp[idx - 1][2] + 3);
					if(map[idx][U] + map[idx][D] <= W) dp[idx][0] = Math.min(dp[idx][0],dp[idx - 1][0] + 1);
					if(map[idx][U] + map[idx - 1][U] <= W) dp[idx][0] = Math.min(dp[idx][0], dp[idx - 1][2] + 2);
					if(map[idx][D] + map[idx - 1][D] <= W) dp[idx][0] = Math.min(dp[idx][0], dp[idx - 1][1] + 2);
					if(map[idx][U] + map[idx - 1][U] <= W && map[idx][D] + map[idx - 1][D] <= W) dp[idx][0] = Math.min(dp[idx][0], dp[idx - 2][0] + 2);
					
					dp[idx][1] = dp[idx - 1][0] + 1;
					if(map[idx][U] + map[idx - 1][U] <= W) dp[idx][1] = Math.min(dp[idx][1], dp[idx - 1][2] + 1);
					dp[idx][2] = dp[idx - 1][0] + 1;
					if(map[idx][D] + map[idx - 1][D] <= W) dp[idx][2] = Math.min(dp[idx][2], dp[idx - 1][1] + 1);
				}
				
				answer = Math.min(answer, dp[N - 1][0] + 2);
			}
			
			if(map[1][U] + map[N][U] <= W) {
				dp[1][0] = 2;
				dp[1][1] = 1;
				dp[1][2] = 1000;
				
				//0 : 위아래(8가지), 1: 위쪽(2가지), 2 : 아래쪽(2가지)
				for(int idx = 2; idx <= N - 1; ++idx) {
					dp[idx][0] = dp[idx - 2][0] + 4;
					dp[idx][0] = Math.min(dp[idx][0],dp[idx - 1][0] + 2);
					dp[idx][0] = Math.min(dp[idx][0], dp[idx - 1][1] + 3);
					dp[idx][0] = Math.min(dp[idx][0], dp[idx - 1][2] + 3);
					if(map[idx][U] + map[idx][D] <= W) dp[idx][0] = Math.min(dp[idx][0],dp[idx - 1][0] + 1);
					if(idx != 2 && map[idx][U] + map[idx - 1][U] <= W) dp[idx][0] = Math.min(dp[idx][0], dp[idx - 1][2] + 2);
					if(map[idx][D] + map[idx - 1][D] <= W) dp[idx][0] = Math.min(dp[idx][0], dp[idx - 1][1] + 2);
					if(idx != 2 && map[idx][U] + map[idx - 1][U] <= W && map[idx][D] + map[idx - 1][D] <= W) dp[idx][0] = Math.min(dp[idx][0], dp[idx - 2][0] + 2);
					
					dp[idx][1] = dp[idx - 1][0] + 1;
					if(idx != 2 && map[idx][U] + map[idx - 1][U] <= W) dp[idx][1] = Math.min(dp[idx][1], dp[idx - 1][2] + 1);
					dp[idx][2] = dp[idx - 1][0] + 1;
					if(map[idx][D] + map[idx - 1][D] <= W) dp[idx][2] = Math.min(dp[idx][2], dp[idx - 1][1] + 1);
				}
				
				dp[N][0] = dp[N - 1][0] + 1;
				if(map[N][D] + map[N - 1][D] <= W) dp[N][0] = Math.min(dp[N][0], dp[N - 1][1] + 1);
				answer = Math.min(answer, dp[N][0]);
			}
			
			if(map[1][D] + map[N][D] <= W) {
				dp[1][0] = 2;
				dp[1][1] = 1000;
				dp[1][2] = 1;
				
				//0 : 위아래(8가지), 1: 위쪽(2가지), 2 : 아래쪽(2가지)
				for(int idx = 2; idx <= N - 1; ++idx) {
					dp[idx][0] = dp[idx - 2][0] + 4;
					dp[idx][0] = Math.min(dp[idx][0],dp[idx - 1][0] + 2);
					dp[idx][0] = Math.min(dp[idx][0], dp[idx - 1][1] + 3);
					dp[idx][0] = Math.min(dp[idx][0], dp[idx - 1][2] + 3);
					if(map[idx][U] + map[idx][D] <= W) dp[idx][0] = Math.min(dp[idx][0],dp[idx - 1][0] + 1);
					if(map[idx][U] + map[idx - 1][U] <= W) dp[idx][0] = Math.min(dp[idx][0], dp[idx - 1][2] + 2);
					if(idx != 2 && map[idx][D] + map[idx - 1][D] <= W) dp[idx][0] = Math.min(dp[idx][0], dp[idx - 1][1] + 2);
					if(idx != 2 && map[idx][U] + map[idx - 1][U] <= W && map[idx][D] + map[idx - 1][D] <= W) dp[idx][0] = Math.min(dp[idx][0], dp[idx - 2][0] + 2);
					
					dp[idx][1] = dp[idx - 1][0] + 1;
					if(map[idx][U] + map[idx - 1][U] <= W) dp[idx][1] = Math.min(dp[idx][1], dp[idx - 1][2] + 1);
					dp[idx][2] = dp[idx - 1][0] + 1;
					if(idx != 2 && map[idx][D] + map[idx - 1][D] <= W) dp[idx][2] = Math.min(dp[idx][2], dp[idx - 1][1] + 1);
				}
				
				dp[N][0] = dp[N - 1][0] + 1;
				if(map[N][U] + map[N - 1][U] <= W) dp[N][0] = Math.min(dp[N][0], dp[N - 1][2] + 1);
				answer = Math.min(answer, dp[N][0]);
			}

			bw.write(String.valueOf(answer));
			bw.write('\n');
		}
		br.close();
		bw.close();
	}

}
