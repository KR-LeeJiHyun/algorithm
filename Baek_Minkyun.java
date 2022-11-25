import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Minkyun {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int answer = 1;
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N];
		int[] array = new int[N];
		dp[0] = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; ++idx) {
			array[idx] = Integer.parseInt(st.nextToken());
			if(idx == 0) continue; 
			int max = 0;
			for(int sIdx = 0; sIdx < idx; ++sIdx) {
				if(array[idx] > array[sIdx]) max = Math.max(max, dp[sIdx]);
			}
			dp[idx] = max + 1;
			answer = Math.max(answer, dp[idx]);
		}
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.close();

	}

}
