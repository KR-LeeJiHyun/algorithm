import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek기차여행 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		final int PRICE_LEN = 3;
		final int O = 0;
		final int D = 1;
		final int A = 2;
		int N = Integer.parseInt(stNM.nextToken());
		int M = Integer.parseInt(stNM.nextToken());
		int[] prefixSum = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int prev = Integer.parseInt(st.nextToken());
		for(int idx = 1; idx < M; ++idx) {
			int next = Integer.parseInt(st.nextToken());
			if(prev < next) {
				++prefixSum[prev];
				--prefixSum[next];
			}
			else {
				++prefixSum[next];
				--prefixSum[prev];
			}
			prev = next;
		}
		
		long[][] price = new long[N + 1][PRICE_LEN];
		for(int idx = 1; idx < N; ++idx) {
			StringTokenizer stPrice = new StringTokenizer(br.readLine());
			price[idx][O] = Long.parseLong(stPrice.nextToken());
			price[idx][D] = Long.parseLong(stPrice.nextToken());
			price[idx][A] = Long.parseLong(stPrice.nextToken());
		}
		
		long answer = 0l;
		int cnt = 0;
		
		for(int idx = 1; idx < N; ++idx) {
			cnt += prefixSum[idx];
            if(cnt == 0) continue;
			answer += Math.min(price[idx][O] * cnt, price[idx][D] * cnt + price[idx][A]);
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();

	}

}
