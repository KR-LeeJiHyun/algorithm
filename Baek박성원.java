import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baek박성원 {

	static int N;
	static int K;
	static int MAX;
	static int[][] mods;
	static long[][] dp;
	static String[] nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		MAX = (1<<N) - 1;
		nums = new String[N];
		for(int idx = 0; idx < N; ++idx) {
			nums[idx] = br.readLine();
		}
		K = Integer.parseInt(br.readLine());
		mods = new int[K][N];
		dp = new long[K][1<<N];

		for(int idx = 0; idx < K; ++idx) {
			Arrays.fill(mods[idx], -1);
			Arrays.fill(dp[idx], -1);
		}

		long count = 0;
		count = getDp(0, 0);

		if(count == 0) {
			bw.write("0/1");
		}

		else {
			long parent = 1;
			for(int idx = 2; idx <= N; ++idx) {
				parent *= idx;
			}


			long gcd = getGcd(parent, count);
			StringBuilder answer = new StringBuilder();
			answer.append(count / gcd);
			answer.append('/');
			answer.append(parent / gcd);
			bw.write(answer.toString());
		}
		
		br.close();
		bw.close();
	}

	private static long getGcd(long n, long m) {
		if(m == 0) return n;
		return getGcd(m, n % m);
	}

	private static long getDp(int bit, int mod) {
		if(dp[mod][bit] != -1) return dp[mod][bit];
		if(bit == MAX) return mod == 0 ? 1 : 0;

		long count = 0;
		for(int idx = 0; idx < N; ++idx) {
			int b = 1 << idx;
			if((bit & b) == 0) {
				count += getDp(bit + b, getMod(idx, mod));
			}
		}

		return dp[mod][bit] = count;
	}

	private static int getMod(int pos, int mod) {
		if(mods[mod][pos] != -1) return mods[mod][pos];
		int curr = mod;
		int len = nums[pos].length();
		for(int idx = 0; idx < len; ++idx) {
			curr *= 10;
			curr += nums[pos].charAt(idx) - '0';
			curr %= K;
		}

		return mods[mod][pos] = curr;
	}

}
