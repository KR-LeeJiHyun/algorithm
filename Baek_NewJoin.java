import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_NewJoin {
	
	static class Pair implements Comparable<Pair>{
		
		int doc;
		int interview;
		
		public Pair(int doc, int interview) {
			this.doc = doc;
			this.interview = interview;
		}
		
		public int compareTo(Pair o) {
			return this.doc - o.doc;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; ++t) {
			
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			for(int idx = 0; idx < N; ++idx) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int doc = Integer.parseInt(st.nextToken()), interview = Integer.parseInt(st.nextToken());
				pq.add(new Pair(doc, interview));
			}
			
			int best_inter = Integer.MAX_VALUE;
			int answer = 0;
			
			while(!pq.isEmpty()) {
				Pair current = pq.poll();
				if(best_inter > current.interview) {
					++answer;
					best_inter = current.interview;
				}
			}
			
			sb.append(answer);
			sb.append('\n');
			
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
		
	}

}
