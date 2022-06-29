import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_PalindromeDivde {
	
	static int[] dp;
	static int[][] palin_dp;
	static final int MAX = 2500, P = 1, IP = -1, U = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();

		int len = str.length();
		palin_dp = new int[len][len];
		
		for(int start = 0; start < len; ++start) {
			for(int end = start; end < len; ++end) {
				palin_dp[start][end] = memozation(start, end, str);
			}
		}
		
		dp = new int[len + 1];
		
		Arrays.fill(dp, MAX);
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int end = 2; end <= len; ++end) {
			for(int start = 1; start <= end; ++start) {
				if(palin_dp[start - 1][end - 1] == P) dp[end] = Math.min(dp[end], dp[start - 1] + 1);
			}
		}
		
		bw.write(dp[len] + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

	private static int memozation(int start, int end, String str) {
		if(palin_dp[start][end] != U) return palin_dp[start][end];
		else if(start == end) palin_dp[start][end] = P;
		else if(start > end) palin_dp[start][end] = P;
		else if(str.charAt(start) == str.charAt(end)) palin_dp[start][end] = memozation(start + 1, end - 1, str);
		else  palin_dp[start][end] = IP;
		return palin_dp[start][end];
	}


}
