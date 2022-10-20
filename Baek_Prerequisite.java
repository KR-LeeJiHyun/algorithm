import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_Prerequisite {
	
	static class Subject {
		int num;
		int semester;
		
		Subject(int num, int semester) {
			this.num = num;
			this.semester = semester;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken());
		int M = Integer.parseInt(stNM.nextToken());
		
		int[] dp = new int[N + 1];
		int[] degree = new int[N + 1];
		ArrayList<Integer>[] map = new ArrayList[N + 1];
		
		for(int idx = 1; idx <= N; ++idx) map[idx] = new ArrayList<>();
		
		for(int m = 0; m < M; ++m) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int pre = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			++degree[next];
			map[pre].add(next);
		}
		
		Queue<Subject> q = new LinkedList<>();
		for(int idx = 1; idx <= N; ++idx) {
			if(degree[idx] == 0) q.add(new Subject(idx, 1));
		}
		
		while(!q.isEmpty()) {
			Subject current = q.poll();
			dp[current.num] = current.semester;
			
			for(int idx = 0; idx < map[current.num].size(); ++idx) {
				int next = map[current.num].get(idx);
				--degree[next];
				if(degree[next] == 0) q.add(new Subject(next, current.semester + 1));
			}
		}
		
		StringBuilder answer = new StringBuilder();
		for(int idx = 1; idx <= N; ++idx) {
			answer.append(dp[idx]);
			answer.append(' ');
		}
		
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();

	}

}
