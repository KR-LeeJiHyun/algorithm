import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_Reverse {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String S = br.readLine();
		char prev = '2';
		int[] reverse = new int[2];
		
		for(int idx = 0; idx < S.length(); ++idx) {
			char c = S.charAt(idx);
			if(c != prev) {
				prev = c;
				++reverse[Character.getNumericValue(c)];
			}
		}
		
		int answer = Math.min(reverse[0], reverse[1]);
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();
		
	}

}
