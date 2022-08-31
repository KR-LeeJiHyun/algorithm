import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Camping {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken()), V = Integer.parseInt(st.nextToken());
			if(L == 0) break;
			
			int answer = L * (V / P) + Math.min((V % P), L);
			sb.append("Case " + cnt + ": ");
			sb.append(answer);
			sb.append('\n');
			++cnt;
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}

}
