import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek태상이의훈련소생활 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken());
		int M = Integer.parseInt(stNM.nextToken());
		int[] h = new int[N];
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) {
			h[idx] = Integer.parseInt(input.nextToken());
		}
		
		int[] sand = new int[N];
		while(M != 0) {
			--M;
			StringTokenizer stSand = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stSand.nextToken()) - 1;
			int end = Integer.parseInt(stSand.nextToken());
			int s = Integer.parseInt(stSand.nextToken());
			sand[start] += s;
			if(end < N) {
				sand[end] -= s;
			}
		}
		
		for(int idx = 1; idx < N; ++idx) {
			sand[idx] += sand[idx - 1];
		}
		
		StringBuilder answer = new StringBuilder();
		for(int idx = 0; idx < N; ++idx) {
			answer.append(h[idx] + sand[idx]);
			answer.append(' ');
		}
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}

}
