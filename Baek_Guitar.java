import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Guitar {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int SET_CNT = 6;
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken()), M = Integer.parseInt(stNM.nextToken());
		int set = 1001, ind = 1001;
		
		for(int idx = 0; idx < M; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			set = Math.min(set, Integer.parseInt(st.nextToken()));
			ind = Math.min(ind, Integer.parseInt(st.nextToken()));
		}
		
		int answer = 0;
		if(set < ind * SET_CNT) {
			int div = N / SET_CNT, mod = N % SET_CNT;
			answer = set * div + Math.min(set, mod * ind);
		}
		else answer = ind * N;
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();
		
	}

}
