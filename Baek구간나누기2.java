import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek구간나누기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken());
		int M = Integer.parseInt(stNM.nextToken());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 9999;
		int answer = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			int section = 1;
			int min = arr[0];
			int max = arr[0];
			for(int idx = 1; idx < N; ++idx) {
				min = Math.min(min, arr[idx]);
				max = Math.max(max, arr[idx]);
				if(max - min > mid) {
					++section;
					min = arr[idx];
					max = arr[idx];
				}
			}
			
			if(section <= M) {
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
