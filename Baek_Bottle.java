import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Bottle {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		while(K > 1 && N > 0) {
			int cnt = 1;
			while(cnt < N) cnt *= 2;
			N -= cnt / 2;
			--K;
		}
		
		if(N != 0) {
			int target = 1;
			while(target < N) target *= 2;
			answer = target - N;
		}
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();

	}

}
