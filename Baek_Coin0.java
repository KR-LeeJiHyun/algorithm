import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Coin0 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		
		for(int idx = 0; idx < N; ++idx) coins[idx] = Integer.parseInt(br.readLine());
		
		int answer = 0;
		
		for(int idx = N - 1; idx >= 0; --idx) {
			int div = K / coins[idx];
			K -= div * coins[idx];
			answer += div;
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();

	}

}
