import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek나머지합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken());
		int M = Integer.parseInt(stNM.nextToken());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] mods = new long[M];
		long answer = 0;
		long sum = 0;
		
		for(int idx = 0; idx < N; ++idx) {
			sum += Long.parseLong(st.nextToken());
			++mods[(int)(sum % M)];
		}
		
		for(int idx = 0; idx < M; ++idx) {
			if(idx == 0) {
				answer += mods[idx];
			}
			if(mods[idx] > 1) {
				answer += mods[idx] * (mods[idx] - 1) / 2;
			}
		}
		
		
		bw.write(Long.toString(answer));
		br.close();
		bw.close();

	}

}
