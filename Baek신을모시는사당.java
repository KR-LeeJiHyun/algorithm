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
		int[] prefix = new int[N];
		int min = 0;
		int max = 0;
		
		int num = Integer.parseInt(st.nextToken());
		if(num == 1) {
			prefix[0] = 1;
		}
		else {
			prefix[0] = -1;
		}
		max = prefix[0];
		min = prefix[0];
		
		int answer = Math.abs(prefix[0]);
		
		for(int idx = 1; idx < N; ++idx) {
			num = Integer.parseInt(st.nextToken());
			if(num == 1) {
				prefix[idx] = 1 + prefix[idx - 1];
			}
			else {
				prefix[idx] = -1 + prefix[idx - 1];
			}
			
			answer = Math.max(answer, Math.abs(prefix[idx]));
			answer = Math.max(answer, Math.abs(prefix[idx] - min));
			answer = Math.max(answer, Math.abs(prefix[idx] - max));
			
			min = Math.min(min, prefix[idx]);
			max = Math.max(max, prefix[idx]);
			 
		}
		
		bw.write(String.valueOf(answer));
		bw.close();
		br.close();

	}

}
