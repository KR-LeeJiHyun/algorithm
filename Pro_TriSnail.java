
public class Pro_TriSnail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		solution(n);
	}
	
    public static int[] solution(int n) {
    	int len = 0;
    	for(int idx = n; idx > 0; --idx) len += idx;
        int[] answer = new int[len];
        int idx = 0, arrow = 0, cnt = 1, tmp = n, k = 1;
        while(cnt <= len) {
        	answer[idx] = cnt++;
        	if(tmp != 1) {
        		if(arrow == 0) idx += k++;
        		else if(arrow == 1) ++idx;
        		else idx -= k--;
        		--tmp;
        	}
        	else {
        		tmp = --n;
        		arrow = (arrow + 1) % 3;
        		if(arrow == 0) idx += k++;
        		else if(arrow == 1) ++idx;
        		else idx -= k--;
        	}
        }
        
        return answer;
    }

}
