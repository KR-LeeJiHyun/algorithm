import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_SneakBaird {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNL = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNL.nextToken());
		int L = Integer.parseInt(stNL.nextToken());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int idx = 0; idx < N; ++idx) pq.add(Integer.parseInt(st.nextToken()));
		
		while(!pq.isEmpty()) {
			if(pq.poll() <= L) ++L;
			else break;
		}
		
		bw.write(Integer.toString(L));
		br.close();
		bw.close();

	}

}
