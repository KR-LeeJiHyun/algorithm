import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek두용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int w1 = 0; 
		int w2 = 0;
		int dis = Integer.MAX_VALUE;
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int idx = 0; idx < N; ++idx) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int left = 0;
		int right = N - 1;
		while(left < right) {
			int lArr = arr[left];
			int rArr = arr[right];
			int sum = lArr + rArr;
			
			if(Math.abs(sum) < dis) {
				w1 = lArr;
				w2 = rArr;
				dis = Math.abs(sum);
			}
			
			if(sum == 0) {
				break;
			}
			
			if(sum < 0) {
				++left;
			}
			else {
				--right;
			}
		}
		
//		for(int idx = 0; idx < N - 1; ++idx) {
//			int left = idx + 1;
//			int right = N - 1;
//			int target = arr[idx] * -1;
//			int tmp = -1;
//		
//			while(left <= right) {
//				int mid = (left + right) / 2;
//				
//				if(target < arr[mid]) {
//					right = mid - 1;
//				}
//				else if(target > arr[mid]){
//					left = mid + 1;
//				}
//				else {
//					tmp = mid;
//					break;
//				}
//			}
//			
//			if(tmp != -1) {
//				w1 = arr[idx];
//				w2 = arr[tmp];
//				break;
//			}
//			else {
//				if(left < N && Math.abs(arr[idx] + arr[left]) < dis) {
//					w1 = arr[idx];
//					w2 = arr[left];
//					dis = Math.abs(arr[idx] + arr[left]);
//				}
//				if(right > idx && Math.abs(arr[idx] + arr[right]) < dis) {
//					w1 = arr[idx];
//					w2 = arr[right];
//					dis = Math.abs(arr[idx] + arr[right]);
//				}
//			}
//		}

		StringBuilder sb = new StringBuilder();
		sb.append(w1);
		sb.append(' ');
		sb.append(w2);
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}
