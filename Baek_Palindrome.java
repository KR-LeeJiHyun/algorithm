import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Palindrome {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N + 1];
		int[][] dp = new int[N + 1][N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 1; idx <= N; ++idx) {
			nums[idx] = Integer.parseInt(st.nextToken());
			dp[idx][idx] = 1;
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int cnt = 0; cnt < M; ++cnt) {
			StringTokenizer stSE = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(stSE.nextToken()), E = Integer.parseInt(stSE.nextToken());
			
			memozation(S, E, nums, dp);
			
			if(dp[S][E] == 1) bw.write("1\n");
			else bw.write("0\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static int memozation(int s, int e, int[] nums, int[][] dp) {
		if(s > e) return 1;
		if(dp[s][e] == 0) {
			if(nums[s] != nums[e]) dp[s][e] = -1;
			else dp[s][e] = memozation(s + 1, e - 1, nums, dp);
		}
		return dp[s][e];
	}

}
