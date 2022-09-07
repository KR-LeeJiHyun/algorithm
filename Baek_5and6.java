import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_5and6 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String strA = st.nextToken(), strB = st.nextToken();
		int maxA = 0, minA = 0, maxB = 0, minB = 0;
		
		for(int idx = 0; idx < strA.length(); ++idx) {
			char c = strA.charAt(idx);
			if(c == '6' || c == '5') {
				maxA = maxA * 10 + 6;
				minA = minA * 10 + 5;
			}
			else {
				maxA = maxA * 10 + Character.getNumericValue(c);
				minA = minA * 10 + Character.getNumericValue(c);
			}
		}
		
		for(int idx = 0; idx < strB.length(); ++idx) {
			char c = strB.charAt(idx);
			if(c == '6' || c == '5') {
				maxB = maxB * 10 + 6;
				minB = minB * 10 + 5;
			}
			else {
				maxB = maxB * 10 + Character.getNumericValue(c);
				minB = minB * 10 + Character.getNumericValue(c);
			}
		}
		
		int max = maxA + maxB, min = minA + minB;
		
		bw.write(min + " " + max);
		br.close();
		bw.flush();
		bw.close();

	}

}
