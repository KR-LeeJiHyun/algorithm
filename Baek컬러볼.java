import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek컬러볼 {
	
	static class Ball implements Comparable<Ball>{
		int idx;
		int color;
		int size;
		
		Ball(int idx, int color, int size) {
			this.idx = idx;
			this.color = color;
			this.size = size;
		}
		
		public int compareTo(Ball o) {
			if(this.size == o.size) {
				return this.color - o.color;
			}
			return this.size - o.size;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] answer = new int[N];
		int[] colors = new int[N];
		int[] sizes = new int[2001];
		int preIdx = -1;
		int preColor = 0;
		int preSize = 0;
		int sum = 0;
		PriorityQueue<Ball> pq = new PriorityQueue<>();
		
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken()) - 1;
			int size = Integer.parseInt(st.nextToken());
			pq.add(new Ball(idx, color, size));
		}
		
		while(!pq.isEmpty()) {
			Ball current = pq.poll();
			answer[current.idx] = sum - colors[current.color] - sizes[current.size];
			if(current.color == preColor && current.size == preSize) {
				answer[current.idx] = answer[preIdx];
			}
			
			preIdx = current.idx;
			preColor = current.color;
			preSize = current.size;
			sum += current.size;
			colors[current.color] += current.size;
			sizes[current.size] += current.size;
		}
		
		StringBuilder ans = new StringBuilder();
		for(int idx = 0; idx < N; ++idx) {
			ans.append(answer[idx]);
			ans.append(System.lineSeparator());
		}
		
		bw.write(ans.toString());
		br.close();
		bw.close();
	}

}
