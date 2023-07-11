import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek휴게소세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNML = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNML.nextToken());
		int M = Integer.parseInt(stNML.nextToken());
		int L = Integer.parseInt(stNML.nextToken());
		
		int[] rests = new int[N + 2];
		rests[N + 1] = L;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 1; idx <= N; ++idx) {
			rests[idx] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(rests);
		int answer = Integer.MAX_VALUE;
		int left = 1;
		int right = L;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			for(int idx = 0; idx <= N; ++idx) {
				if(cnt > M) break;
				int dis = rests[idx + 1] - rests[idx];
				if(dis > mid) {
					cnt += (dis - 1) / mid;
				}
			}
			
			if(cnt <= M) {
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
