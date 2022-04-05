import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_LongestSubSeq4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		ArrayList<Integer>[] dp = new ArrayList[N];
		for(int idx = 0; idx < N; ++idx) {
			dp[idx] = new ArrayList<>();
			nums[idx] = Integer.parseInt(st.nextToken());
		}
		
		int aMax = 1, aIdx = 0;
		dp[0].add(nums[0]);
		
		for(int idx = 1; idx < N; ++idx) {
			int max = 0, mIdx = -1;
			for(int sIdx = 0; sIdx < idx; ++sIdx) {
				if(nums[idx] > nums[sIdx] && max < dp[sIdx].size()) {
					max = dp[sIdx].size();
					mIdx = sIdx;
				}
			}
			if(mIdx != -1) dp[idx] = (ArrayList<Integer>) dp[mIdx].clone();
			dp[idx].add(nums[idx]);
			if(aMax < dp[idx].size()) {
				aMax = dp[idx].size();
				aIdx = idx;
			}
		}
		
		bw.write(aMax + "\n");
		for(int idx = 0; idx < aMax; ++idx) bw.write(dp[aIdx].get(idx) + " ");
		br.close();
		bw.flush();
		bw.close();
	}

}
