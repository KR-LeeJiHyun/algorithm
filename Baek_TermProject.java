import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_TermProject {
	
	static int T, N;
	static int[] map;
	static boolean[] visited, cycle_visited;
	
	static public int dfs(int node, int count) {
		int next_node = map[node];
		visited[node] = true;
		
		if(!visited[next_node]) {
			count = dfs(next_node, ++count);
		}
		else {
			if(!cycle_visited[next_node]) {
				cycle_visited[next_node] = true;
				count = dfs(next_node, --count);
			}
		}
		
		cycle_visited[node] = true;
		return count;
	}
	
	public static int solution() {
		int answer = 0;
		
		for(int idx = 0; idx < N; ++idx) {
			if(!visited[idx]) answer += dfs(idx, 1);
		}
		
		return answer;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		
		for(int cnt = 0; cnt < T; ++cnt) {
			N = Integer.parseInt(br.readLine());
			map = new int[N];
			visited = new boolean[N];
			cycle_visited = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int idx = 0; idx < N; ++idx) map[idx] = Integer.parseInt(st.nextToken()) - 1;
			bw.write(Integer.toString(solution()) + "\n");
		}
		
		br.close();
        bw.flush();
        bw.close();
	}

}
