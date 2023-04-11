import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek꿀따기 {

	static int[] arr;
	static int[] preSum;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		preSum = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		preSum[0] = arr[0];
		for(int idx = 1; idx < N; ++idx) {
			arr[idx] = Integer.parseInt(st.nextToken());
			preSum[idx] = preSum[idx - 1] + arr[idx];
		}

		int answer = 0;
		
		//젤빠른 풀이 304ms
		for(int idx = 1; idx < N - 1; ++idx) {
			answer = Math.max(answer, preSum[N - 1] - arr[0] - arr[idx] + preSum[N - 1] - preSum[idx]);
			answer = Math.max(answer, preSum[N - 1] - arr[N - 1] - arr[idx] + preSum[idx - 1]);
			answer = Math.max(answer, preSum[idx] - arr[0] + preSum[N - 2] - preSum[idx - 1]);
		} 
		
		/*
		//첫번째 풀이 336ms
		answer = Math.max(answer, calcLeft(0, N - 1));
		answer = Math.max(answer, calc(0, N - 1, N / 2));
		answer = Math.max(answer, calcRight(N - 1, 0));
		*/
		
		/*
		//두번째 풀이 344ms
		if(N != 3) {
			answer = Math.max(answer, calcLeft(0, N - 1));
			answer = Math.max(answer, calcRight(N - 1, 0));
		}
		else {
			answer = Math.max(arr[0], Math.max(arr[1], arr[2])) * 2;
		}
		*/


		bw.write(Integer.toString(answer));
		br.close();
		bw.close();

	}

	private static int calc(int left, int right, int target) {
		int result = 0;
		
		if(left < target) {
			result += preSum[target] - preSum[left];
		}

		else if(left > target) {
			result += preSum[left - 1];
			if(target - 1 > 0) {
				result -= preSum[target - 1];
			}
		}

		if(right < target) {
			result += preSum[target] - preSum[right];
		}

		else if(right > target) {
			result += preSum[right - 1];
			if(target - 1 > -1) {
				result -= preSum[target - 1];
			}
		}

		if(right < target) {
			result -= arr[right];
		}

		if(target < left) {
			result -= arr[left];
		}
		
		return result;
	}

	private static int calcLeft(int left, int target) {
		int result = 0;
		for(int right = left + 1; right < target; ++right) {
			result = Math.max(result, calc(left, right, target));	
		}
		return result;
	}

	private static int calcRight(int right, int target) {
		int result = 0;
		for(int left = right - 1; left > target; --left) {
			result = Math.max(result, calc(left, right, target));	
		}
		return result;
	}
}
