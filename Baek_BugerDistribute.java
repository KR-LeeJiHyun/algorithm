import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_BugerDistribute {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String line = br.readLine();
		boolean[] buger = new boolean[N];
		
		for(int idx = 0; idx < N; ++idx) {
			if(line.charAt(idx) == 'H') buger[idx] = true;
		}
		
		int answer = 0;
		for(int idx = 0; idx < N; ++idx) {
			char current = line.charAt(idx);
			if(current == 'P') {
				for(int sIdx = Math.max(idx - K, 0); sIdx <= Math.min(idx + K, N - 1); ++sIdx) {
					if(buger[sIdx]) {
						++answer;
						buger[sIdx] = false;
						break;
					}
				}
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();

	}

}
