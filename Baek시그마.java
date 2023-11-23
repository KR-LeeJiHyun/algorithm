import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek시그마 {
	
	final static int MOD = 1000000007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine());
		long S = 0;
		long N = 1;
		for(int idx = 0; idx < M; ++idx) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(input.nextToken());
			int s = Integer.parseInt(input.nextToken());
			
			S = S*n + s*N;
			N *= n;
			S %= MOD;
			N %= MOD;
		}
		
		if(S % N != 0) {
			bw.write(String.valueOf((mul(N, MOD - 2) * S) % MOD));
		}
		else bw.write(String.valueOf(S/N));
		
		br.close();
		bw.close();
	}

	private static long mul(long num, int n) {
		if(n == 1) return num;
		long half = mul(num, n / 2);
		if((n & 1) == 0) {
			return half * half % MOD;
		}
		else {
			return half * half % MOD * num % MOD;
		}
		
	}
	
}
