import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Baek_ABCDE {

	static ArrayList<Integer>[] map;
	static boolean [] visited;
	static int M, N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st_MN = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st_MN.nextToken());
		M = Integer.parseInt(st_MN.nextToken());
		
		map = new ArrayList[N];
		
		for(int idx = 0; idx < N; ++idx) {
			map[idx] = new ArrayList();
		}
		
		for(int idx = 0; idx < M; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			map[a].add(b);
			map[b].add(a);
		}
		
		
		bw.write(Integer.toString(solution()));
		
		br.close();
        bw.flush();
        bw.close();
	}
	
	public static int solution() {
		int answer = 0;
		
		for(int idx = 0; idx < N; ++idx) {
			visited = new boolean[N];
			answer = dfs(idx, 1);
			if(answer == 1) return answer;
		}
		
		return answer;
	}

	public static int dfs(int node, int dep) {
		visited[node] = true;
		int answer = 1;
		if(dep == 5) return answer;
		
		answer = 0;
		for(int tmp : map[node]) {
			if(!visited[tmp]) answer = dfs(tmp, dep + 1);
			if(answer == 1) return answer;
		}
		
		return answer;
	}
}
