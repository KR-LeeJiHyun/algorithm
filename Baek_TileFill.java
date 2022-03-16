import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_TileFill {

	public static void main(String[] args) throws NumberFormatException, IOException {
        int n = 0;
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
        
        if(n != 0 && n % 2 == 0){
        long[] dp = new long[n + 1];
            dp[2] = 3l;
            
            for(int idx = 4; idx <= n; idx += 2) {
            	dp[idx] = dp[idx - 2] * dp[2]; 
            	for(int sIdx = 4; sIdx < idx; sIdx += 2) {
            		dp[idx] += dp[idx - sIdx] * 2;
            	}
            	dp[idx] += 2;
            }
        
            bw.write(dp[n] + "\n");
        }
        else bw.write("0\n");
		br.close();
        bw.flush();
        bw.close();
	}

}
