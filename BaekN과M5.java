import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekN과M5 {
	
	static StringBuilder answer = new StringBuilder();
	static int N;
	static int M;
	static int visited;
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(input.nextToken());
		M = Integer.parseInt(input.nextToken());
		num = new int[N];
		
		input = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) {
			num[idx] = Integer.parseInt(input.nextToken());
		}
		
		Arrays.sort(num);
		dfs(0, new int[M]);
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}

	private static void dfs(int size, int[] tmp) {
		if(size == M) {
			for(int idx = 0; idx < M; ++idx) {
				answer.append(tmp[idx]);
				answer.append(' ');
			}
			answer.append('\n');
			return;
		}
		
		for(int idx = 0; idx < N; ++idx){
			if((visited >> idx & 1) == 0) {
				int visit = 1 << idx;
				visited += visit;
				tmp[size] = num[idx];
				dfs(size + 1, tmp);
				visited -= visit;
			} 
		}
	}

}
