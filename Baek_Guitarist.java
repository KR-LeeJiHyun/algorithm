import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_Guitarist {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()), stV = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[] V = new int[N];
		for(int idx = 0; idx < N; ++idx) V[idx] = Integer.parseInt(stV.nextToken());
		int[][] dp = new int[N + 1][M + 1];
		Arrays.fill(dp[0], S);
		
		for(int nIdx = 1; nIdx <= N; ++nIdx) {
			for(int mIdx = 0; mIdx <= M; ++mIdx) {
				int curV = V[nIdx - 1];
				if(curV <= mIdx && dp[nIdx - 1][mIdx - curV] != -1 && curV + dp[nIdx - 1][mIdx - curV] <= mIdx) dp[nIdx][mIdx] = curV + dp[nIdx - 1][mIdx - curV];
				else if(curV + mIdx <= M && dp[nIdx - 1][mIdx + curV] != -1 && dp[nIdx - 1][mIdx + curV] - curV >= 0) dp[nIdx][mIdx] = dp[nIdx - 1][mIdx + curV] - curV;
				else dp[nIdx][mIdx] = -1;
			}
		}
			
		bw.write(dp[N][M] + "\n");
		br.close();
		bw.flush();
		bw.close();
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()), stV = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), answer = -1;
		int[] V = new int[N];
		for(int idx = 0; idx < N; ++idx) V[idx] = Integer.parseInt(stV.nextToken());
		int[] dp = new int[M + 1];
		Arrays.fill(dp, -1);
		dp[S] = 0;
		
		for(int idx = 0; idx < V.length; ++idx) {
			int curV = V[idx];
			ArrayList<Integer> list = new ArrayList<>();
			for(int plus = 0; plus <= M - curV; ++plus) if(dp[plus] == idx) list.add(plus + curV);
			for(int minus = M; minus >= curV; --minus) if(dp[minus] == idx) list.add(minus - curV);
			for(int lIdx = 0; lIdx < list.size(); ++lIdx) dp[list.get(lIdx)] = idx + 1;
		}
			
		for(int idx = M; idx >= 0; --idx) {
			if(dp[idx] == N) {
				answer = idx;
				break;
			}
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();*/
	}
}
