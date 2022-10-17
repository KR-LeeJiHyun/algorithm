import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_Poliomino {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String board = br.readLine();
		String[] poliomino = {"AAAA", "BB"};
		StringBuilder answer = new StringBuilder();
		
		int len = 0;
		for(int idx = 0; idx < board.length(); ++idx) {
			char c = board.charAt(idx);
			if(c == 'X') ++len;
			else {
				while(len >= 4) {
					answer.append(poliomino[0]);
					len -= 4;
				}
				while(len >= 2) {
					answer.append(poliomino[1]);
					len -= 2;
				}
				answer.append('.');
				if(len != 0) {
					answer = new StringBuilder("-1");
					len = 0;
					break;
				}
			}
		}
		
		if(len != 0) {
			while(len >= 4) {
				answer.append(poliomino[0]);
				len -= 4;
			}
			while(len >= 2) {
				answer.append(poliomino[1]);
				len -= 2;
			}
			if(len != 0) answer = new StringBuilder("-1");
		}
		
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();

	}

}
