import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baek_21Sale {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] products = new int[N];
		for(int idx = 0; idx < N; ++idx) products[idx] = Integer.parseInt(br.readLine());
		Arrays.sort(products);
		int answer = 0;
		int cnt = 0;
		for(int idx = N - 1; idx >= 0; --idx) {
			++cnt;
			if(cnt % 3 != 0) answer += products[idx];
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();

	}

}
