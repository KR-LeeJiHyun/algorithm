import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek1의개수세기 {
	static final int MAX = 55;
	static long[] dp = new long[MAX];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		dp[0] = 1;
		for(int idx = 1; idx < MAX; ++idx) {
			dp[idx] = dp[idx - 1] * 2 + (1l << idx);
		}
		
		long answer = sum(B) - sum(A - 1);
		bw.write(Long.toString(answer));
		br.close();
		bw.close();
	}

	private static long sum(long num) {
		long result = num & 1;
		for(int idx = MAX - 1; idx > 0; --idx) {
			if((num & (1l << idx)) != 0) {
				long minus = 1l << idx;
				result += dp[idx - 1] + num - minus + 1;
				num -= minus;
			}
		}
		return result;
	}

}
