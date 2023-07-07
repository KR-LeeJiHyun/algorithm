import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek놀이공원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken());
		int M = Integer.parseInt(stNM.nextToken());
		int R = N - M;


		if(R > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long[] arr = new long[M];
			for(int idx = 0; idx < M; ++idx) {
				arr[idx] = Long.parseLong(st.nextToken());
			}

			long left = 1;
			long right = 60_000_000_000l;
			long time = Long.MAX_VALUE;

			while(left <= right) {
				long mid = (left + right) / 2;
				long cnt = 0;
				for(int idx = 0; idx < M; ++idx) {
					cnt += mid / arr[idx];
				}

				if(cnt >= R) {
					time = Math.min(time, mid);
					right = mid - 1;
				}
				else {
					left = mid + 1;
				}
			}

			ArrayList<Integer> list = new ArrayList<>();
			int cnt = 0;

			for(int idx = 0; idx < M; ++idx) {
				cnt += (time - 1) / arr[idx];
				if(time % arr[idx] == 0) {
					list.add(idx + 1);
				}
			}

			bw.write(String.valueOf(list.get(R - cnt - 1)));
		}
		
		else {
			bw.write(String.valueOf(N));
		}
		br.close();
		bw.close();
	}

}
