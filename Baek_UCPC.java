import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_UCPC {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		String abbreviation = "UCPC";
		
		boolean possible = true;
		int pos = 0;
		for(int idx = 0; idx < abbreviation.length(); ++idx) {
			char c = abbreviation.charAt(idx);
			pos = str.indexOf(c, pos);
			if(pos == -1) {
				possible = false;
				break;
			}
		}
		
		if(possible) bw.write("I love UCPC");
		else bw.write("I hate UCPC");
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
