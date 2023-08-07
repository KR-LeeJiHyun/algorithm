import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek모자이크 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		final int LIMIT = Integer.parseInt(br.readLine());
		final int CNT = Integer.parseInt(br.readLine());
		int[] cols = new int[CNT];
		int left = 0;
		int right = 1000000;
		int answer = 0;
		
		for(int idx = 0; idx < CNT; ++idx) {
			input = new StringTokenizer(br.readLine());
			left = Math.max(left, Integer.parseInt(input.nextToken()));
			cols[idx] = Integer.parseInt(input.nextToken());
		}
		
		Arrays.sort(cols);
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			int cnt = 1;
			int len = cols[0] + mid - 1;
			for(int idx = 1; idx < CNT; ++idx) {
				if(cols[idx] > len) {
					++cnt;
					len = cols[idx] + mid - 1;
				}
			}
			
			if(cnt <= LIMIT) {
				answer = mid;
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
		
	}

}
