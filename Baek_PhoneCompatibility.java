import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_PhoneCompatibility {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int MAX = 16;
		int[][] dp = new int[MAX][2];
		
		String number1 = br.readLine();
		String number2 = br.readLine();
		int nIdx = 0;
		for(int idx = 0; idx < MAX; idx += 2) {
			dp[idx][0] = number1.charAt(nIdx) - '0';
			dp[idx + 1][0] = number2.charAt(nIdx++) -'0';
		}
		
		int pos = 0;
		for(int idx = 15; idx > 1; --idx) {
			int next = (pos + 1) % 2;
			for(int sIdx = 0; sIdx < idx; ++sIdx) dp[sIdx][next] = (dp[sIdx][pos] + dp[sIdx + 1][pos]) % 10;
			pos = next;
		}
		
		bw.write(Integer.toString(dp[0][0]));
		bw.write(Integer.toString(dp[1][0]));
		br.close();
		bw.close();

	}

}
