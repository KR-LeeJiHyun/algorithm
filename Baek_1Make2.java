import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Baek_1Make2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int X = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		int[][] dp = new int[X + 1][2];
		for(int idx = 1; idx < X; ++idx) dp[idx][0] = X - 1;
		int x = X;
		while(X != 1) {
			if(X % 3 == 0 && dp[X/3][0] > dp[X][0] + 1) {
				dp[X / 3][0] = dp[X][0] + 1;
				dp[X / 3][1] = X;
			}
			if(X % 2 == 0 && dp[X/2][0] > dp[X][0] + 1) {
				dp[X / 2][0] = dp[X][0] + 1;
				dp[X / 2][1] = X;
			}
			if(dp[X - 1][0] > dp[X][0] + 1) {
				dp[X - 1][0] = dp[X][0] + 1;
				dp[X - 1][1] = X;
			}
			--X;
		}
		
		while(X != x) {
			list.add(X);
			X = dp[X][1];
		}
		list.add(X);
		
		bw.write(dp[1][0] + "\n");
		for(int idx = list.size() - 1; idx > -1 ; --idx) bw.write(list.get(idx) + " ");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
