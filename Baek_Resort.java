import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_Resort {
	
	static int[][] dp;
	static boolean[] holiday;
	static int N, M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		

		N = Integer.parseInt(stNM.nextToken());
		M = Integer.parseInt(stNM.nextToken());
		
		dp = new int[N + 1][N + 1];
		
		for(int idx = 1; idx <= N; ++idx) Arrays.fill(dp[idx], Integer.MAX_VALUE);
		
		holiday = new boolean[N + 1];
		
		if(M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreElements()) holiday[Integer.parseInt(st.nextToken())] = true;
		}
		
		bw.write(Integer.toString(calc(1, 0)));
		br.close();
		bw.flush();
		bw.close();
	
	}

	private static int calc(int day, int coupon) {
		if(day > N) return 0;
		if(dp[day][coupon] != Integer.MAX_VALUE) return dp[day][coupon];
		if(holiday[day]) dp[day][coupon] = Math.min(dp[day][coupon], calc(day + 1, coupon));
		else {
			if(coupon >= 3) dp[day][coupon] = Math.min(dp[day][coupon], calc(day + 1, coupon - 3));
			dp[day][coupon] = Math.min(dp[day][coupon], calc(day + 1, coupon) + 10000);
			dp[day][coupon] = Math.min(dp[day][coupon], calc(day + 3, coupon + 1) + 25000);
			dp[day][coupon] = Math.min(dp[day][coupon], calc(day + 5, coupon + 2) + 37000);
		}
		
		return dp[day][coupon];
	}

}
