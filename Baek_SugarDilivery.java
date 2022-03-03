import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_SugarDilivery {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); 

		bw.write(Integer.toString(solution(N)));
		
		br.close();
        bw.flush();
        bw.close();
	}
	
	public static int solution(int N) {
		if(N == 3) return 1;
		if(N == 4) return -1;
		int answer = 0;
		int[] dp = new int [N + 1];
		dp[0] = 0;
		dp[1] = -1;
		dp[2] = -1;
		dp[3] = 1;
		dp[4] = -1;
		dp[5] = 1;
		
		for(int idx = 6; idx < N + 1; ++idx) {
			int small = dp[idx - 3], big = dp[idx - 5];
			if(small == -1 && big == -1) dp[idx] = -1;
			else if(small == -1) dp[idx] = big + 1;
			else if(big == -1) dp[idx] = small + 1;
			else dp[idx] = Math.min(small, big) + 1;
			
		}
		
		answer = dp[N];
		return answer;
	}

}
