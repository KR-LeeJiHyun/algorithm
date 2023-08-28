import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek두수의합 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		while(t > 0) {
			--t;
			StringTokenizer input = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(input.nextToken());
			int K = Integer.parseInt(input.nextToken());
			int[] S = new int[n];
			input = new StringTokenizer(br.readLine());
			for(int idx = 0; idx < n; ++idx) {
				S[idx] = Integer.parseInt(input.nextToken());
			}
			Arrays.sort(S);
			
			int best = 200000000;
			int cnt = 1;
			int left = 0;
			int right = n - 1;
			
			while(left < right) {
				int sum = S[left] + S[right];
				int dis = Math.abs(sum - K);
				if(dis == best) {
					++cnt;
				}
				else if(dis < best) {
					cnt = 1;
					best = dis;
				}
				
				if(sum == K) {
					++left;
					--right;
				}
				else if(sum < K) {
					++left;
				}
				else {
					--right;
				}
			}
			
			bw.write(String.valueOf(cnt));
			bw.write('\n');
		}
		br.close();
		bw.close();
	}
}
