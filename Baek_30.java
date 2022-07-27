import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Baek_30 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String N = br.readLine();
		int len = N.length(), sum = 0;
		PriorityQueue<Character> pq = new PriorityQueue<>();
		
		for(int idx = 0; idx < len; ++idx) {
			char c = N.charAt(idx);
			pq.add(c);
			sum += c -'0';
		} 
		
		if(sum % 3 == 0 && pq.poll() == '0') {
			StringBuilder sb = new StringBuilder();
			sb.append('0');
			while(!pq.isEmpty()) sb.append(pq.poll());
			bw.write(sb.reverse().toString());
		}
		
		else bw.write("-1");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
