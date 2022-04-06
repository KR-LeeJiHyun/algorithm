import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Down {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int cLen = 3;
		int N = Integer.parseInt(br.readLine());
		int[][] maxDp = new int[N + 1][cLen], minDp = new int[N + 1][cLen];
		
		for(int idx = 1; idx <= N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken()), mid = Integer.parseInt(st.nextToken()), right = Integer.parseInt(st.nextToken());
			maxDp[idx][0] = left + Math.max(maxDp[idx - 1][0], maxDp[idx - 1][1]);
			maxDp[idx][1] = mid + Math.max(maxDp[idx - 1][0], Math.max(maxDp[idx - 1][1], maxDp[idx - 1][2]));
			maxDp[idx][2] = right + Math.max(maxDp[idx - 1][2], maxDp[idx - 1][1]);
			
			minDp[idx][0] = left + Math.min(minDp[idx - 1][0], minDp[idx - 1][1]);
			minDp[idx][1] = mid + Math.min(minDp[idx - 1][0], Math.min(minDp[idx - 1][1], minDp[idx - 1][2]));
			minDp[idx][2] = right + Math.min(minDp[idx - 1][2], minDp[idx - 1][1]);
		}
		
		int max = Math.max(maxDp[N][0], Math.max(maxDp[N][1], maxDp[N][2])), min = Math.min(minDp[N][0], Math.min(minDp[N][1], minDp[N][2]));
		
		bw.write(max + " " + min + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
