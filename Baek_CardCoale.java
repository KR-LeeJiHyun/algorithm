import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_CardCoale {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken());
		int M = Integer.parseInt(stNM.nextToken());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) pq.add(Long.parseLong(st.nextToken()));
		
		while(M != 0) {
			long x = pq.poll();
			long y = pq.poll();
			long sum = x + y;
			pq.add(sum);
			pq.add(sum);
			--M;
		}
		
		long answer = 0;
		while(!pq.isEmpty()) answer += pq.poll();
		
		bw.write(Long.toString(answer));
		br.close();
		bw.flush();
		bw.close();

	}

}
