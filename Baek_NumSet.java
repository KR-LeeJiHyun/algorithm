import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Baek_NumSet {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()), zeroCnt = 0;
		PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder()), minusPq = new PriorityQueue<>();
		
		for(int idx = 0; idx < N; ++idx) {
			int num = Integer.parseInt(br.readLine());
			if(num > 0) plusPq.add(num);
			else if(num < 0) minusPq.add(num);
			else ++zeroCnt;
		}
		
		int answer = 0;
		
		while(!plusPq.isEmpty()) {
			int current = plusPq.poll();
			if(!plusPq.isEmpty() && plusPq.peek() * current > current) current *= plusPq.poll();
			answer += current;
		}
		
		while(!minusPq.isEmpty()) {
			int current = minusPq.poll();
			if(!minusPq.isEmpty() && minusPq.peek() * current > current) current *= minusPq.poll();
			else if(zeroCnt != 0) {
				current = 0;
				--zeroCnt;
			}
			answer += current;
		}
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

}
