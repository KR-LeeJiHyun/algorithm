import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek합이0인네정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N];
		int[] D = new int[N];
		
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[idx] = Integer.parseInt(st.nextToken());
			B[idx] = Integer.parseInt(st.nextToken());
			C[idx] = Integer.parseInt(st.nextToken());
			D[idx] = Integer.parseInt(st.nextToken());
		}
		
		int MAX = N * N;
		int[] AB = new int[MAX];
		int[] CD = new int[MAX];
		
		int nidx = 0;
		for(int fidx = 0; fidx < N; ++fidx) {
			for(int sidx = 0; sidx < N; ++sidx) {
				AB[nidx] = A[fidx] + B[sidx];
				CD[nidx++] = C[fidx] + D[sidx];
			}
		}
		
		long answer = 0;
		Arrays.sort(AB);
		Arrays.sort(CD);
		
		int left = 0;
		int right = MAX - 1;
		
		while(left < MAX && right >= 0) {
			long sum = AB[left] + CD[right];
			
			if(sum == 0) {
				int upleft = left + 1;
				int downright = right - 1;
				
				for(; upleft < MAX; ++upleft) {
					if(AB[upleft] != AB[left]) {
						break;
					}
				}
				
				for(; downright >= 0; --downright) {
					if(CD[downright] != CD[right]) {
						break;
					}
				}
				
				answer += (long)(upleft - left) * (long)(right - downright);
				left = upleft;
				right = downright;
				
			}
			else if(sum < 0) {
				++left;
			}
			else {
				--right;
			}
		}
		
		/*
		for(int idx = 0; idx < MAX; ++idx) {
			int target = AB[idx] * -1;
			int dleft = 0;
			int dright = MAX - 1;
			int d = -1;
			while(dleft <= dright) {
				int mid = (dleft + dright) / 2;
				
				if(target <= CD[mid]) {
					d = mid;
					dright = mid - 1;
				}
				else if(target > CD[mid]) {
					dleft = mid + 1;
				}
			}
			
			int uleft = 0;
			int uright = MAX - 1;
			int u = -1;
			while(uleft <= uright) {
				int mid = (uleft + uright) / 2;
				
				if(target < CD[mid]) {
					uright = mid - 1;
				}
				else if(target >= CD[mid]) {
					u = mid;
					uleft = mid + 1;
				}
			}
			
			if(u != -1 && d != -1) answer += u - d + 1;
		}
		*/
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();

	}

}
