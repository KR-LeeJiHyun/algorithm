import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_LBSS {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int answer = 0;
		int A = Integer.parseInt(br.readLine());
		int[][] dp = new int[A][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] seq = new int[A];
		for(int idx = 0; idx < A; ++idx) seq[idx] = Integer.parseInt(st.nextToken());
		
		for(int idx = 0; idx < A; ++idx){
			dp[idx][0] = 1;
			for(int sIdx = 0; sIdx < idx; ++sIdx) {
				if(seq[idx] > seq[sIdx]) dp[idx][0] = Math.max(dp[idx][0], dp[sIdx][0] + 1);
			}
		}
		
		for(int idx = A - 1; idx >= 0; --idx){
			dp[idx][1] = 1;
			for(int sIdx = A - 1; sIdx > idx; --sIdx) {
				if(seq[idx] > seq[sIdx]) dp[idx][1] = Math.max(dp[idx][1], dp[sIdx][1] + 1);
			}
			answer = Math.max(answer, dp[idx][0] + dp[idx][1] - 1);
		}
		
		bw.write(answer + "\n");
		br.close();
        bw.flush();
        bw.close();
	}

}
