import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekK번째수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int left = 1;
		int right = 1000000000;
		int answer = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			long cnt = 0;
			for(int idx = 1; idx <= N; ++idx) {
				cnt += Math.min(N, mid / idx);
			}
			
			if(cnt >= K) {
				answer = mid;
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();

	}

}
