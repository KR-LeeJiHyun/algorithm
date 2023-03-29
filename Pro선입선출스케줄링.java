public class Pro선입선출스케줄링 {

	public static void main(String[] args) {
		int n = 6;
		int[] cores = {1, 2, 3};
		
		Pro선입선출스케줄링 S = new Pro선입선출스케줄링();
		S.solution(n, cores);

	}
	
    public int solution(int n, int[] cores) {
    	final int LEN = cores.length;
    	
    	if(n <= LEN) {
    		return n;
    	}
        int answer = 0;
        
        int left = 1;
        int right = 250000000;
        int cnt = 0;
        while(left <= right) {
        	int mid = (left + right) / 2;
        	cnt = 0;
        	for(int idx = 0; idx < LEN; ++idx) {
        		cnt += mid / cores[idx] + 1;
        		if(cnt > n) {
        			break;
        		}
        	}
        	
        	if(cnt >= n) {
        		right = mid - 1;
        	}
        	else{
        		left = mid + 1;
        	}
        }
        
        if(cnt == n) {
        	for(int idx = 0; idx < LEN; ++idx) {
        		if(left % cores[idx] == 0) {
        			answer = idx + 1;
        		}
        	}
        }
        else {
        	cnt = 0;
        	for(int idx = 0; idx < LEN; ++idx) {
        		cnt += right / cores[idx] + 1;
        	}
        	for(int idx = 0; idx < LEN; ++idx) {
        		if(left % cores[idx] == 0) {
        			answer = idx + 1;
        			++cnt;
        		}
        		if(cnt == n) {
        			break;
        		}
        	}
        }
        
        return answer;
    }

}
