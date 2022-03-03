import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_EfficientHacking {

	static ArrayList<Integer>[] map;
	static int[] visited_map;
	static boolean[] visited;
	static int N, M;
	
	public static void dfs(int node) {
		visited[node] = true;
		++visited_map[node];
		for(int tmp : map[node]) if(!visited[tmp]) dfs(tmp);	
	}
	
	public static ArrayList<Integer> solution() {
		ArrayList<Integer> answer = new ArrayList();
		int max = 0;
		
		for(int idx = 0; idx < N; ++idx) {
			visited = new boolean[N];
			dfs(idx);
		}
		
		for(int tmp : visited_map) {
			if(max < tmp) max = tmp;
		}
		
		for(int idx = 0; idx < N; ++idx) {
			if(visited_map[idx] == max) answer.add(idx);
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st_MN = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st_MN.nextToken());
		M = Integer.parseInt(st_MN.nextToken());
		
		map = new ArrayList[N];
		visited_map = new int[N];
		
		for(int idx = 0; idx < N; ++idx) map[idx] = new ArrayList();
		
		for(int idx = 0; idx < M; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int child = Integer.parseInt(st.nextToken()) - 1;
			int parent = Integer.parseInt(st.nextToken()) - 1;
			map[child].add(parent);
		}
		
		ArrayList<Integer> answer = solution();
		
		for(int tmp : answer) bw.write(Integer.toString(tmp + 1) + " ");
		
		br.close();
        bw.flush();
        bw.close();
	}

}
