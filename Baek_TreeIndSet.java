import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_TreeIndSet {
	
	static final int INVOLVE = 0, EXCEPT = 1;
	static int n;
	static int[] weights;
	static int[][] dp;
	static ArrayList<Integer>[][] list;
	static ArrayList<Integer>[] map;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		weights = new int[n];
		dp = new int[n][2];
		map = new ArrayList[n];
		list = new ArrayList[n][2];
		
		StringTokenizer stWeights = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < n; ++idx) {
			map[idx] = new ArrayList<>();
			weights[idx] = Integer.parseInt(stWeights.nextToken());
		}
		
		for(int idx = 0; idx < n - 1; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken()) - 1;
			int second = Integer.parseInt(st.nextToken()) - 1;
			map[first].add(second);
			map[second].add(first);
		}
		
		dfs(0);
		StringBuilder sb = new StringBuilder();
		if(dp[0][INVOLVE] < dp[0][EXCEPT]) {
			Collections.sort(list[0][EXCEPT]);
			sb.append(dp[0][EXCEPT]);
			sb.append('\n');
			for(int idx = 0; idx < list[0][EXCEPT].size(); ++idx) {
				sb.append(list[0][EXCEPT].get(idx) + 1);
				sb.append(' ');
			}
		}
		else {
			Collections.sort(list[0][INVOLVE]);
			sb.append(dp[0][INVOLVE]);
			sb.append('\n');
			for(int idx = 0; idx < list[0][INVOLVE].size(); ++idx) {
				sb.append(list[0][INVOLVE].get(idx) + 1);
				sb.append(' ');
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
		
	}

	private static void dfs(int node) {
		visited[node] = true;
		dp[node][INVOLVE] = weights[node];
		list[node][INVOLVE] = new ArrayList<>();
		list[node][EXCEPT] = new ArrayList<>();
		list[node][INVOLVE].add(node);
		for(int idx = 0; idx < map[node].size(); ++idx) {
			int next = map[node].get(idx);
			if(!visited[next]) {
				dfs(next);
				dp[node][INVOLVE] += dp[next][EXCEPT];
				list[node][INVOLVE].addAll(list[next][EXCEPT]);
				if(dp[next][INVOLVE] < dp[next][EXCEPT]) {
					dp[node][EXCEPT] += dp[next][EXCEPT];
					list[node][EXCEPT].addAll(list[next][EXCEPT]);
				}
				else {
					dp[node][EXCEPT] += dp[next][INVOLVE];
					list[node][EXCEPT].addAll(list[next][INVOLVE]);
				}
			}
		}
	}

}
