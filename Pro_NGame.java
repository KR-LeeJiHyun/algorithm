
public class Pro_NGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder("");
        StringBuilder tmp = new StringBuilder("0");
        int num = 1, len = m * (t - 1) + p;
        
        while(tmp.length() < len) {
        	tmp.append(trans(n, num));
        	++num;
        }
        
        for(int idx = 0; idx < t; ++idx) answer.append(tmp.charAt(idx * m + p - 1));
        
        return answer.toString();
    }

	private StringBuilder trans(int n, int num) {
		StringBuilder result = new StringBuilder("");
		
		while(num > 0) {
			int mod = num % n;
			if(mod == 10) result.append('A');
			else if(mod == 11) result.append('B');
			else if(mod == 12) result.append('C');
			else if(mod == 13) result.append('D');
			else if(mod == 14) result.append('E');
			else if(mod == 15) result.append('F');
			else result.append(Integer.toString(mod));
			num /= n;
		}
		
		return result.reverse();
	}

}
