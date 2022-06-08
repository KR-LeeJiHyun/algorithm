import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_Work {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] map = new ArrayList[N];
		int[] pCnt = new int[N], times = new int[N];
		
		for(int idx = 0; idx < N;++idx) {
			map[idx] = new ArrayList<>();
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int idx = 0; idx < N;++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times[idx] = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			pCnt[idx] = M;
			if(M == 0) q.add(idx);
			for(int pIdx = 0; pIdx < M; ++pIdx) {
				int parent = Integer.parseInt(st.nextToken()) - 1;
				map[parent].add(idx);
			}
		}
		
		int[] dp = new int[N];
		int answer = 0;
		while(!q.isEmpty()) {
			int node = q.poll();
			dp[node] += times[node];
			answer = Math.max(answer, dp[node]);
			for(int idx = 0; idx < map[node].size(); ++idx) {
				int next = map[node].get(idx);
				--pCnt[next];
				dp[next] = Math.max(dp[next], dp[node]);
				if(pCnt[next] == 0) q.add(next);
			}
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
