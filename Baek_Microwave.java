import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_Microwave {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int[] times = {300, 60, 10};
		
		if(T % times[2] == 0) {
			int[] answers = new int[3];
			answers[0] = T / times[0];
			T -= times[0] * answers[0];
			answers[1] = T / times[1];
			T -= times[1] * answers[1];
			answers[2] = T / times[2];
			T -= times[2] * answers[2];
			
			bw.write(answers[0] + " " + answers[1] + " " + answers[2] + "\n");
		}
		
		else bw.write("-1");
		br.close();
		bw.flush();
		bw.close();

	}

}
