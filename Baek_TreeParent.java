import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Baek_TreeParent {

	static ArrayList<Integer>[] map;
	static boolean [] visited;
	static int [] parent;
	static int N;

	public static void solution(int node) {

		visited[node] = true;

		for(int ele : map[node]) {
			if(!visited[ele]) {
				parent[ele] = node + 1;
				solution(ele);
			}
		}
	}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String sN = br.readLine();

		N = Integer.parseInt(sN);

		parent = new int[N];
		visited = new boolean[N];
		map = new ArrayList[N];
		for(int idx = 0; idx < N; ++idx) map[idx] = new ArrayList<Integer>();
		
		for(int idx = 0; idx < N - 1; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken()) - 1, second = Integer.parseInt(st.nextToken()) - 1;
			map[first].add(second);
			map[second].add(first);
		}

		solution(0);

		for(int idx = 1; idx < N; ++idx) bw.write(parent[idx] + "\n");

		br.close();
		bw.flush();
		bw.close();
	}

}
