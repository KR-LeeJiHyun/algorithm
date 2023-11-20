import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Baek피보나치수6 {
	
	final static long MOD = 1000000007;
	static HashMap<Long, Long> map = new HashMap();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		map.put(0l, 0l);
		map.put(1l, 1l);
		map.put(2l, 1l);
		long n = Long.parseLong(br.readLine());
		
		bw.write(String.valueOf(fib(n)));
		br.close();
		bw.close();
	}

	private static long fib(long n) {
		if(map.containsKey(n)) {
			return map.get(n);
		}
		
		long result = 0;
		if((n&1) == 0) {
			result = fib(n/2) * (fib(n/2 + 1) + fib(n/2 - 1));
		}
		else {
			result = fib((n+1)/2)*fib((n+1)/2) % MOD + fib((n-1)/2)*fib((n-1)/2) % MOD;
		}
		result %= MOD;
		map.put(n, result);
		return result;
	}

}
