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
	static int[] index; 
	static StringBuilder answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		in = new int[N];
		post = new int[N];
		index = new int[N + 1];
		StringTokenizer input = new StringTokenizer(br.readLine());
		StringTokenizer input2 = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) {
			index[in[idx] = Integer.parseInt(input.nextToken())] = idx;
			post[idx] = Integer.parseInt(input2.nextToken());
		}
		answer = new StringBuilder();
		makeTree(0, N - 1, 0, N - 1);
		
 		bw.write(answer.toString());
		br.close();
		bw.close();
	}

	private static void makeTree(int is, int ie, int ps, int pe) {
		if(is > ie) return;
		int root = post[pe];
		answer.append(root);
		answer.append(' ');
		if(is == ie) return;
		int size = index[root] - is;
		makeTree(is, is + size - 1, ps, ps + size - 1);
		makeTree(index[root] + 1, ie, ps + size, pe - 1);
	}

}
