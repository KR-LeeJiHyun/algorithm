
public class Pro_2DiffBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] numbers = {43};
		solution(numbers);
	}
	
    public static long[] solution(long[] numbers) {
    	int len = numbers.length;
        long[] answer = new long[len];
        
        for(int idx = 0; idx < len; ++idx) {
        	long result = 0l;
        	long current = numbers[idx];
        	StringBuilder cBinary = new StringBuilder(Long.toBinaryString(current));
        	int cLen = cBinary.length();
        	
        	for(int bIdx = cLen - 1; bIdx >= 0; --bIdx) {
        		if(cBinary.charAt(bIdx) == '0') {
        			cBinary.setCharAt(bIdx, '1');
        			for(int sIdx = bIdx + 1; sIdx < cLen; ++sIdx) {
        				if(cBinary.charAt(sIdx) == '1') {
        					cBinary.setCharAt(sIdx, '0');
        					break;
        				}
        			}
        			result = Long.parseLong(cBinary.toString(), 2);
        			break;
        		}
        	}
        	
        	if(result == 0l) {
    			cBinary.reverse();
    			cBinary.setCharAt(0, '0');
    			result = Long.parseLong('1' + cBinary.toString(), 2);
    		}
        	
        	answer[idx] = result;
        }
        
        return answer;
    }

}
