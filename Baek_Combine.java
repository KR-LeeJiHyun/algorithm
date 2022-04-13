import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Baek_Combine {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		
		BigInteger answer = BigInteger.ONE;
		for(int idx = 1; idx <= m; ++idx) {
			answer = answer.multiply(BigInteger.valueOf(n - idx + 1));
			answer = answer.divide(BigInteger.valueOf(idx));
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
