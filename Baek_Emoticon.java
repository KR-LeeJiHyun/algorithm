import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_Emoticon {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int S = Integer.parseInt(br.readLine());
		int[] dp = new int[S + 1];
		dp[2] = 2;
		
		for(int idx = 3; idx <= S; ++idx) {
			dp[idx] = idx; 
			for(int div = 2; div < idx; ++div) {
				int mod = idx % div;
				int quo = idx /div;
				if(mod != 0)dp[idx] = Math.min(dp[idx], dp[div] + 1 + quo + (div - mod));
				else dp[idx] = Math.min(dp[idx], dp[div] + 1 + quo - 1);
			}
		}
		
		bw.write(dp[S] + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
