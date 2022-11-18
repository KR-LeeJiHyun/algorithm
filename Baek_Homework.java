import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_Homework {
	
	static class Homework implements Comparable<Homework> {
		private int deadline;
		private int score;
		
		Homework(int deadline, int score) {
			this.deadline = deadline;
			this.score = score;
		}
		
		public int compareTo(Homework o) {
			return o.score - this.score;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Homework> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new Homework(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		
		int answer = 0;
		while(!pq.isEmpty()) {
			Homework current = pq.poll();
			int day = current.deadline;
			if(day > N) day = N;
			while(visited[day]) --day;
			if(day != 0) {
				visited[day] = true;
				answer += current.score;
			}
		}
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();

	}

}
