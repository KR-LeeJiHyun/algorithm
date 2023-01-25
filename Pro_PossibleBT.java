
public class Pro_PossibleBT {

	public static void main(String[] args) {
		Pro_PossibleBT PPB = new Pro_PossibleBT();
		long[] numbers = {42, 5};
		System.out.println(PPB.solution(numbers));
	}
	
	int bIdx = 0;
	
    public int[] solution(long[] numbers) {
    	final int LEN = numbers.length;
        int[] answer = new int[LEN];
        
        for(int idx = 0; idx < LEN; ++idx) {
        	bIdx = 0;
        	String binary = Long.toBinaryString(numbers[idx]);
        	int len = 1;
        	int cnt = 1;
        	while(len < binary.length()) len += Math.pow(2, cnt++);
        	StringBuilder sb = new StringBuilder(binary);
        	while(len != sb.length()) sb.insert(0, '0');
        	
        	int[] bt = new int[len + 1];
        	make(bt, sb, 1, len);
        	if(possible(bt, 1, len)) answer[idx] = 1;
        }
        
        return answer;
    }

	private boolean possible(int[] bt, int idx, int len) {
		int left = idx * 2;
		int right = left + 1;
		boolean l = true;
		boolean r = true;
		if(right <= len) {
			l = possible(bt, left, len);
			if(!l) return false;
			if(bt[idx] == 0 && (bt[left] == 1 || bt[right] == 1)) return false;
			r = possible(bt, right, len);
			if(!r) return false;
		}
		
		return true;
	}

	private void make(int[] bt, StringBuilder sb, int idx, int len) {
		int left = idx * 2;
		int right = left + 1;
		if(right <= len) {
			make(bt, sb, left, len);
			bt[idx] = sb.charAt(bIdx++) - '0';
			make(bt,sb, right, len);
		}
		else bt[idx] = sb.charAt(bIdx++) - '0';
	}


}
