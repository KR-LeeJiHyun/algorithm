import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_LCS2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String strA = br.readLine();
		String strB = br.readLine();
		int aLen = strA.length(), bLen = strB.length();
		
		int[][] dp = new int[aLen + 1][bLen + 1];
		StringBuilder[][] sb = new StringBuilder[2][bLen + 1];
		
		for(int idx = 0; idx < 2; ++ idx) sb[idx][0] = new StringBuilder("");
		for(int idx = 0; idx <= bLen; ++ idx) sb[0][idx] = new StringBuilder("");
		
		for(int aIdx = 1; aIdx <= aLen; ++aIdx) {
			char a = strA.charAt(aIdx - 1);
			for(int bIdx = 1; bIdx <= bLen; ++bIdx) { 
				sb[1][bIdx] = new StringBuilder("");
				if(dp[aIdx][bIdx] < dp[aIdx][bIdx - 1]) {
					sb[1][bIdx] = new StringBuilder(sb[1][bIdx - 1]);
					dp[aIdx][bIdx] = dp[aIdx][bIdx - 1];
				}
				if(dp[aIdx][bIdx] < dp[aIdx - 1][bIdx]) {
					sb[1][bIdx] = new StringBuilder(sb[0][bIdx]);
					dp[aIdx][bIdx] = dp[aIdx - 1][bIdx];
				}
				
				char b = strB.charAt(bIdx - 1);
				if(a == b && dp[aIdx][bIdx] < dp[aIdx - 1][bIdx - 1] + 1) {
					sb[1][bIdx] = new StringBuilder(sb[0][bIdx - 1]);
					sb[1][bIdx].append(a);
					dp[aIdx][bIdx] = dp[aIdx - 1][bIdx - 1] + 1;
				}
			}
			sb[0] = sb[1].clone();
		}
		
		bw.write(dp[aLen][bLen] + "\n");
		bw.write(sb[1][bLen].toString() + "\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
