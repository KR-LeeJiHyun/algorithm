import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_LectureTour {

	static class Lecture{
		int cost;
		int day;

		Lecture(int cost, int day) {
			this.cost = cost;
			this.day = day;
		}
	}

	static int[] days;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int MAXD = 10000;
		int N = Integer.parseInt(br.readLine());
		days = new int[MAXD + 1];
		for(int idx = 1; idx <= MAXD; ++idx) days[idx] = idx;

		PriorityQueue<Lecture> pq = new PriorityQueue<>((o1, o2) -> o2.day - o1.day);
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int answer = 0;
		if(N != 0) {
			int bigDay = pq.peek().day;
			PriorityQueue<Lecture> cPq = new PriorityQueue<>((o1, o2) -> o2.cost - o1.cost);
			for(; bigDay > 0; --bigDay) {
				while(!pq.isEmpty() && pq.peek().day == bigDay) cPq.add(pq.poll());
				if(!cPq.isEmpty()) answer += cPq.poll().cost;
			}
		}

		bw.write(Integer.toString(answer));
		br.close();
		bw.close();

	}

}
