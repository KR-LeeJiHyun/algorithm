import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek합이0 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer input = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) {
			arr[idx] = Integer.parseInt(input.nextToken());
		}
		
		long answer = 0;
		final int STAND = 20000;
		int[] cnt = new int[40001];
		for(int idx = 0; idx < N; ++idx) {
			answer += cnt[STAND - arr[idx]];
			for(int sIdx = 0; sIdx < idx; ++sIdx) {
				++cnt[arr[idx] + arr[sIdx] + STAND];
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

}
