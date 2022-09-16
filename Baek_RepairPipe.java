import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_RepairPipe {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNL = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNL.nextToken());
		int L = Integer.parseInt(stNL.nextToken());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int idx = 0; idx < N; ++idx) pq.add(Integer.parseInt(st.nextToken()));
		
		int start = pq.poll();
		int answer = 1;
		while(!pq.isEmpty()) {
			int current = pq.poll();
			if(L <= current - start) {
				start = current;
				++answer;
			}
		}
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();

	}

}
