import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(input.nextToken());
		int M = Integer.parseInt(input.nextToken());
		int[] degree = new int[N + 1];
		ArrayList<Integer>[] map = new ArrayList[N + 1];
		for(int idx = 1; idx <= N; ++idx) {
			map[idx] = new ArrayList();
		}
		
		for(int idx = 0; idx < M; ++idx) {
			input = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(input.nextToken());
			int u = Integer.parseInt(input.nextToken());
			++degree[u];
			map[v].add(u);
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int idx = 1; idx <= N; ++idx) {
			if(degree[idx] == 0) {
				q.add(idx);
			}
		}
		
		StringBuilder answer = new StringBuilder();
		while(!q.isEmpty()) {
			int current = q.poll();
			answer.append(current);
			answer.append(' ');
			
			for(int next : map[current]) {
				--degree[next];
				if(degree[next] == 0) {
					q.add(next);
				}
			}
		}
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}
}
