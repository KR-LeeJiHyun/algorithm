import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_2XNTiling2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		bw.write(Integer.toString(solution(n)));
		
		br.close();
		bw.flush();
		bw.close();
	}

    public static int solution(int n) {
        int answer = 0;
        long num = 10007l;
        long[] dp = new long[n + 1];
        
        if(n == 1) return 1;
        
        dp[0] = 0l;
        dp[1] = 1l;
        dp[2] = 3l;
        
        for(int idx = 3; idx <= n; ++idx) dp[idx] = ((long)dp[idx - 1] + ((long)dp[idx - 2] * (long)2)) % num;
        
        answer = (int)dp[n];
        return answer;
    }
}
