import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Baek_Dic {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		BigInteger[][] dp = new BigInteger[N + 1][M + 1];
		
		for(int a = 0; a <= N; ++a) {
			for(int z = 0; z <= M; ++z) {
				if(a == 0 || z == 0) {
					dp[a][z] = BigInteger.ONE;
					continue;
				}
				dp[a][z] = dp[a - 1][z].add(dp[a][z - 1]);
			}
		}
		
		if(dp[N][M].compareTo(BigInteger.valueOf(K)) == -1) {
			bw.write("-1");
			
			br.close();
			bw.flush();
			bw.close();
			return;
		}
		
		BigInteger start = BigInteger.ONE, big_K = BigInteger.valueOf(K);
		int a_cnt = 0, z_cnt = 0;
		StringBuilder sb = new StringBuilder();
		while(start.compareTo(big_K) != 0) {
			BigInteger end = dp[N - (a_cnt + 1)][M - z_cnt].add(start.subtract(BigInteger.ONE));
			if(big_K.compareTo(end) != 1) {
				++a_cnt;
				sb.append('a');
			}
			else {
				++z_cnt;
				start = end.add(BigInteger.ONE);
				sb.append('z');
			}
		}
		
		while(a_cnt < N) {
			sb.append('a');
			++a_cnt;
		}
		while(z_cnt < M) {
			sb.append('z');
			++z_cnt;
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N + 1][M + 1];
		
		for(int a = 0; a <= N; ++a) {
			for(int z = 0; z <= M; ++z) {
				if(a == 0 || z == 0) {
					dp[a][z] = 1;
					continue;
				}
				dp[a][z] = dp[a - 1][z] + dp[a][z - 1];
                if(dp[a][z] < 0) dp[a][z] = 1000000001;
			}
		}
		
		if(dp[N][M] < K) {
			bw.write("-1");
			
			br.close();
			bw.flush();
			bw.close();
			return;
		}
		
		int start = 1,a_cnt = 0, z_cnt = 0;
		StringBuilder sb = new StringBuilder();
		while(start != K) {
			int end = dp[N - (a_cnt + 1)][M - z_cnt] + start - 1;
			if(start <= K && K <= end) {
				++a_cnt;
				sb.append('a');
			}
			else {
				++z_cnt;
				start = end + 1;
				sb.append('z');
			}
		}
		
		while(a_cnt < N) {
			sb.append('a');
			++a_cnt;
		}
		while(z_cnt < M) {
			sb.append('z');
			++z_cnt;
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
 */
