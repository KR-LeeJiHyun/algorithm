import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek캔디캔디 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		long M = Long.parseLong(input.nextToken());
		int N = Integer.parseInt(input.nextToken());
		long[] arr = new long[N];
		for(int idx = 0; idx < N; ++idx) {
			arr[idx] = Long.parseLong(br.readLine());
		}
		long left = 1;
		long right = 2000000000;
		long max = 0;
		long used = 0;
		while(left <= right) {
			long mid = (left + right) / 2l;
			long cnt = 0;
			for(int idx = 0; idx < N; ++idx) {
				if(arr[idx] > mid) {
					cnt += arr[idx] - mid;
				}
				if(cnt > M) {
					break;
				}
			}
			if(cnt <= M) {
				max = mid;
				used = cnt;
				right = mid - 1l;
			}
			else {
				left = mid + 1l; 
			}
		}
		
		long answer = 0;
		long mod = Long.MAX_VALUE;
		long remain = M - used;
		for(int idx = 0; idx < N; ++idx) {
			if(arr[idx] >= max) {
				if(remain > 0) {
					answer += (max - 1) * (max - 1);
					--remain;
				}
				else {
					answer += max * max;
				}
			}
			else {
				answer += arr[idx] * arr[idx];
			}
			answer %= mod;
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

}
