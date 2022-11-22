import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_MakeTeam {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][N + 1];
		int[] array = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx = 1; idx <= N; ++idx) {
			array[idx] = Integer.parseInt(st.nextToken());
		}
		
		for(int start = 1; start <= N; ++start) {
			dp[start] = dp[start - 1];
			int prev = dp[start - 1][start - 1];
			int min = array[start];
			int max = array[start];
			for(int end = start + 1; end <= N; ++end) {
				min = Math.min(min, array[end]);
				max = Math.max(max, array[end]);
				dp[start][end] = Math.max(dp[start][end], prev + max - min);
			}
		}
		
		bw.write(Integer.toString(dp[1][N]));
		br.close();
		bw.close();
	}

}
