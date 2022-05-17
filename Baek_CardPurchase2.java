import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_CardPurchase2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int cardCnt = 1; cardCnt <= N; ++cardCnt) {
			dp[cardCnt] = Integer.parseInt(st.nextToken());
			for(int prev = 1; prev < cardCnt; ++prev) dp[cardCnt] = Math.min(dp[cardCnt], dp[cardCnt - prev] + dp[prev]); 
		}
		
		bw.write(dp[N] + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
