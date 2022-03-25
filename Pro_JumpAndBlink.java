
public class Pro_JumpAndBlink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
    public int solution(int n) {
        int ans = 0;
        
        while(n != 0) {
        	if(n % 2 == 0) n /= 2;
        	else {
        		++ans;
        		--n;
        	}
        }
        
        return ans;
    }

}
