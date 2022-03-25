import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_ReculsiveFunc {
	final static int MAX = 21;
	static int[][][] dp = new int[MAX][MAX][MAX];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
			if(a == -1 && b == -1 && c == -1) return;
			int result = w(a, b, c);
			System.out.printf("w(%d, %d, %d) = %d \n", a, b, c, result);
		}
	}
	
	private static int w(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c <= 0) return 1;
		else if (a > 20 || b > 20 || c > 20) return dp[20][20][20] = w(20, 20, 20);
		else if(dp[a][b][c] != 0) return dp[a][b][c];
		else if(a < b && b < c) dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		else dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
		return dp[a][b][c];
	}
	
	private static boolean isRange(int a, int b, int c) {
		return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
	}

}
