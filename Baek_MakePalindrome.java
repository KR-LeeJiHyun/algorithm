import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_MakePalindrome {
	
	/*
	static int N;
	static int[] palindrome;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		palindrome = new int[N];
		dp = new int[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) {
			palindrome[idx] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[idx], -1);
		}
		bw.write(Integer.toString(dfs(0, N - 1)));
		br.close();
		bw.close();

	}

	private static int dfs(int left, int right) {
		if(dp[left][right] == -1) {
			if(left >= right) dp[left][right] = 0;
			else if(palindrome[left] == palindrome[right]) dp[left][right] = dfs(left + 1, right - 1);
			else dp[left][right] = Math.min(dfs(left, right - 1), dfs(left + 1, right)) + 1;
		}
		return dp[left][right];
	}
	*/
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] palindrome = new int[N];
		int[][] dp = new int[N + 1][N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) palindrome[idx] = Integer.parseInt(st.nextToken());
		for(int left = 0; left < N; ++left) {
			for(int right = N - 1; right > -1; --right) {
				if(palindrome[left] == palindrome[right]) dp[left + 1][N - right] = dp[left][N - right - 1] + 1;
				else dp[left + 1][N - right] = Math.max(dp[left + 1][N - right - 1], dp[left][N - right]);
			}
		}
		bw.write(Integer.toString(N - dp[N][N]));
		br.close();
		bw.close();

	}
	
}
