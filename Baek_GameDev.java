import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_GameDev {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N + 1];
		int[] time = new int[N + 1], degrees = new int[N + 1];
		ArrayList<Integer>[] rule = new ArrayList[N + 1], prevs = new ArrayList[N + 1];
		for(int n = 1; n <= N; ++n) {
			rule[n] = new ArrayList<>();
			prevs[n] = new ArrayList<>();
		}
		
		for(int n = 1; n <= N; ++n) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[n] =  Integer.parseInt(st.nextToken());
			while(st.hasMoreElements()) {
				int parent = Integer.parseInt(st.nextToken());
				if(parent == -1) break;
				rule[parent].add(n);
				prevs[n].add(parent);
				++degrees[n];
			}
		}
		
		ArrayList<Integer> path = topological_sort(N, degrees, rule);
		dp[path.get(0)] = time[path.get(0)];
		
		for(int idx = 1; idx < path.size(); ++idx) {
			int current = path.get(idx);
            long max = 0;
			for(int parent : prevs[current]) {
				max = Math.max(max, dp[parent]);
			}
            dp[current] = max + time[current];
		}
		
		for(int n = 1; n <= N; ++n) {
			bw.write(dp[n] + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static ArrayList<Integer> topological_sort(int N, int[] degrees, ArrayList<Integer>[] rule) {
		ArrayList<Integer> path = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		for(int idx = 1; idx < degrees.length; ++idx) {
			if(degrees[idx] == 0) {
				q.add(idx);
			}
		}
		
		while(!q.isEmpty()) {
			int current = q.poll();
			path.add(current);
			visited[current] = true;
			for(int idx = 0; idx < rule[current].size(); ++idx) {
				int next = rule[current].get(idx);
				if(degrees[next] != 0) --degrees[next];
				if(!visited[next] && degrees[next] == 0) {
					q.add(next);
				}
			}
		}
		return path;
	}

}
