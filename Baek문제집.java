import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek문제집 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(input.nextToken());
		int M = Integer.parseInt(input.nextToken());
		int[] degree = new int[N + 1];
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for(int idx = 1; idx <= N; ++idx) {
			list[idx] = new ArrayList();
		}
		for(int idx = 0; idx < M; ++idx) {
			input = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(input.nextToken());
			int v2 = Integer.parseInt(input.nextToken());
			++degree[v2];
			list[v1].add(v2);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int idx = 1; idx <= N; ++idx) {
			if(degree[idx] == 0) {
				pq.add(idx);
			} 
		}
		
		StringBuilder answer = new StringBuilder();
		while(!pq.isEmpty()) {
			int v = pq.poll();
			answer.append(v);
			answer.append(' ');
			for(int d : list[v]) {
				--degree[d];
				if(degree[d] == 0) {
					pq.add(d);
				}
			}
		}
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}

}
