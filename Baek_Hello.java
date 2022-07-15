import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Hello {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MAX = 100;
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[MAX + 1][N + 1];
		int[] damages = new int[N], joys = new int[N];
		
		StringTokenizer stD = new StringTokenizer(br.readLine()), stJ = new StringTokenizer(br.readLine());
		
		for(int idx = 0; idx < N; ++idx) {
			damages[idx] = Integer.parseInt(stD.nextToken());
			joys[idx] = Integer.parseInt(stJ.nextToken());
		}
		for(int hp = 1; hp <= MAX; ++hp){
			for(int idx = 1; idx <= N; ++idx) {
				if(hp > damages[idx - 1]) dp[hp][idx] = Math.max(dp[hp][idx], dp[hp - damages[idx - 1]][idx - 1] + joys[idx - 1]);
				dp[hp][idx] = Math.max(dp[hp][idx], dp[hp][idx - 1]);
			}
		}
		
		bw.write(dp[MAX][N] + "\n");
		br.close();
		bw.flush();
		bw.close();

	}

}
