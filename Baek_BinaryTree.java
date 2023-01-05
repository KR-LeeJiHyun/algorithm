import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_BinaryTree {
	
	static int[] dp;
	static int L;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = (int)Math.pow(2, k + 1);
		int[] tree = new int[L];
		int answer = 0;
		int max = 0;
		for(int idx = 2; idx < L; ++idx) {
			int weight = Integer.parseInt(st.nextToken());
			tree[idx] = tree[idx / 2] + weight;
			answer += weight;
			max = Math.max(max, tree[idx]);
		}
		
		dp = new int[L];
		
		for(int idx = (int)Math.pow(2, k); idx < L; ++idx) dp[idx] = max - tree[idx];
		dfs(2);
		dfs(3);
		
		for(int idx = 2; idx < L; ++idx) {
			answer += dp[idx];
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
		
	}

	private static void dfs(int pos) {
		
		int left = pos * 2;
		int right = pos * 2 + 1;
		
		if(left >= L) return;
		
		dfs(left);
		dfs(right);
		
		dp[pos] = Math.min(dp[left], dp[right]);
		dp[left] -= dp[pos];
		dp[right] -= dp[pos];
		
	}

}
