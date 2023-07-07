import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek냅색문제 {
	
	static int answer = 1;
	static int N;
	static int C;
	static long[] arr1;
	static long[] arr2;
	static int idx1 = 0;
	static int idx2 = 0;
	static int LEN1;
	static int LEN2;
	static long[] sub1;
	static long[] sub2;
	static int L1;
	static int L2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNC = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNC.nextToken());
		C = Integer.parseInt(stNC.nextToken());
		LEN1 = N / 2;
		LEN2 = N - LEN1;
		arr1 = new long[LEN1];
		arr2 = new long[LEN2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N / 2; ++idx) {
			arr1[idx] = Integer.parseInt(st.nextToken());
		}
		for(int idx = 0; idx < N - N / 2; ++idx) {
			arr2[idx] = Integer.parseInt(st.nextToken());
		}
		
		L1 = (int)Math.pow(2, LEN1);
		sub1 = new long[L1];
		L2 = (int)Math.pow(2, LEN2);
		sub2 = new long[L2];
		
		makeSub(0, 0, 0);
		makeSub(0, 0, 1);
		Arrays.sort(sub1);
		Arrays.sort(sub2);
		
		for(int idx = 1; idx < L2; ++idx) {
			if(C <= sub2[idx]) continue;
			int left = 1;
			int right = L1 - 1;
			long target = C - sub2[idx];
			while(left <= right) {
				int mid = (left + right) / 2;
				
				if(sub1[mid] <= target) {
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
			
			answer += left - 1;
		}
		
		bw.write(String.valueOf(answer - 2));
		br.close();
		bw.close();
	}

	private static void makeSub(int idx, long l, int mode) {
		if(mode == 0 && idx == LEN1) {
			sub1[idx1++] = l;
			if(l <= C) ++answer;
			return;
		}
		else if(mode == 1 && idx == LEN2){
			sub2[idx2++] = l;
			if(l <= C) ++answer;
			return;
		}
		else {
			makeSub(idx + 1, l, mode);
			if(mode == 0) makeSub(idx + 1, l + arr1[idx], mode);
			else makeSub(idx + 1, l + arr2[idx], mode);
		}
	}

}
