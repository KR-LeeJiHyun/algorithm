import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Baek_WordMath {
	
	public static class Num implements Comparable<Num>{
		
		char alpha;
		int priority;
		
		public Num(char alpha, int priority) {
			this.alpha = alpha;
			this.priority = priority;
		}

		public int compareTo(Num o) {
			return o.priority - this.priority;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int ALPHA_CNT = 26;
		int N = Integer.parseInt(br.readLine());
		
		String[] words = new String[N];
		Num[] nums = new Num[ALPHA_CNT];
		
		for(int n = 0; n < N; ++n) words[n] = br.readLine();
		
		for(int idx = 0; idx < ALPHA_CNT; ++idx) nums[idx] = new Num((char)('A' + idx), 0);
		
		for(int n = 0; n < N; ++n) {
			String word = words[n];
			int len = word.length();
			for(int idx = 0; idx < len; ++idx) {
				char c = word.charAt(idx);
				nums[c - 'A'].priority += Math.pow(10, len - idx - 1);
			}
		}
		
		PriorityQueue<Num> pq = new PriorityQueue<>();
		
		for(int idx = 0; idx < ALPHA_CNT; ++idx) {
			if(nums[idx].priority != 0) pq.add(nums[idx]);
		}
		
		int number = 9, answer = 0;
		
		while(!pq.isEmpty()) answer += pq.poll().priority * number--;
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		br.close();

	}

}
