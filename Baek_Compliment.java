import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_Compliment {
	
	static int[] dp;
	static ArrayList<Integer>[] relation;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken());
		int M = Integer.parseInt(stNM.nextToken());
		relation = new ArrayList[N + 1];
		
		for(int idx = 1; idx <= N; ++idx) relation[idx] = new ArrayList<>();
		StringTokenizer stRelation = new StringTokenizer(br.readLine());
		stRelation.nextToken();
		for(int idx = 2; idx <= N; ++idx) {
			int supervisor = Integer.parseInt(stRelation.nextToken());
			relation[supervisor].add(idx);
		}
		
		dp = new int[N + 1];
		for(int idx = 0; idx < M; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			dp[i] += w;
		}
		
		for(int idx = 2; idx <= N; ++idx) {
			for(int sIdx = 0; sIdx < relation[idx].size(); ++sIdx) dp[relation[idx].get(sIdx)] += dp[idx];
		}
		
		for(int idx = 1; idx <= N; ++idx) {
			bw.write(Integer.toString(dp[idx]));
			bw.write(' ');
		}
		
		br.close();
		bw.flush();
		bw.close();

	}
}
