import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek반도체설계 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] lis = new int[N + 1];
		Arrays.fill(lis, Integer.MAX_VALUE);
		lis[0] = 0;
		int answer = 0;
		for(int idx = 0; idx < N; ++idx) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num > lis[answer]) {
				lis[++answer] = num;
			}
			else {
				int cIdx = -Arrays.binarySearch(lis, num) - 1;
				lis[cIdx] = num;
			}
		}

		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

	/*
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] lis = new int[N + 1];
		int answer = 0;
		for(int idx = 0; idx < N; ++idx) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num > lis[answer]) {
				lis[++answer] = num;
			}
			else {
				int left = 0;
				int right = answer;
				int tmp = -1;
				while(left <= right) {
					int mid = (left + right) / 2;
					if(lis[mid] >= num) {
						tmp = mid;
						right = mid - 1;
					}
					else {
						left = mid + 1;
					}
				}
				
				lis[tmp] = num; 
			}
		}

		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
	*/
	/*
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		int answer = 0;
		for(int idx = 0; idx < N; ++idx) {
			arr[idx] = Integer.parseInt(st.nextToken());
			dp[idx] = 1;
			int max = 0;
			for(int sIdx = 0; sIdx < idx; ++sIdx) {
				if(arr[sIdx] < arr[idx]) {
					max = Math.max(max, dp[sIdx]);
				}
			}
			dp[idx] += max;
			answer = Math.max(answer, dp[idx]);
		}

		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
	*/

}
