import java.util.Arrays;

public class Pro_Immigration {	

	public static long solution(int n, int[] times) {
		long answer = 0;
		Arrays.sort(times);
		
		long start = 0, end = times[times.length - 1] * n;
		
		while(start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			
			for(int idx = 0; idx < times.length; ++idx) {
				sum += mid / times[idx];
			}
			
			if(sum < n) start = mid + 1;
			else {
				end = mid - 1;
				answer = mid;
			}
		}
		
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int [] times = {7, 10};
		System.out.print(solution(n, times));
	}

}
