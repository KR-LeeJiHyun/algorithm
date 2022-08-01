import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Baek_CardSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int idx = 0; idx < N; ++idx) pq.add(Integer.parseInt(br.readLine()));
		
		int answer = 0;
		while(pq.size() != 1) {
			int sum = pq.poll();
			sum += pq.poll();
			answer += sum;
			pq.add(sum);
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();

	}

}
