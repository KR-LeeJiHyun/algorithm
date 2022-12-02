import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_Confetti {
	
	static class Confetti implements Comparable<Confetti>{
		private int h;
		private int v;
		
		Confetti(int a, int b) {
			if(a < b) {
				this.h = b;
				this.v = a;
			}
			else {
				this.h = a;
				this.v = b;
			}
		}
		
		public int compareTo(Confetti o) {
			if(this.h == o.h) return o.v - this.v;
			return o.h - this.h;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N];
		dp[0] = 1;
		
		Confetti[] confettis = new Confetti[N];
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			confettis[idx] = new Confetti(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(confettis);
		int answer = 0;
		for(int idx = 1; idx < N; ++idx) {
			dp[idx] = 1;
			for(int sIdx = 0; sIdx < idx; ++sIdx) {
				if(confettis[sIdx].h >= confettis[idx].h && confettis[sIdx].v >= confettis[idx].v) dp[idx] = Math.max(dp[idx], dp[sIdx] + 1); 
			}
			answer = Math.max(answer, dp[idx]);
		}
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.close();
		
	}

}
