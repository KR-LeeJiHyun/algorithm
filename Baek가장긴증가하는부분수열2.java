import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek가장긴증가하는부분수열2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] lis = new int[N];
		for(int idx = 0; idx < N; ++idx) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}
		
		lis[0] = arr[0];
		int answer = 1;
		
		for(int idx = 0; idx < N; ++idx) {
			if(arr[idx] > lis[answer - 1]) {
				lis[answer++] = arr[idx];
			}
			else {
				int low = 0;
				int high = answer - 1;
				
				while(low < high) {
					int mid = (low + high) / 2;
					if(lis[mid] < arr[idx]) {
						low = mid + 1;
					}
					else {
						high = mid;
					}
				}
				
				lis[low] = arr[idx];
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();

	}

}
