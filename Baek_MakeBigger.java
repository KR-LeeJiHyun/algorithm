import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baek_MakeBigger {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder(br.readLine());
		Deque<Character> deque = new ArrayDeque<>();
		int rcnt = 0;
		
		for(int idx = 0; idx < sb.length(); ++idx) {
			char current = sb.charAt(idx);
			while(!deque.isEmpty() && deque.getLast() < current && rcnt < K) {
				deque.pollLast();
				++rcnt;
			}
			deque.addLast(current);
		}
		
		StringBuilder answer = new StringBuilder();
		while(answer.length() != N - K) answer.append(deque.pollFirst());
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();

	}

}
