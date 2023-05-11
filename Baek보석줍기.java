import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek보석줍기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] prefix = new int[N + 1];
		int[] min = new int[N + 1];
		
		for(int idx = 1; idx <= N; ++idx) {
			prefix[idx] += prefix[idx - 1] + Integer.parseInt(br.readLine());
			min[idx] = Math.min(min[idx - 1], prefix[idx]);
		}
		
		int answer = 0;
		for(int start = M; start <= N; ++start) {
			answer = Math.max(answer, prefix[start] - min[start - M]);
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

}
