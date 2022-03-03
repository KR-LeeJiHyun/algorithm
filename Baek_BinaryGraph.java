import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Baek_BinaryGraph {

	static ArrayList<Integer>[] map;
	static int[] visited;
	static int K, V, E;
	static int[] COLOR = {1, 2};
	
	public static boolean solution(int node, int c_idx) {
		boolean answer = true;
		
		visited[node] = COLOR[c_idx];
		
		for(int idx : map[node]) {
			if(visited[idx] == 0) {
				if(answer) answer = solution(idx, (c_idx + 1)%2);
			}
			
			else if(visited[idx] == visited[node]) return false;
			
			else if(!answer) return answer;
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		K = Integer.parseInt(br.readLine());
		
		for(int k = 0; k < K; ++k) {
			StringTokenizer st_VE = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st_VE.nextToken());
			E = Integer.parseInt(st_VE.nextToken());
			map = new ArrayList[V + 1];
			visited = new int[V + 1];
			
			for(int idx = 1; idx < V + 1; ++idx) map[idx] = new ArrayList<>();

			for(int idx = 0; idx < E; ++idx) {
				StringTokenizer st_UV = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st_UV.nextToken()), v = Integer.parseInt(st_UV.nextToken());
				map[u].add(v);
				map[v].add(u);
			}
			
			boolean discrim = true;
			for(int idx = 1; idx < V + 1; ++idx) { 
				if(visited[idx] == 0)
				{
					discrim = solution(idx, 0);
					if(!discrim) break;
				}
			}
			
			if(discrim) bw.write("YES\n");
			else bw.write("NO\n");
		}
		
		br.close();
        bw.flush();
        bw.close();
	}

}
