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
	/*
		static final int ROW = 0;
	static final int COL = 1;
	static int[][] dp;
	static int[][] pos;
	static int N;
	static int W;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		W = Integer.parseInt(br.readLine());
		dp = new int[W + 1][W + 1];
		pos = new int[W + 1][2];
		
		StringTokenizer st;
		for(int idx = 1; idx <= W; ++idx) {
			st = new StringTokenizer(br.readLine());
			pos[idx][ROW] = Integer.parseInt(st.nextToken());
			pos[idx][COL] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(memozation(1, 0, 0)).append('\n');
		
		int x = 0;
		int y = 0;
		int target = 1;
		while(target <= W) {
			
			if(dp[target][y] + dist1(pos[target], pos[x]) == dp[x][y]) {
				sb.append(1).append('\n');
				x = target;
			}
			else {
				sb.append(2).append('\n');
				y = target;
			}
			++target;
		}
		
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static int memozation(int target, int x, int y) {
		if(target > W) return 0;
		if(dp[x][y] == 0) {
			int solveX = memozation(target + 1, target, y) + dist1(pos[target], pos[x]);
			int solveY = memozation(target + 1, x, target) + dist2(pos[target], pos[y]);
		
			dp[x][y] = Math.min(solveX, solveY);
		}
		return dp[x][y];
	}

	private static int dist2(int[] targetPos, int[] currPosY) {
		if(currPosY[ROW] == 0 && currPosY[COL] == 0) return Math.abs(targetPos[ROW] - N) + Math.abs(targetPos[COL] - N);
		return Math.abs(targetPos[ROW] - currPosY[ROW]) + Math.abs(targetPos[COL] - currPosY[COL]);
	}

	private static int dist1(int[] targetPos, int[] currPosX) {
		if(currPosX[ROW] == 0 && currPosX[COL] == 0) return Math.abs(targetPos[ROW] - 1) + Math.abs(targetPos[COL] - 1);
		return Math.abs(targetPos[ROW] - currPosX[ROW]) + Math.abs(targetPos[COL] - currPosX[COL]);
	}
	*/

}
