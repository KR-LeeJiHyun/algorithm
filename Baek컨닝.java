import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek컨닝 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int C = Integer.parseInt(br.readLine());
		
		while(C > 0) {
			--C;
			int answer = 0;
			StringTokenizer input = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(input.nextToken());
			int M = Integer.parseInt(input.nextToken());
			int[] map = new int[N];
			int[][] dp = new int[N][1 << M];
			
			ArrayList<Integer> seats = new ArrayList<>();
			for(int idx = 0; idx < 1 << M; ++idx) {
				if(chkAdj(idx, M)) {
					seats.add(idx);
				}
			}
			
			for(int row = 0; row < N; ++row) {
				String in = br.readLine();
				for(int col = 0; col < M; ++col) {
					if(in.charAt(col) == '.') map[row] += 1 << col;
				}
			}
			
			for(int seat : seats ) {
				if((seat & map[0]) == seat) dp[0][seat] = Integer.bitCount(seat);
				answer = Math.max(answer, dp[0][seat]);
			}
			
			for(int row = 1; row < N; ++row) {
				for(int seat : seats ) {
					if((seat & map[row]) == seat) {
						int cnt = Integer.bitCount(seat);
						int max = 0;
						for(int prev : seats) {
							if(((seat >> 1) & prev) == 0 && ((seat << 1) & prev) == 0) max = Math.max(max, dp[row - 1][prev]);
						}
						dp[row][seat] = cnt + max;
					}
					answer = Math.max(answer, dp[row][seat]);
				}
			}

			bw.write(String.valueOf(answer));
			bw.write('\n');
		}
		br.close();
		bw.close();
	}

	private static boolean chkAdj(int n, int M) {
		for(int idx = 1; idx <= M; ++idx) {
			if(((n >> idx) & (n >> (idx - 1))) == 1) return false;
		}
		return true;
	}

}
