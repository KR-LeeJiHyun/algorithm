import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_LCS3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str1 = br.readLine(), str2 = br.readLine(), str3 = br.readLine();
		int[][][] dp = new int[str1.length() + 1][str2.length() + 1][str3.length() + 1];

		for(int idx1 = 1; idx1 <= str1.length(); ++idx1) {
			char c1 = str1.charAt(idx1 - 1);
			for(int idx2 = 1; idx2 <= str2.length(); ++idx2) {
				for(int idx3 = 1; idx3 <= str3.length(); ++idx3) {
					if(str3.charAt(idx3 - 1) == c1 && str2.charAt(idx2 - 1) == c1) {
						dp[idx1][idx2][idx3] = dp[idx1 - 1][idx2 - 1][idx3 - 1] + 1;
					}
					dp[idx1][idx2][idx3] = Math.max(dp[idx1][idx2][idx3], Math.max(dp[idx1][idx2][idx3 - 1],  Math.max(dp[idx1][idx2 - 1][idx3], dp[idx1 - 1][idx2][idx3])));
				}
			}
		}

		bw.write(dp[str1.length()][str2.length()][str3.length()] + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
