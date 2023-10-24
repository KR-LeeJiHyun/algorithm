import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek할로윈의양아치 {
	
	static int N;
	static int M;
	static int K;
	
	static final int C = 0;
	static final int P = 1;
	static int[] parents;
	static int[][] candy;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		N = Integer.parseInt(input.nextToken());
		M = Integer.parseInt(input.nextToken());
		K = Integer.parseInt(input.nextToken());
		
		parents = new int[N + 1];
		candy = new int[N + 1][2];
		input = new StringTokenizer(br.readLine());
		
		for(int idx = 1; idx <= N; ++idx) {
			parents[idx] = idx;
			candy[idx][C] = Integer.parseInt(input.nextToken());
			candy[idx][P] = 1;
		}
		
		for(int idx = 0; idx < M; ++idx) {
			input = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(input.nextToken());
			int s = Integer.parseInt(input.nextToken());
			int fp = find(f);
			int sp = find(s);
			
			if(fp != sp) {
				if(fp < sp) {
					union(fp, sp);
				}
				else {
					union(sp, fp);
				}
			}
		}
		
		int[] dp = new int[K];
		
		for(int idx = 1; idx <= N; ++idx) {
			if(parents[idx] != idx) continue; 
			for(int p = K - 1; p >= candy[idx][P]; --p) {
				dp[p] = Math.max(dp[p], dp[p - candy[idx][P]] + candy[idx][C]);
			}
		}
		
		bw.write(String.valueOf(dp[K - 1]));
		br.close();
		bw.close();

	}

	private static void union(int a, int b) {
		parents[b] = a;
		candy[a][C] += candy[b][C];
		candy[a][P] += candy[b][P];
	}

	private static int find(int num) {
		if(parents[num] == num) return num;
		return parents[num] = find(parents[num]);
	}

}
