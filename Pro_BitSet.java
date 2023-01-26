
public class Pro_BitSet {

	public static void main(String[] args) {

		Pro_BitSet PBS = new Pro_BitSet();
		System.out.println(PBS.solution(4, 30, 118));

	}
	
    final int UNIT = 5;
	
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        answer = makeSet(1, '1', n, l, r);
        
        return answer;
    }

	private int makeSet(long start, char num, int n, long l, long r) {
		long end = start + UNIT - 1;
		
		if(n == 0) {
			int result = (int)(Math.min(r, end) - Math.max(start, l)) + 1;
			if(result > 2) --result;
			if(num == '1') return result;
			else return 0;
		}
		
		else {
			int result = 0;
			long next = (long)Math.pow(5, n);
			String set = null;
			if(num == '1') set = "11011";
			else return 0;
			
			for(int idx = 0; idx < UNIT; ++idx) {
				long s = start + next * idx;
				long e = start + next * (idx + 1) - 1;
				
				if(e < l || r < s) continue;
				else result += makeSet(s, set.charAt(idx), n - 1, l, r);
			}
			
			return result;
		}
	}

}
