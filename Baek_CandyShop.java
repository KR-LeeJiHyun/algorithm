import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_CandyShop {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5);
			
			if(N == 0 & M == 0) break;
			int[] dp = new int[M + 1];

			for(int idx = 0; idx < N; ++idx) {
				StringTokenizer input = new StringTokenizer(br.readLine());
				int cal = Integer.parseInt(input.nextToken());
				int price = (int)(Double.parseDouble(input.nextToken()) * 100 + 0.5);
				
				for(int sIdx = price; sIdx <= M; ++sIdx) {
					dp[sIdx] = Math.max(dp[sIdx], dp[sIdx - price] + cal);
				}
			}
			
			bw.write(String.valueOf(dp[M]));
			bw.write('\n');
			
		}
		
		br.close();
		bw.close();

	}

}
