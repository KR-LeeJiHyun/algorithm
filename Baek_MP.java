import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baek_MP {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int dasom = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for(int idx = 1; idx < N; ++idx) {
			int current = Integer.parseInt(br.readLine());
			if(current >= dasom) pq.add(current);
		}
		int answer = 0;
		while(!pq.isEmpty() && pq.peek() >= dasom) {
			dasom++;
			answer++;
			int current = pq.poll() - 1;
			if(current >= dasom) pq.add(current);
		}
		bw.write(Integer.toString(answer));
		br.close();
		bw.close();

	}

}
