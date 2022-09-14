import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_DocSearch {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String doc = br.readLine();
		String word = br.readLine();
		int idx = 0;
		int answer = 0;
		int len = word.length();
		
		while(idx != -1) {
			idx = doc.indexOf(word, idx);
			if(idx != -1) {
				++answer;
				idx += len;
			}
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();
		
	}

}
