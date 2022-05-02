
public class Pro_BestSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int mod = s % n;
        for(int idx = 0; idx < n - mod; ++idx) answer[idx] = s / n;
        for(int idx = n - mod; idx < n; ++idx) answer[idx] = s / n + 1;
        
        if(answer[0] == 0) {
        	answer = new int[1];
        	answer[0] = -1;
        } 
        
        return answer;
    }

}
