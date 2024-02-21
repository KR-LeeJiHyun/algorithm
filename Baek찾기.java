import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Baek찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String T = br.readLine();
		String P = br.readLine();
		int len = P.length();
		ArrayList<Integer> answer = new ArrayList<>();
		int[] maxK = new int[len];
		int pos = 0;
		
		for(int idx = 1; idx < len; ++idx) {
			char c = P.charAt(idx);
			while(pos > 0 && c != P.charAt(pos)) pos = maxK[pos - 1];
			if(c == P.charAt(pos)) {
				++pos;
				maxK[idx] = pos;
			}
		}
		
		pos = 0;
		for(int idx = 0; idx < T.length(); ++idx) {
			char c = T.charAt(idx);
			while(pos > 0 && c != P.charAt(pos)) {
				pos = maxK[pos - 1];
			}
			if(c == P.charAt(pos)) {
				if(pos == len - 1) {
					answer.add(idx - pos + 1);
					pos = maxK[pos];
				}
				else pos += 1;
			}
		}
		
		bw.write(String.valueOf(answer.size()));
		bw.write('\n');
		for(int idx = 0; idx < answer.size(); ++idx) {
			bw.write(String.valueOf(answer.get(idx)));
			bw.write(String.valueOf(' '));
		}
		
		br.close();
		bw.close();
	}

}
