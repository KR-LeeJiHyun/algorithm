import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Baek_TreeDiameter {
	
	static HashMap<Integer, Integer>[] map;
	static boolean[] visited;
	static int N, longest = 0, max = 0;
	
	public static void dfs(int node, int sum) {
		visited[node] = true;
		
		int tmp_sum = sum;
		if(sum > max) {
			max = sum;
			longest = node;
		}
		
		for(int idx : map[node].keySet()) {
			int dis = map[node].get(idx);
			if(dis != 0) {
				if(!visited[idx]) dfs(idx, tmp_sum + dis);
			}
		}
	}
	
	public static int solution() {
		
		if(N == 1) return 0;
		visited = new boolean[N];
		dfs(1, 0);
		
		visited = new boolean[N];
		dfs(longest, 0);
		
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		map = new HashMap[N];
		
		for(int row = 0; row < N; ++row) map[row] = new HashMap<>();
		
		for(int row = 0; row < N - 1; ++row) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken()) - 1, u = Integer.parseInt(st.nextToken()) - 1, dis = Integer.parseInt(st.nextToken());
			map[v].put(u, dis);
			map[u].put(v, dis);
		}
		
		bw.write(Integer.toString(solution()) + "\n");
		
		br.close();
        bw.flush();
        bw.close();
	}

}
