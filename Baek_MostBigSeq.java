import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_MostBigSeq {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String strN = br.readLine();
		String strSeq = br.readLine();
		StringTokenizer st = new StringTokenizer(strSeq);
		int answer = 0;
		int N = Integer.parseInt(strN);
		int[] dp = new int[N + 1], seq = new int[N + 1];
		dp[0] = 0;
		seq[0] = 0;
		for(int idx = 1; idx <= N; ++idx) seq[idx] = Integer.parseInt(st.nextToken());
		
		for(int idx = 1; idx <= N; ++idx) {
			for(int sIdx = 0; sIdx < idx; ++sIdx) {
				if(seq[idx] > seq[sIdx]) dp[idx] = Math.max(dp[idx], dp[sIdx] + seq[idx]);
				answer = Math.max(answer, dp[idx]);
			}
		}
		
		bw.write(Integer.toString(answer));
		
		br.close();
        bw.flush();
        bw.close();
	}

}
