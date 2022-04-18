import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_EncryptionCode {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String encryption = br.readLine();	
		int mod = 1000000, len = encryption.length();
		long[] dp = new long[len];
		
		if(len == 1) {
			char first = encryption.charAt(0);
			if(first == '0') {
				bw.write(0 + "\n");
				br.close();
				bw.flush();
				bw.close();
				return;
			}
			else {
				bw.write(1 + "\n");
				br.close();
				bw.flush();
				bw.close();
				return;
			}
		}
		
		if(encryption.charAt(0) != '0') ++dp[0];
		if(encryption.charAt(1) != '0') ++dp[1];
		if(check(encryption.charAt(0), encryption.charAt(1))) ++dp[1];
		
		if(dp[0] == 0 || dp[1] == 0) {
			bw.write(0 + "\n");
			br.close();
			bw.flush();
			bw.close();
			return;
		}
		
		for(int idx = 2; idx < len; ++idx) {
			char prev = encryption.charAt(idx - 1), current = encryption.charAt(idx);
			if(current != '0') dp[idx] = dp[idx - 1];
			if(check(prev, current)) dp[idx] += dp[idx - 2];
			if(dp[idx] == 0) {
				bw.write(0 + "\n");
				br.close();
				bw.flush();
				bw.close();
				return;
			}
			
			dp[idx] = dp[idx] % mod;
		}
		
		bw.write(dp[len - 1] + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

	private static boolean check(char prev, char current) {
		if(prev == '0') return false;
		int num = (prev - '0') * 10 + current - '0';
		if(num > 26) return false;
		return true;
	}

}
