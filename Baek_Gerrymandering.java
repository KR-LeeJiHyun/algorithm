import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Baek_Gerrymandering {

	static ArrayList<Integer>[] map;
	static ArrayList<Integer> pop_map;
	static boolean[] visited;
	static int M, N, pop_sum, answer = 10000;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st_N = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st_N.nextToken()) + 1;
		map = new ArrayList[N];
		
		for(int idx = 1; idx < N; ++idx) {
			map[idx] = new ArrayList();
		}
		
		pop_map = new ArrayList<>();
		pop_map.add(-1);
		pop_sum = 0;
		StringTokenizer stPop = new StringTokenizer(br.readLine());
		for(int idx = 1; idx < N; ++idx) {
			pop_map.add(Integer.parseInt(stPop.nextToken()));
			pop_sum += pop_map.get(idx);
		}
		
		for(int idx = 1; idx < N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			while(st.hasMoreElements()) map[idx].add(Integer.parseInt(st.nextToken()));
		}
		
		solution();
		if(answer == 10000) answer = -1; 
		bw.write(Integer.toString(answer));
		
		br.close();
        bw.flush();
        bw.close();
	}
	
	public static void solution() {
		for(int idx = 1; idx < N - 1; ++idx) {
			visited = new boolean[N];
			make_combine(1, new ArrayList<Integer>(), idx, 0);
		}
	}
	
	public static void make_combine(int node, ArrayList<Integer> path, int size, int pop) {	
		path.add(node);
		pop += pop_map.get(node);
		visited[node] = true;
		if(path.size() == size) {
			if(dfs(1, path)) {
				for(int idx = 2; idx < N; ++idx) {
					if(!visited[idx]) path.add(idx);
				}
				if(dfs(path.get(0), path)) {
					answer = Math.min(answer, Math.abs(pop_sum - (2 * pop)));
				}
			}	
			visited[node] = false;
			return;
		}
		for(int next = node + 1; next < N; ++next) {
			if(!visited[next]) make_combine(next, (ArrayList<Integer>)path.clone(), size, pop);
		}
		visited[node] = false;
	}
	
	public static boolean dfs(int node, ArrayList<Integer> path) {
		path.remove(path.indexOf(node));
		for(int next : map[node]) {
			if(path.contains(next)) dfs(next, path);
		}
		
		if(path.isEmpty()) return true;
		return false;
	}
}
