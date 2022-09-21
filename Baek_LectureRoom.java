import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_LectureRoom {
	
	static class Lecture implements Comparable<Lecture>{
		int start;
		int end;
		
		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(Lecture o) {
			if(this.start == o.start) return this.end - o.end;
			return this.start - o.start;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Lecture> pq = new PriorityQueue<>();
		
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		PriorityQueue<Integer> room = new PriorityQueue<>();
		room.add(-1);
		
		while(!pq.isEmpty()) {
			if(room.peek() <= pq.peek().start) {
				room.poll();
				room.add(pq.poll().end);
			}
			else room.add(pq.poll().end);
		}
		
		
		bw.write(Integer.toString(room.size()));
		br.close();
		bw.flush();
		bw.close();
	}

}
