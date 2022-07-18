import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_LostBracket {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer minus = new StringTokenizer(br.readLine(), "-");
		int N = minus.countTokens();
		int answer = 0;
		int[] sum = new int[N];
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");
			while(plus.hasMoreElements()) sum[idx] += Integer.parseInt(plus.nextToken());
			if(idx != 0) answer -= sum[idx];
			else answer += sum[idx];
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
