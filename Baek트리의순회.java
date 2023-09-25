import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek트리의순회 {
	static int N;
	static int[] in;
	static int[] post;
	static boolean[] visited; 
	static StringBuilder answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		in = new int[N];
		post = new int[N];
		visited = new boolean[N + 1];
		StringTokenizer input = new StringTokenizer(br.readLine());
		StringTokenizer input2 = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) {
			in[idx] = Integer.parseInt(input.nextToken());
			post[idx] = Integer.parseInt(input2.nextToken());
		}
		answer = new StringBuilder();
		makeTree(0, N - 1);
		
 		bw.write(answer.toString());
		br.close();
		bw.close();
	}

	private static void makeTree(int left, int right) {
		if(left > right) return;
		
		int root = post[right];
		answer.append(root);
		answer.append(' ');
		
		if(left == right) return;
		
		Arrays.fill(visited, false);
		int stand = -1;
		for(int idx = 0; idx < N; ++idx) {
			if(in[idx] == root) {
				break;
			}
			visited[in[idx]] = true;
		}
		for(int idx = right - 1; idx >= 0; --idx) {
			if(visited[post[idx]]) {
				//왼쪽 서브트리의 루트
				stand = idx;
				break;
			}
		}
		
		//왼쪽
		makeTree(left, stand);
		//오른쪽
		makeTree(stand + 1, right - 1);
	}

}
