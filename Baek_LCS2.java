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
		
		int[][][] dp = new int[aLen + 1][bLen + 1][4];

		for(int aIdx = 1; aIdx <= aLen; ++aIdx) {
			char a = strA.charAt(aIdx - 1);
			for(int bIdx = 1; bIdx <= bLen; ++bIdx) { 
				
				if(dp[aIdx][bIdx][0] < dp[aIdx][bIdx - 1][0]) {
					dp[aIdx][bIdx][0] = dp[aIdx][bIdx - 1][0];
					dp[aIdx][bIdx][1] = dp[aIdx][bIdx - 1][1];
					dp[aIdx][bIdx][2] = aIdx;
					dp[aIdx][bIdx][3] = bIdx - 1;
				}
				
				if(dp[aIdx][bIdx][0] < dp[aIdx - 1][bIdx][0]) {
					dp[aIdx][bIdx][0] = dp[aIdx - 1][bIdx][0];
					dp[aIdx][bIdx][1] = dp[aIdx - 1][bIdx][1];
					dp[aIdx][bIdx][2] = aIdx - 1;
					dp[aIdx][bIdx][3] = bIdx;
				}
				
				char b = strB.charAt(bIdx - 1);
				if(a == b && dp[aIdx][bIdx][0] < dp[aIdx - 1][bIdx - 1][0] + 1) {
					dp[aIdx][bIdx][0] = dp[aIdx - 1][bIdx - 1][0] + 1;
					dp[aIdx][bIdx][1] = bIdx - 1;
					dp[aIdx][bIdx][2] = aIdx - 1;
					dp[aIdx][bIdx][3] = bIdx - 1;
				}
			}
		}
		
		int answer = dp[aLen][bLen][0];
		StringBuilder sb = new StringBuilder("");
		boolean[] visited = new boolean[bLen];
		int aIdx = aLen, bIdx = bLen;
		while(sb.length() != answer) {
			if(!visited[dp[aIdx][bIdx][1]]) {
				visited[dp[aIdx][bIdx][1]] = true;
				sb.append(strB.charAt(dp[aIdx][bIdx][1]));
			}
			int nAIdx = dp[aIdx][bIdx][2], nBIdx = dp[aIdx][bIdx][3];
			aIdx = nAIdx;
			bIdx = nBIdx;
		}
		bw.write(answer + "\n");
		bw.write(sb.reverse().toString() + "\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
