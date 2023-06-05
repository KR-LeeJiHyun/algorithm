import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek공유기설치 {
	
	static int N;
	static int C;
	static int[] router;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int idx = 0;
		++idx;
		System.out.println(idx);
		
//		N = Integer.parseInt(st.nextToken());
//		C = Integer.parseInt(st.nextToken());
//		router = new int[N];
//		
//		for(int idx = 0; idx < N; ++idx) {
//			router[idx] = Integer.parseInt(br.readLine());
//		}
//		
//		Arrays.sort(router);
//		
//		int left = 1;
//		int right = router[N - 1] - router[0];
//		
//		while(left <= right) {
//			int mid = (left + right) / 2;
//			
//			if(calc(mid) < C) {
//				right = mid - 1;
//			}else {
//				left = mid + 1;
//			}
//		}
		
//		bw.write(String.valueOf(left - 1));
//		br.close();
//		bw.close();

	}

	private static int calc(int mid) {
		int cnt = 1;
		int prev = router[0];
		
		for(int idx = 1; idx < N; ++idx) {
			if(router[idx] - prev >= mid) {
				++cnt;
				prev = router[idx];
			}
		}
		
		return cnt;
	}

}
