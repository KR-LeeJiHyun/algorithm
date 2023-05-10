import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek두개의탑 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int sum = 0;
		
		for(int idx = 0; idx < N; ++idx) {
			arr[idx] = Integer.parseInt(br.readLine());
			sum += arr[idx];
		}
		
		int left = 0;
		int right = 0;
		int now = arr[0];
		int max = 0;
		
		while(left <= right && right < N) {
			int tmp = Math.min(now, sum - now);
			max = Math.max(max, tmp);
			
			if(now == tmp) {
				++right;
				now += arr[right];
			}
			else {
				now -= arr[left];
				++left;
			}
		}
		
		bw.write(String.valueOf(max));
		br.close();
		bw.close();
	}

	/*
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] prefix = new int[N + 1];
		
		for(int idx = 1; idx <= N; ++idx) {
			prefix[idx] = prefix[idx - 1] + Integer.parseInt(br.readLine());
		}
		
		int answer = 0;
		for(int idx = 1; idx < N; ++idx) {
			for(int sIdx = idx; sIdx < N; ++sIdx) {
				answer = Math.max(answer, Math.min(prefix[sIdx] - prefix[idx - 1], prefix[N] - (prefix[sIdx] - prefix[idx - 1])));
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
	*/

}
