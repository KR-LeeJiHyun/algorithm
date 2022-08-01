import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_DanceDanceRevolution {

	static int[][][] dp;
	static ArrayList<Integer> patterns; 
	static final int CENTER = 0, FOOTS = 5;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		patterns = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(true) {
			int pattern = Integer.parseInt(st.nextToken());
			if(pattern == 0) break;
			patterns.add(pattern);
		}

		int len = patterns.size();

		if(len == 0) {
			bw.write("0\n");
			br.close();
			bw.flush();
			bw.close();
			return;
		}

		dp = new int[len][FOOTS][FOOTS];
		int foot = patterns.get(0);
		dp[0][foot][0] = 2;

		for(int idx = 1; idx < len; ++idx) {
			int c_foot = patterns.get(idx);
			for(int left = 0; left < FOOTS; ++left) {
				for(int right = 0; right < FOOTS; ++right) {
					if(dp[idx - 1][left][right] != 0) {
						if(left != right) {
							
							if(left == c_foot) {
								int force = dp[idx - 1][left][right] + 1;
								if(dp[idx][left][right] == 0 || force < dp[idx][left][right]) dp[idx][left][right] = force;
							}
							
							else if(right == c_foot) {
								int force = dp[idx - 1][left][right] + 1;
								if(dp[idx][left][right] == 0 || force < dp[idx][left][right]) dp[idx][left][right] = force;
							}
							
							else {
								//왼발 옮기기
								if(Math.abs(left - c_foot) == 2) {
									int force = dp[idx - 1][left][right] + 4;
									if(dp[idx][c_foot][right] == 0 || force < dp[idx][c_foot][right]) dp[idx][c_foot][right] = force;
								}
								else {
									int force = dp[idx - 1][left][right] + 3;
									if(dp[idx][c_foot][right] == 0 || force < dp[idx][c_foot][right]) dp[idx][c_foot][right] = force;
								}
								//오른발 옮기기
								if(right == CENTER) {
									int force = dp[idx - 1][left][right] + 2;
									if(dp[idx][left][c_foot] == 0 || force < dp[idx][left][c_foot]) dp[idx][left][c_foot] = force;
								}
								else if(Math.abs(right - c_foot) == 2) {
									int force = dp[idx - 1][left][right] + 4;
									if(dp[idx][left][c_foot] == 0 || force < dp[idx][left][c_foot]) dp[idx][left][c_foot] = force;
								}
								else {
									int force = dp[idx - 1][left][right] + 3;
									if(dp[idx][left][c_foot] == 0 || force < dp[idx][left][c_foot]) dp[idx][left][c_foot] = force;
								}
							}
						}
					}
				}
			}
		}

		int answer = Integer.MAX_VALUE, last = patterns.get(len - 1);
		for(int free = 0; free < FOOTS; ++free) {
			if(dp[len - 1][last][free] != 0) answer = Math.min(answer, dp[len - 1][last][free]);
			if(dp[len - 1][free][last] != 0) answer = Math.min(answer, dp[len - 1][free][last]);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(answer);
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}

}
