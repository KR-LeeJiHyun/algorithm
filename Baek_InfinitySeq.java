import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek_InfinitySeq {
	
	static HashMap<BigInteger, BigInteger> dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger N = new BigInteger(st.nextToken()), P = new BigInteger(st.nextToken()), Q = new BigInteger(st.nextToken());
		dp = new HashMap<>();
		dp.put(BigInteger.ZERO, BigInteger.ONE);
		
		
		bw.write(dfs(N, P, Q) + "\n");
		br.close();
		bw.flush();
		bw.close();
		
	}

	private static BigInteger dfs(BigInteger n, BigInteger p, BigInteger q) {
		
		if(dp.containsKey(n)) return dp.get(n);
		BigInteger Ap = dfs(n.divide(p), p, q), Aq = dfs(n.divide(q), p, q);
		BigInteger result = Ap.add(Aq);
		dp.put(n, result);
		return result;
		
	}

}
