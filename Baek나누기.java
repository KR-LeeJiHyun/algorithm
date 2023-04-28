import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek나누기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long answer = 0;
		final int SECTION_NUM = 4;
		final int N = Integer.parseInt(br.readLine());
		int[] prefixSum = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 1; idx <= N; ++idx) {
			prefixSum[idx] = Integer.parseInt(st.nextToken()) + prefixSum[idx - 1];
		}
		
		if(prefixSum[N] == 0) {
			long cnt = 0;
			for(int idx = 1; idx <= N; ++idx) {
				if(prefixSum[idx] == 0) {
					++cnt;
				}
			}
			
			answer =  conbination(cnt - 1, SECTION_NUM - 1);
		}
		else if(prefixSum[N] % SECTION_NUM == 0) {
			long[] dp = new long[SECTION_NUM];
			int num = prefixSum[N] / SECTION_NUM;
			dp[0] = 1;
			for(int idx = 1; idx <= N; ++idx) {
				int section = prefixSum[idx] / num;
				if(prefixSum[idx] % num != 0 || section < 1 || section > 3) {
					continue;
				}
				dp[section] += dp[section - 1];
			}
			answer = dp[SECTION_NUM - 1];
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

	private static long conbination(long num, int sel) {
		long mul = 1;
		long div = 1;
		
		while(sel != 0) {
			mul *= num--;
			div *= sel--;
		}
		
		return mul / div;
	}


}
