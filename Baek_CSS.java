import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_CSS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str1 = br.readLine(), str2 = br.readLine();
		int str1Len = str1.length(), str2Len = str2.length(), answer = 0;
		int dp[][] = new int[str1Len][str2Len];
		
		for(int idx = 0; idx < str1Len; ++idx) {
			char cStr1 = str1.charAt(idx);
			for(int sIdx = 0; sIdx < str2Len; ++sIdx) {
				char cStr2 = str2.charAt(sIdx);
				if(idx != 0 && sIdx != 0) {
					if(cStr1 == cStr2) {
						dp[idx][sIdx] = dp[idx - 1][sIdx - 1] + 1;
					}
				}
				else {
					if(cStr1 == cStr2) dp[idx][sIdx] = 1;
				}
				
				answer = Math.max(answer, dp[idx][sIdx]);
			}
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
