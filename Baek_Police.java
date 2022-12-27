import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_Police {
	static final int ROW = 0;
	static final int COL = 1;
	static int[][][] dp;
	static int[][] pos;
	static int N;
	static int W;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		W = Integer.parseInt(br.readLine());
		dp = new int[W + 1][W + 1][3];
		pos = new int[W + 1][2];
		
		for(int idx = 1; idx <= W; ++idx) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			pos[idx][ROW] = Integer.parseInt(input.nextToken());
			pos[idx][COL] = Integer.parseInt(input.nextToken());
		}
		
		for(int idx = 1; idx <= W; ++idx) {
			for(int sIdx = 0; sIdx < idx; ++sIdx) {
				dp[idx][sIdx][0] = dist(idx, idx, sIdx);
				dp[sIdx][idx][0] = dist(idx, sIdx, idx);
			} 
		}
		
		int answer = Integer.MAX_VALUE;
		int traceR = 0;
		int traceC = 0;
		for(int idx = 0; idx < W; ++idx) {
			if(answer > dp[idx][W][0]) {
				answer = dp[idx][W][0];
				traceR = idx;
				traceC = W;
			}
			if(answer > dp[W][idx][0]) {
				answer = dp[W][idx][0];
				traceR = W;
				traceC = idx;
			}
		}
		
		bw.write(String.valueOf(answer));
		bw.write('\n');
		Stack<Integer> stack = new Stack<>();
		for(int idx = 0; idx < W; ++idx) {
			if(traceR < traceC) stack.add(2);
			else stack.add(1);
			int tmpR = dp[traceR][traceC][1];
			int tmpC = dp[traceR][traceC][2];
			traceR = tmpR;
			traceC = tmpC;
		}
		
		while(!stack.isEmpty()) {
			bw.write(String.valueOf(stack.pop()));
			bw.write('\n');
		}
		
		br.close();
		bw.close();
	}

	private static int dist(int target, int fIdx, int sIdx) {
		
		if(target == fIdx) {
			if(sIdx != target - 1) {
				dp[fIdx][sIdx][1] = target - 1;
				dp[fIdx][sIdx][2] = sIdx;
				return dp[target - 1][sIdx][0] + Math.abs(pos[target][ROW] - pos[target - 1][ROW]) + Math.abs(pos[target][COL] - pos[target - 1][COL]);
			}
			else {
				int result = dp[0][target - 1][0] + Math.abs(pos[target][ROW] - 1) + Math.abs(pos[target][COL] - 1);
				dp[fIdx][sIdx][1] = 0;
				dp[fIdx][sIdx][2] = target - 1;
				for(int idx = 1; idx < target - 1; ++idx) {
					int tmp = dp[idx][target - 1][0] + Math.abs(pos[target][ROW] - pos[idx][ROW]) + Math.abs(pos[target][COL] - pos[idx][COL]);
					if(result > tmp) {
						result = tmp;
						dp[fIdx][sIdx][1] = idx;
					}
				}
				return result;
			}
		}
		
		else {
			if(fIdx != target - 1) {
				dp[fIdx][sIdx][1] = fIdx;
				dp[fIdx][sIdx][2] = target - 1;
				return dp[fIdx][target - 1][0] + Math.abs(pos[target][ROW] - pos[target - 1][ROW]) + Math.abs(pos[target][COL] - pos[target - 1][COL]);
			}
			else {
				int result = dp[target - 1][0][0] + Math.abs(pos[target][ROW] - N) + Math.abs(pos[target][COL] - N);
				dp[fIdx][sIdx][1] = target - 1;
				dp[fIdx][sIdx][2] = 0;
				for(int idx = 1; idx < target - 1; ++idx) {
					int tmp = dp[target - 1][idx][0] + Math.abs(pos[target][ROW] - pos[idx][ROW]) + Math.abs(pos[target][COL] - pos[idx][COL]);
					if(result > tmp) {
						result = tmp;
						dp[fIdx][sIdx][2] = idx;
					}
				}
				return result;
			}
		}
	}

}
