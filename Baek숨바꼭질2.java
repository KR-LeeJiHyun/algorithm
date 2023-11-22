import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek숨바꼭질2 {
	
	static  class Pos {
		int pos;
		int sec;
		
		public Pos(int pos, int sec) {
			super();
			this.pos = pos;
			this.sec = sec;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer input = new StringTokenizer(br.readLine());
		
		final int S = 0;
		final int C = 1;
		final int MAX = 100001;
		int N = Integer.parseInt(input.nextToken());
		int K = Integer.parseInt(input.nextToken());
		int[][] dp = new int[2][MAX];
		Arrays.fill(dp[S], 1000000);
		
		Queue<Pos> q = new LinkedList();
		q.add(new Pos(N, 0));
		
		while(!q.isEmpty()) {
			Pos c = q.poll();
			if(c.sec <= dp[S][c.pos]) {
				dp[S][c.pos] = c.sec;
				if(c.sec == dp[S][c.pos]) {
					++dp[C][c.pos];
				}else  {
					dp[C][c.pos] = 1;
				}
				int plus = c.pos + 1;
				int minus = c.pos - 1;
				int mul = c.pos * 2;
				int sec = c.sec + 1;
				if(plus < MAX && sec <= dp[S][plus]) {
					q.add(new Pos(plus, sec));
				}
				if(mul < MAX && sec <= dp[S][mul]) {
					q.add(new Pos(mul, sec));
				}
				if(minus > -1 && sec <= dp[S][minus]) {
					q.add(new Pos(minus, sec));
				}
			}
		}
		
		StringBuilder answer = new StringBuilder();
		answer.append(dp[S][K]);
		answer.append('\n');
		answer.append(dp[C][K]);
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}

}
