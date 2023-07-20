import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek숫자구슬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken());
		int M = Integer.parseInt(stNM.nextToken());
		
		int[] arr = new int[N];
		ArrayList<Integer> cnts = new ArrayList();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		for(int idx = 0; idx < N; ++idx) {
			arr[idx] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[idx]);
		}
		
		int left = max;
		int right = 30000;
		int answer = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			int section = 1;
			int sum = arr[0];
			ArrayList<Integer> tmp = new ArrayList<>();
			int cnt = 1;
			for(int idx = 1; idx < N; ++idx) {
				if(section > M) {
					break;
				}
				sum += arr[idx];

				if(sum > mid) {
					++section;
					sum = arr[idx];
					tmp.add(cnt);
					cnt = 0;
				}
				++cnt;
			}
			
			if(section <= M) {
				answer = mid;
				cnts = tmp;
				cnts.add(cnt);
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		int i = 0;
		while(cnts.size() != M) {
			if(cnts.get(i) == 1) {
				++i;
			}
			else {
				int cnt = cnts.get(i);
				cnts.remove(i);
				cnts.add(i, 1);
				cnts.add(i, cnt - 1);
			}
		}
		
		bw.write(String.valueOf(answer));
		bw.write('\n');
		bw.write(String.valueOf(cnts.get(0)));
		for(int idx = 1; idx < M; ++idx) {
			bw.write(' ');
			bw.write(String.valueOf(cnts.get(idx)));
		}
		br.close();
		bw.close();

	}

}
