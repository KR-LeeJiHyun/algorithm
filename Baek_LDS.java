import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_LDS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int answer = 1;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N], dp = new int[N];
		A[0] = Integer.parseInt(st.nextToken());
		dp[0] = 1;
		for(int idx = 1; idx < N; ++idx) {
			A[idx] = Integer.parseInt(st.nextToken());
			dp[idx] = 1;
			for(int sIdx = 0; sIdx < idx; ++sIdx) {
				if(A[idx] < A[sIdx]) dp[idx] = Math.max(dp[idx], dp[sIdx] + 1);
			}
			answer = Math.max(answer, dp[idx]);
		}
		
		bw.write(answer + "\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
