import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_MeetingRoom {
	
	static class ROOM implements Comparable<ROOM> {
		int start;
		int end;
		
		public ROOM(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(ROOM o) {
			if(this.end == o.end) return this.start - o.start;
			return this.end - o.end;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<ROOM> pq = new PriorityQueue<>();
		
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
			pq.add(new ROOM(start, end));
		}
		
		int cnt = 0;
		int p_end = 0;

		while(!pq.isEmpty()) {
			ROOM current = pq.poll();
			int start = current.start, end = current.end;
			if(p_end <= start) {
				++cnt;
				p_end = end;
			}
		}
		
		bw.write(cnt + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
