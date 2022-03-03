
public class Pro_4StepHigh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(2147483647);
	}
	
	static int answer = 0;
	
    public static int solution(int n) {
        noc(1, n, 0);   
        return answer;
    }
    
    public static void noc(int cur, int n, int plus) {
    	cur *= 3;
    	plus += 2;
    	int result = cur + plus;
    	
    	if(result < n) {
    		for(int idx = plus; idx >= plus - 2; --idx) noc(cur + plus - idx, n, idx);
    	}
    	else if(result == n) {
    		++answer;
    		return;
    	}
    	else return;
    }
}
