import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_통나무자르기 {
	
	static int L;
	static int K;
	static int C;
	static int[] cutting;
	static int max;
	static int first;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		L = Integer.parseInt(input.nextToken());
		K = Integer.parseInt(input.nextToken());
		C = Integer.parseInt(input.nextToken());
		cutting = new int[K];
		
		input = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < K; ++idx) {
			cutting[idx] = Integer.parseInt(input.nextToken());
		}
		Arrays.sort(cutting);
		
		int left = 1;
		int right = L;
		max = L;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(isPossible(L, mid, Math.min(K, C))) {
				max = mid;
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		StringBuilder answer = new StringBuilder();
		answer.append(max);
		answer.append(' ');
		answer.append(first);
		bw.write(answer.toString());
		br.close();
		bw.close();
	}

	private static boolean isPossible(int start, int limit, int cnt) {
		if(start <= limit) {
			if(cnt != 0) {
				first = cutting[0];
			}
			else {
				first = start;
			}
			return true;
		}
		else if(cnt == 0){
			return false;
		}
		
		int fidx = Arrays.binarySearch(cutting, start - limit);
		if(fidx < 0) {
			fidx = -(fidx + 1);
		}
		
		if(fidx == K || cutting[fidx] >= start) {
			return false;
		}
		else {
			return isPossible(cutting[fidx], limit, cnt - 1);
		}
	}

}
