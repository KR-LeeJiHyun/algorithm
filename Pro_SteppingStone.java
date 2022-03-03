import java.util.Arrays;

public class Pro_SteppingStone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int distance = 5, n = 1;
		int[] rocks = {3};
		solution(distance, rocks, n);
	}
	
	public static int solution(int distance, int[] rocks, int n) {
		int answer = 0;

		Arrays.sort(rocks);
		int start = 0, end = distance;
		while(start <= end) {
			int mid = (start + end) / 2, cnt = 0, fix = 0;
			for(int idx = 0; idx < rocks.length; ++idx) {
				if(cnt > n) break;
				
				if(rocks[idx] - fix < mid) ++cnt;
				else fix = rocks[idx];
			}
			
			if(distance - fix < mid) ++cnt;
			
			if(cnt <= n) {
				answer = mid;
				start = mid + 1;
			}
			else end = mid - 1;
		}
		
		return answer;
	}
}
