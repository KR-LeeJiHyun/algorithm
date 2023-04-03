import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaeK부분합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNS = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNS.nextToken());
		int S = Integer.parseInt(stNS.nextToken());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] seq = new int[N];
		int answer = Integer.MAX_VALUE;
		
		for(int idx = 0; idx < N; ++idx) {
			seq[idx] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int len = 0;
		int end = 0;
		
		for(int start = 0; start < N; ++start) {
			while(sum < S && end < N) {
				sum += seq[end++];
				++len;
			}
			if(S <= sum) {
				answer = Math.min(answer, len);
			}
			sum -= seq[start];
			--len;
		}
		
		
		if(answer == Integer.MAX_VALUE) {
			answer = 0;
		}
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.close();
	}

}
