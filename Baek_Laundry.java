import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_Laundry {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int[] coins = {25, 10, 5, 1};
		
		for(int t = 0; t < T; ++t) {
			int C = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for(int idx = 0; idx < coins.length; ++idx){
				sb.append(C / coins[idx]);
				sb.append(' ');
				C %= coins[idx];
			}
			sb.append('\n');
			bw.write(sb.toString());
		}
		br.close();
		bw.flush();
		bw.close();

	}

}
