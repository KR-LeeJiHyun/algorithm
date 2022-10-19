import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek_DNA {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Character, Integer>[] map = new HashMap[M];
		
		for(int idx = 0; idx < M; ++idx) {
			map[idx] = new HashMap();
			map[idx].put('A', 0);
			map[idx].put('C', 0);
			map[idx].put('G', 0);
			map[idx].put('T', 0);
		}

		
		for(int n = 0; n < N; ++n) {
			String s = br.readLine();
			for(int idx = 0; idx < M; ++idx) {
				char c = s.charAt(idx);
				map[idx].put(c, map[idx].get(c) + 1);
			}
		}
		
		int cntAnswer = 0;
		StringBuilder answer = new StringBuilder();
		for(int idx = 0; idx < M; ++idx) {
			int sum = 0;
			int max = 0;
			char c = 'A';
			for(char key : map[idx].keySet()) {
				int cnt = map[idx].get(key);
				if(cnt > max) {
					max = cnt;
					c = key;
				}
				else if(max == cnt && key < c) c = key;
				sum += cnt;
			}
			cntAnswer += sum - max;
			answer.append(c);
		}
		
		answer.append('\n');
		answer.append(cntAnswer);
		
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();

	}

}
