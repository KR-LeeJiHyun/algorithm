import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_Change2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] coins = {500, 100, 50, 10, 5, 1};
		int money = 1000;
		int minus = Integer.parseInt(br.readLine());
		
		int change = money - minus;
		int answer = 0;
		
		for(int idx = 0; idx < coins.length; ++idx) {
			int div = change / coins[idx];
			answer += div;
			change -= coins[idx] * div;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(answer);
		sb.append('\n');
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
		
	}

}
