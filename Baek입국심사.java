import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek입국심사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] T = new int[N];
		
		for(int idx = 0; idx < N; ++idx) {
			T[idx] = Integer.parseInt(br.readLine());
		}
		
		long answer = 1_000_000_000_000_000_000L;
		long left = 1;
		long right = 1_000_000_000_000_000_000L;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			long cnt = 0;
			for(int idx = 0; idx < N; ++idx) {
				cnt += mid / T[idx];
				if(cnt >= M) break;
			}
			
			if(cnt < M) {
				left = mid + 1;
			}
			else {
				answer = Math.min(answer, mid);
				right = mid - 1;
			}	
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

}
