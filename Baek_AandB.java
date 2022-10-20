import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_AandB {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder S = new StringBuilder(br.readLine());
		StringBuilder T = new StringBuilder(br.readLine());
		
		while(S.length() != T.length()) {
			int lastIndex = T.length() - 1;
			char last = T.charAt(lastIndex);
			T.deleteCharAt(lastIndex);
			if(last == 'B') T = T.reverse(); 
		}
		
		if(S.compareTo(T) == 0) bw.write('1');
		else bw.write('0');		
		br.close();
		bw.flush();
		bw.close();

	}

}
