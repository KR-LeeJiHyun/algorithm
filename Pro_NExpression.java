import java.util.ArrayList;

public class Pro_NExpression {
	public static int solution(int N, int number) {
		if(N == number) return 1;

		ArrayList<Integer>[] dp = new ArrayList[9];
		dp[0] = new ArrayList<>();
		dp[0].add(0);

		for(int idx = 1; idx < dp.length; ++idx) {
			dp[idx] = new ArrayList<>();
			dp[idx].add(dp[idx - 1].get(0) * 10 + N);
		}

		for(int count = 2; count < 9; ++count) {
			for(int p_count = 1; p_count < count; ++p_count) {
				for(int first : dp[p_count]) {
					for(int second : dp[count - p_count]) {
						dp[count].add(first + second);
						dp[count].add(first - second);
						dp[count].add(first * second);
						if(second != 0) dp[count].add(first / second);
					}
				}
			}
			if(dp[count].contains(number)) return count;
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 2, number = 11;
		System.out.print(solution(N, number));
	}

}
