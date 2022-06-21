import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baek_StepNumber {
	static int[][][] dp;
	static int N;
	static final int ALLBIT = 1023;
	static final int NUM = 10;
	static final int MOD = 1000000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][NUM][1 << NUM];
		
		for(int num = 1; num < NUM; ++num) dp[1][num][1 << num] = 1;
		
		for(int digit = 2; digit <= N; ++digit) {
			for(int num = 0; num < NUM; ++num) {
				for(int bit = 0; bit <= ALLBIT; ++bit) {
					int sum_bit = bit | (1 << num);
					if(num != 0 && (bit >> (num - 1) & 1) == 1) {
						dp[digit][num][sum_bit] += dp[digit - 1][num - 1][bit];
						dp[digit][num][sum_bit] %= MOD;
					}
					
					if(num != 9 && (bit >> (num + 1) & 1) == 1) {
						dp[digit][num][sum_bit] += dp[digit - 1][num + 1][bit];
						dp[digit][num][sum_bit] %= MOD;
					}
					
				}
			}
		}
		
		int answer = 0;
		
		for(int num = 0; num < NUM; ++num) {
			answer += dp[N][num][ALLBIT];
			answer %= MOD;
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
