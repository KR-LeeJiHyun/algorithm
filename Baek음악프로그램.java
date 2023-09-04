import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek음악프로그램 {

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
			int cnt = Integer.parseInt(input.nextToken());
			int prev = 0;
			while(cnt > 0) {
				--cnt;
				int current = Integer.parseInt(input.nextToken());
				if(prev != 0) {
					map[prev].add(current);
					++degree[current];
				}
				prev = current;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int idx = 1; idx <= N; ++idx) {
			if(degree[idx] == 0) {
				q.add(idx);
			}
		}
		
		StringBuilder answer = new StringBuilder();
		int cnt = 0;
		while(!q.isEmpty()) {
			++cnt;
			int current = q.poll();
			answer.append(current);
			answer.append('\n');
			
			for(int next : map[current]) {
				--degree[next];
				if(degree[next] == 0) {
					q.add(next);
				}
			}
		}
		
		if(cnt == N) {
			bw.write(answer.toString());
		}
		else {
			bw.write('0');
		}
		br.close();
		bw.close();
	}

}
