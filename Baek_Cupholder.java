import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_Cupholder {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String seat = br.readLine();
		
		int answer = 1;
		
		for(int idx = 0; idx < N; ++idx) {
			++answer;
			if(seat.charAt(idx) == 'L') ++idx;
		}
		
		bw.write(Integer.toString(Math.min(answer, N)));
		br.close();
		bw.flush();
		bw.close();

	}

}
