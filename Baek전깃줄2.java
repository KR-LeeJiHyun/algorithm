import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek전깃줄2 {
	
	static class Line implements Comparable<Line>{
		int a;
		int b;
		
		public Line(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Line o) {
			return this.b - o.b;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		ArrayList<Integer> list = new ArrayList();
		ArrayList<Integer>[] index = new ArrayList[N];
		int[] i = new int[500001];
		boolean[] visited = new boolean[500001];
		Arrays.fill(visited, true);
		PriorityQueue<Line> pq = new PriorityQueue<>();
		for(int idx = 0; idx < N; ++idx) {
			index[idx] = new ArrayList<>();
			StringTokenizer input = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(input.nextToken());
			int b = Integer.parseInt(input.nextToken());
			i[a] = b;
			visited[a] = false;
			max = Math.max(max, a);
			pq.add(new Line(a, b));
		}
		
		Line f = pq.poll();
		list.add(f.a);
		index[0].add(f.a);
		int len = 1;
		while(!pq.isEmpty()) {
			Line c = pq.poll();
			if(list.get(len - 1) < c.a) {
				list.add(c.a);
				index[len].add(c.a);
				++len;
			}
			else {
				int fIdx = Collections.binarySearch(list, c.a);
				if(fIdx < 0) {
					fIdx = -fIdx - 1;
				}
				index[fIdx].add(c.a);
				list.set(fIdx, c.a);
			}
		}
		
		int next = index[len - 1].get(index[len - 1].size() - 1);
		visited[next] = true;
		for(int idx = len - 2; idx >= 0; --idx) {
			int sIdx = index[idx].size() - 1;
			int current = index[idx].get(sIdx);
			while(i[current] > i[next]) {
				current = index[idx].get(--sIdx);
			}
			next = current;
			visited[next] = true;
		}
		
		bw.write(String.valueOf(N - len));
		bw.write('\n');
		for(int idx = 1; idx <= max; ++idx) {
			if(!visited[idx]) {
				bw.write(String.valueOf(idx));
				bw.write('\n');
			}
		}
		br.close();
		bw.close();
	}

}
