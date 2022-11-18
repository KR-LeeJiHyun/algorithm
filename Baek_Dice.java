import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_Dice {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int fNum = 3;
		final int dNum = 6;
		long[] face = new long[fNum];
		int[] dice = new int[dNum];
		long N = Long.parseLong(br.readLine());
		face[0] = 5 * (N - 2) * (N - 2) + 4 * (N - 2);
		face[1] = 8 * N - 12;
		face[2] = 4;
		
		long answer = 0;
		StringTokenizer stDice = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < dNum; ++idx) dice[idx] = Integer.parseInt(stDice.nextToken());
		
		if(N != 1) {
			long min = dice[0];
			for(int idx = 1; idx < dNum; ++idx) min = Math.min(min, dice[idx]);
			answer += min * face[0];
			
			min = Long.MAX_VALUE;
			for(int idx = 0; idx < dNum - 1; ++idx) {
				for(int sIdx = idx + 1; sIdx < dNum; ++sIdx) if(idx + sIdx != 5) min = Math.min(min, dice[idx] + dice[sIdx]);
			}
			answer += min * face[1];
			
			long sum = 0;
			for(int idx = 0; idx < 3; ++idx) sum += Math.min(dice[idx], dice[5 - idx]);
			answer += sum * face[2];
		}
		else {
			Arrays.sort(dice);
			for(int idx = 0; idx < dNum - 1; ++idx) answer += dice[idx];
		}
		
		bw.write(Long.toString(answer));
		br.close();
		bw.flush();
		bw.close();

	}

}
