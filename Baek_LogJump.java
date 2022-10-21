import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_LogJump {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(T != 0) {
			--T;
			int N = Integer.parseInt(br.readLine());
			int[] logs = new int[N];
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int idx = 0; idx < N; ++idx) pq.add(Integer.parseInt(st.nextToken()));
			
			int l = 0;
			int r = N - 1;
			for(int idx = 0; idx < N; ++idx) {
				if(idx % 2 == 0) logs[l++] = pq.poll();
				else logs[r--] = pq.poll();
			}
			
			int answer = logs[N - 1] - logs[0];
			for(int idx = N - 1; idx > 0; --idx) answer = Math.max(answer, Math.abs(logs[idx] - logs[(idx - 1)]));
			sb.append(answer);
			sb.append('\n');
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}

}
