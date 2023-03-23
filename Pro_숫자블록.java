public class Pro_숫자블록 {

	public static void main(String[] args) {
		long begin = 100000014;
		long end = 100000016;
		
		Pro_숫자블록 S = new Pro_숫자블록();
		S.solution(begin, end);
	}
	
	final int MAX = 10000000;
	
    public int[] solution(long begin, long end) {
    	final int LEN = (int)(end - begin) + 1;
        int[] answer = new int[LEN];
        
        for(int idx = 0; idx < LEN; ++idx) {
        	answer[idx] = getNum(idx + (int)begin);
        }
        
        return answer;
    }

	private int getNum(int num) {
		if(num == 1) {
			return 0;
		}
		int result = 1;
	    for(int idx = 2; idx <= Math.sqrt(num); ++idx) {
	    	if(num % idx == 0) {
	    		result = idx;
	    	}
	    	if(num % idx == 0 && num / idx <= MAX) {
	    		return num / idx;
	    	}
	    }
	    
        return result;
	}

}
