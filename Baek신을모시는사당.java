import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek신을모시는사당 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int prefix = 0;
		int min = 0;
		int max = 0;
		
		int num = Integer.parseInt(st.nextToken());
		if(num == 1) {
			prefix = 1;
		}
		else {
			prefix = -1;
		}
		max = Math.max(prefix, max);
		min = Math.min(prefix, min);
		
		int answer = Math.abs(prefix);
		
		for(int idx = 1; idx < N; ++idx) {
			num = Integer.parseInt(st.nextToken());
			if(num == 1) {
				prefix += 1;
			}
			else {
				prefix -= 1;
			}
			
			answer = Math.max(answer, Math.abs(prefix - min));
			answer = Math.max(answer, Math.abs(prefix - max));
			
			min = Math.min(min, prefix);
			max = Math.max(max, prefix);	 
		}
		
		bw.write(String.valueOf(answer));
		bw.close();
		br.close();

	}

}
