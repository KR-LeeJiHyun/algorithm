import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_PainfulKnight {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		if(N == 1) answer = 1;
		else if(N == 2) answer = Math.min(4, (M + 1)/ 2);
		else if(M < 7) answer = Math.min(4, M);
		else answer = M - 2;
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
		
	}

}
