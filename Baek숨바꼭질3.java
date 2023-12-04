import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek숨바꼭질3 {
	
	static  class Pos {
		int pos;
		int sec;
		
		public Pos(int pos, int sec) {
			this.pos = pos;
			this.sec = sec;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer input = new StringTokenizer(br.readLine());
		
		final int MAX = 100001;
		int N = Integer.parseInt(input.nextToken());
		int K = Integer.parseInt(input.nextToken());
		int[] dp = new int[MAX];
		Arrays.fill(dp, 1000000);
		
		Queue<Pos> q = new LinkedList();
		q.add(new Pos(N, 0));
		
		while(!q.isEmpty()) {
			Pos c = q.poll();
			if(c.sec <= dp[c.pos]) {
				dp[c.pos] = c.sec;
				int plus = c.pos + 1;
				int minus = c.pos - 1;
				int mul = c.pos * 2;
				int sec = c.sec + 1;
				if(plus < MAX && sec <= dp[plus]) {
					q.add(new Pos(plus, sec));
				}
				if(mul < MAX && sec <= dp[mul]) {
					q.add(new Pos(mul, c.sec));
				}
				if(minus > -1 && sec <= dp[minus]) {
					q.add(new Pos(minus, sec));
				}
			}
		}
		
		bw.write(String.valueOf(dp[K]));
		br.close();
		bw.close();
	}

}
