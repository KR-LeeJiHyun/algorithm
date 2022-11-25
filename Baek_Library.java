import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_Library {
	
	static class Book implements Comparable<Book>{
		
		private int pos;
		
		Book(int pos) {
			this.pos = pos;
		}
		
		public int compareTo(Book o) {
			return o.pos - this.pos;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken());
		int M = Integer.parseInt(stNM.nextToken());
		int max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Book> plus = new PriorityQueue<Book>();
		PriorityQueue<Book> minus = new PriorityQueue<Book>();
		
		for(int idx = 0; idx < N; ++idx) {
			int book = Integer.parseInt(st.nextToken());
			max = Math.max(max, Math.abs(book));
			if(book > 0) plus.add(new Book(book));
			else minus.add(new Book(book * -1));
		}
		
		int answer = 0;
		while(!plus.isEmpty()) {
			answer += plus.poll().pos * 2;
			int cnt = 1;
			while(!plus.isEmpty() && cnt != M) {
				++cnt;
				plus.poll();
			}
		}
		while(!minus.isEmpty()) {
			answer += minus.poll().pos * 2;
			int cnt = 1;
			while(!minus.isEmpty() && cnt != M) {
				++cnt;
				minus.poll();
			}
		}
		
		bw.write(Integer.toString(answer - max));
		br.close();
		bw.close();

	}

}
