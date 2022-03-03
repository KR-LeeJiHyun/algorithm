public class Pro_124World {
	public static String solution(int n) {
        String answer = "";
        int[] number = {4, 1, 2};
        
        StringBuffer sb = new StringBuffer();
        
        while(n != 0) {
        	int mod = n%3;
        	sb.insert(0, Integer.toString(number[mod]));
        	if(mod != 0) n = n / 3;
        	else n = n / 3 - 1;
        }
        
        answer = sb.toString();
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(solution(111));
	}

}
