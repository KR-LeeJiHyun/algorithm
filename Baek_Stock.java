import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Stock {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] stocks = new int[N];
			StringTokenizer stStocks = new StringTokenizer(br.readLine());
			for(int idx = 0; idx < N; ++idx) stocks[idx] = Integer.parseInt(stStocks.nextToken());
			int max = stocks[N - 1];
			long answer = 0;
			for(int idx = N - 2; idx > -1; --idx) {
				if(max > stocks[idx]) answer += max - stocks[idx];
				else max = stocks[idx];
			}
			sb.append(answer);
			sb.append('\n');
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();

	}

}
