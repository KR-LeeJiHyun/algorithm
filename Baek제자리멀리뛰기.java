import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek제자리멀리뛰기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] islands = new int[n + 1];
		islands[n] = d;
		for(int idx = 0; idx < n; ++idx) {
			islands[idx] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(islands);
		int answer = 0;
		int left = 0;
		int right = d;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			int prev = 0;
			int cnt = 0;
			for(int idx = 0; idx <= n; ++idx) {
				if(islands[idx] - prev < mid) {
					++cnt;
				}
				else {
					prev = islands[idx];
				}
				if(cnt > m) {
					break;
				}
			}
			
			if(cnt > m) {
				right = mid - 1;
			}
			else {
				answer = mid;
				left = mid + 1;
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

}
