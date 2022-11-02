import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_RoadPavement {

	static class Node implements Comparable<Node>{

		int idx;
		int cnt;
		long cost;

		Node(int idx, int cnt, long cost) {
			this.idx = idx;
			this.cnt = cnt;
			this.cost = cost;
		}

		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stNMK = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNMK.nextToken());
		int M = Integer.parseInt(stNMK.nextToken());
		int K = Integer.parseInt(stNMK.nextToken());

		long[][] dp = new long[N + 1][K + 1];
		ArrayList<Node>[] map = new ArrayList[N + 1];

		for(int idx = 0; idx <= N; ++idx) Arrays.fill(dp[idx], Long.MAX_VALUE);
		dp[1][0] = 0;

		for(int idx = 1; idx <= N; ++idx) map[idx] = new ArrayList<>();

		for(int idx = 0; idx < M; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			long cost = Long.parseLong(st.nextToken());

			map[v].add(new Node(w, 0, cost));
			map[w].add(new Node(v, 0, cost));
		}

		//다익스트라
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0, 0));

		while(!pq.isEmpty()) {
			Node current = pq.poll();
			if(current.cost > dp[current.idx][current.cnt]) continue;

			for(int idx = 0; idx < map[current.idx].size(); ++idx) {
				Node next = map[current.idx].get(idx);
				if(current.cnt < K && dp[next.idx][current.cnt + 1] > dp[current.idx][current.cnt]) {
					dp[next.idx][current.cnt + 1] = dp[current.idx][current.cnt];
					pq.add(new Node(next.idx, current.cnt + 1, dp[next.idx][current.cnt + 1]));
				}

				if(dp[next.idx][current.cnt] > dp[current.idx][current.cnt] + next.cost) {
					dp[next.idx][current.cnt] = dp[current.idx][current.cnt] + next.cost;
					pq.add(new Node(next.idx, current.cnt, dp[next.idx][current.cnt]));
				}
			}
		}
		
		long answer = Long.MAX_VALUE;
		for(int idx = 0; idx <= K; ++idx) answer = Math.min(answer, dp[N][idx]);

		bw.write(Long.toString(answer));
		br.close();
		bw.flush();
		bw.close();

	}
}
