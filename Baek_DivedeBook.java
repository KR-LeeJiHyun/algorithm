import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_DivedeBook{
	
	static class Book implements Comparable<Book>{
		int a;
		int b;
		
		Book(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		public int compareTo(Book o) {
			return this.b - o.b;
		}
		
		
	}
	
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		while(T > 0) {
			--T;
			StringTokenizer stNM = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stNM.nextToken());
			int M = Integer.parseInt(stNM.nextToken());
			
			PriorityQueue<Book> pq = new PriorityQueue<>();
			for(int idx = 0; idx < M; ++idx) {
				StringTokenizer stBook = new StringTokenizer(br.readLine());
				pq.add(new Book(Integer.parseInt(stBook.nextToken()), Integer.parseInt(stBook.nextToken())));
			}
			
			parent = new int[N + 2];
			for(int idx = 1; idx <= N + 1; ++idx) parent[idx] = idx;
			
			int answer = 0;
			while(!pq.isEmpty()) {
				Book current = pq.poll();
				int numA = find(current.a);
				if(current.a <= numA && numA <= current.b) {
					++answer;
					++parent[numA];
				}					
			}
			
			bw.write(String.valueOf(answer));
			bw.write('\n');
		}
		
		br.close();
		bw.close();

	}

	private static int find(int b) {
		if(parent[b] == b) return b;
		return parent[b] = find(parent[b]);
	}

}
