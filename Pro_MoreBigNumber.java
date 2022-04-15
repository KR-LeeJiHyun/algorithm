
public class Pro_MoreBigNumber {

	public static void main(String[] args) {

	}
	
    public int solution(int n) {
        int answer = 0, zcnt = 0, ocnt = 0, end = 0;
        String binary = Integer.toBinaryString(n);
        StringBuilder binaryAnswer = new StringBuilder("");
        boolean check = false;
        
        for(int idx = binary.length() - 1; idx >= 0; --idx) {
        	if(binary.charAt(idx) == '0') {
        		if(!check) ++zcnt;
        		else {
        			end = idx;
        			break;
        		}
        	}
        	else {
        		check = true;
        		++ocnt;
        	}
        }
        
        for(int idx = 0; idx < end; ++idx) binaryAnswer.append(binary.charAt(idx));
        binaryAnswer.append("10");
        --ocnt;
        for(int idx = 0; idx < zcnt; ++idx) binaryAnswer.append('0');
        for(int idx = 0; idx < ocnt; ++idx) binaryAnswer.append('1');
        
        answer = Integer.valueOf(binaryAnswer.toString(), 2);
        return answer;
    }

}
