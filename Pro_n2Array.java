
public class Pro_n2Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(3, 2 ,5);
	}
	
    public static int[] solution(int n, long left, long right) {
    	final int len = (int) (right - left + 1);
        int[] answer = new int[len];
        for(int idx = 0; idx < len; ++idx) {
        	long loc = left + idx;
        	int div = (int) (loc / n + 1), mod = (int) (loc % n);
        	answer[idx] = div;
        	if(mod + 1 > div) answer[idx] = mod + 1; 
        }
        return answer;
    }

}
