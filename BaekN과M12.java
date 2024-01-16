import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekN과M12 {

	static StringBuilder answer = new StringBuilder();
	static int N;
	static int M;
	static ArrayList<Integer> num;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer input = new StringTokenizer(br.readLine());

		N = Integer.parseInt(input.nextToken());
		M = Integer.parseInt(input.nextToken());
		num = new ArrayList<>();
		visited = new boolean[10001];

		input = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) {
			int n = Integer.parseInt(input.nextToken());
			if(!visited[n]) {
				visited[n] = true;
				num.add(n);
			}
		}

		Collections.sort(num);
		dfs(0, 0, new int[M]);

		bw.write(answer.toString());
		br.close();
		bw.close();
	}

	private static void dfs(int size, int start, int[] tmp) {
		if(size == M) {
			for(int idx = 0; idx < M; ++idx) {
				answer.append(tmp[idx]);
				answer.append(' ');
			}
			answer.append('\n');
			return;
		}

		for(int idx = start; idx < num.size(); ++idx){
			tmp[size] = num.get(idx);
			dfs(size + 1, idx, tmp);
		}
	}

}
