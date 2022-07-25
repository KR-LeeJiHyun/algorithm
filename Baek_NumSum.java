import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_NumSum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long S = Long.parseLong(br.readLine());
		int answer = 0, num = 1;
		
		while(num <= S) {
			S -= num;
			++num;
			++answer;
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();

	}

}
