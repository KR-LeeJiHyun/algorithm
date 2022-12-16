import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Baek_Matchstick {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		final int MAX = 100;
		int[] matchsticks = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
		BigInteger[] maxDp = new BigInteger[MAX + 1];
		BigInteger[] minDp = new BigInteger[MAX + 1];
		maxDp[0] = BigInteger.ZERO;
		minDp[0] = BigInteger.ZERO;
		
		for(int idx = 2; idx <= MAX; ++idx) {
			maxDp[idx] = BigInteger.ZERO;
			minDp[idx] = BigInteger.ZERO;
			for(int num = 0; num <= 9; ++num) {
				if(idx - matchsticks[num] >= 0 && idx - matchsticks[num] != 1) {
					BigInteger max = new BigInteger(maxDp[idx - matchsticks[num]].toString() + Integer.toString(num));
					BigInteger min = new BigInteger(minDp[idx - matchsticks[num]].toString() + Integer.toString(num));
					if(maxDp[idx].compareTo(max) == -1) maxDp[idx] = max;
					if(minDp[idx].compareTo(BigInteger.ZERO) == 0 || minDp[idx].compareTo(min) == 1) minDp[idx] = min;
				}
			}
		}
		
		while(T > 0) {
			--T;
			int N = Integer.parseInt(br.readLine());
			bw.write(minDp[N].toString());
			bw.write(' ');
			bw.write(maxDp[N].toString());
			bw.write('\n');
		}
		
		br.close();
		bw.close();

	}

}
