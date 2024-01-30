import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek책페이지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		final int L = 10;
		int[] cnts = new int[L];
		
		int N = Integer.parseInt(br.readLine());
		int mod = 0;
		
		for(int digit = 1; N != 0; digit *= L) {
			cnts[0] -= digit;
			int curr = N % L;
			N /= L;
			
			for(int idx = 0; idx < curr; ++idx) {
				cnts[idx] += (N + 1) * digit;
			}
			cnts[curr] += N * digit + mod + 1;
			for(int idx = curr + 1; idx < L; ++idx) {
				cnts[idx] += N * digit;
			}
			
			mod += curr * digit;
		}
		
		StringBuilder answer = new StringBuilder();
		for(int idx = 0; idx < L; ++idx) {
			answer.append(cnts[idx]);
			answer.append(' ');
		}
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}

}
