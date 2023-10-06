import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bae카드게임 {
	
	static int N;
	static int M;
	static int K;
	static int[] blues;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		N = Integer.parseInt(input.nextToken());
		M = Integer.parseInt(input.nextToken());
		K = Integer.parseInt(input.nextToken());
		
		blues = new int[M];
		parents = new int[M + 1];
		
		input = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < M; ++idx) {
			blues[idx] = Integer.parseInt(input.nextToken());
			parents[idx] = idx;
		}
		Arrays.sort(blues);
		input = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int idx = 0; idx < K; ++idx) {
			int red = Integer.parseInt(input.nextToken());
			int left = 0;
			int right = M - 1;
			
			while(left <= right) {
				int mid = (left + right) / 2;
				int blue = blues[mid];
				if(blue <= red) {
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
			
			int parent = find(left);
			parents[parent] = parent + 1;
			answer.append(blues[parent]);
			answer.append('\n');
		}
		
		bw.write(answer.toString());
		br.close();
		bw.close();
		
	}

	private static int find(int idx) {
		if(parents[idx] == idx) return idx;
		return parents[idx] = find(parents[idx]);
	}

}
