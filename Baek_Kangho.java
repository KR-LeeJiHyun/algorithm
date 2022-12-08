import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Baek_Kangho {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int idx = 0; idx < N; ++idx) pq.add(Integer.parseInt(br.readLine()));
		
		long answer = 0;
		int minus = 0;
		while(!pq.isEmpty()) {
			int tip = pq.poll() - minus++;
			if(tip <= 0) break;
			answer += tip;
		}

		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
		
	}

}
