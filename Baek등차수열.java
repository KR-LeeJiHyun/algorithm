import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baek등차수열 {
	
	static int N;
	static int[] arr;
	static int[][] dp;
	static int answer = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N][N];
		for(int idx = 0; idx < N; ++idx) {
			arr[idx] = Integer.parseInt(br.readLine());
			dp[idx][idx] = 1;
		}
		Arrays.sort(arr);
		
		for(int idx = 0; idx < N - 1; ++idx) {
			for(int sIdx = idx + 1; sIdx < N; ++sIdx) {
				if(dp[idx][sIdx] == 0) {
					make(idx, sIdx, -1);
				}
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

	private static void make(int idx, int sIdx, int mid) {
		int target = 0;
		if(mid == -1) {
			dp[idx][sIdx] = Math.max(dp[idx][sIdx], 2);
			target = arr[sIdx] * 2 - arr[idx];
		}
		else {
			dp[idx][sIdx] = Math.max(dp[idx][sIdx], dp[idx][mid] + 1);
			target = arr[sIdx] * 2 - arr[mid];
		}
		int fIdx = binaySearch(target, sIdx + 1);
		if(fIdx > -1) {
			make(idx, fIdx, sIdx);
		}
		
		answer = Math.max(answer, dp[idx][sIdx]);
	}

	private static int binaySearch(int target, int left) {
		int right = N - 1;
		int result = -1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(arr[mid] == target) {
				right = mid - 1;
				result = mid;
			}
			else if(arr[mid] > target) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		return result;
	}

}
