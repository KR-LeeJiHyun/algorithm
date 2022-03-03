import java.util.ArrayList;

public class Pro_NewsClustring {
	
    public static int solution(String str1, String str2) {
        int answer = 0;
        final int number = 65536;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        ArrayList<String> A, B;
        A = new ArrayList();
        B = new ArrayList();
        
        for(int idx = 0; idx < str1.length() - 1; ++idx) {
        	char firstEle = str1.charAt(idx), secondEle = str1.charAt(idx + 1);
        	if(firstEle <='z' && 'a' <= firstEle && secondEle <='z' && 'a' <= secondEle) A.add((Character.toString(firstEle) + Character.toString(secondEle)));
        }
        
        for(int idx = 0; idx < str2.length() - 1; ++idx) {
        	char firstEle = str2.charAt(idx), secondEle = str2.charAt(idx + 1);
        	if(firstEle <='z' && 'a' <= firstEle && secondEle <='z' && 'a' <= secondEle) B.add((Character.toString(firstEle) + Character.toString(secondEle)));
        }
        
        float sum = A.size() + B.size();
        float count = 0;
        
        if(sum == 0) return number;
        
        for(String tmp : B) {
        	int idx = A.indexOf(tmp);
        	if(idx != -1 ) {
        		A.remove(idx);
        		++count;
        	}
        }
        sum = sum - count;
        
        answer = (int)(count / sum * number);
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "aa1+aa2", str2 = "AAAA12";
		solution(str1, str2);
	}

}
