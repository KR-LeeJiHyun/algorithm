import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek세용액 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long[] w = new long[3];
		long dis = Long.MAX_VALUE;
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[N];
		for(int idx = 0; idx < N; ++idx) {
			arr[idx] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		
		for(int idx = 0; idx < N - 2; ++idx) {
			for(int sIdx = idx + 1; sIdx < N - 1; ++sIdx) {
				int left = sIdx + 1;
				int right = N - 1;
				long target = (arr[idx] + arr[sIdx]) * -1;
				int tmp = -1;
			
				while(left <= right) {
					int mid = (left + right) / 2;
					
					if(target < arr[mid]) {
						right = mid - 1;
					}
					else if(target > arr[mid]){
						left = mid + 1;
					}
					else {
						tmp = mid;
						break;
					}
				}
				
				if(tmp != -1) {
					w[0] = arr[idx];
					w[1] = arr[sIdx];
					w[2] = arr[tmp];
					break;
				}
				else {
					if(left < N && Math.abs(arr[idx] + arr[sIdx] + arr[left]) < dis) {
						w[0] = arr[idx];
						w[1] = arr[sIdx];
						w[2] = arr[left];
						dis = Math.abs(arr[idx] + arr[sIdx] + arr[left]);
					}
					if(right > sIdx && Math.abs(arr[idx] + arr[sIdx] + arr[right]) < dis) {
						w[0] = arr[idx];
						w[1] = arr[sIdx];
						w[2] = arr[right];
						dis = Math.abs(arr[idx] + arr[sIdx] + arr[right]);
					}
				}
			}
		}
		

		Arrays.sort(w);
		StringBuilder sb = new StringBuilder();
		sb.append(w[0]);
		sb.append(' ');
		sb.append(w[1]);
		sb.append(' ');
		sb.append(w[2]);
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
