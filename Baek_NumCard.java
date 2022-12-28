import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_NumCard {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String number = br.readLine();
		int len = number.length();
		int[] dp = new int[len + 1];
		dp[0] = 1;
		dp[1] = 1;
		for(int idx = 2; idx <= len; ++idx) {
			if(number.charAt(idx - 1) != '0') dp[idx] += dp[idx - 1];
			if(Integer.parseInt(number.substring(idx - 2, idx)) < 35 && Integer.parseInt(number.substring(idx - 2, idx)) > 9) dp[idx] += dp[idx - 2];
			if(dp[idx] == 0) break;
		}
		
		bw.write(String.valueOf(dp[len]));
		br.close();
		bw.close();
		
	}

}
