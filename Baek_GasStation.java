import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_GasStation {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] dis = new int[N - 1], prices = new int[N - 1];
		
		StringTokenizer st_dis = new StringTokenizer(br.readLine());
		StringTokenizer st_prices = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N - 1; ++idx) {
			dis[idx] = Integer.parseInt(st_dis.nextToken());
			prices[idx] = Integer.parseInt(st_prices.nextToken());
		} 
		
		long min = prices[0], answer = min * dis[0];
		for(int idx = 1; idx < N - 1; ++idx) {
			min = Math.min(min, prices[idx]);
			answer += min * dis[idx];
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();

	}

}
