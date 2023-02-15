public class Pro숫자카드나누기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        final int LEN = arrayA.length;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int idx = 1; idx < LEN; ++idx) {
        	gcdA = gcd(gcdA, arrayA[idx]);
        	gcdB = gcd(gcdB, arrayB[idx]);
        }
        
        boolean a = true;
        boolean b = true;
        for(int idx = 0; idx < LEN; ++idx) {
        	if(a) {
        		if(arrayB[idx] % gcdA == 0) {
        			a = false;
        		} 
        	}
        	if(b) {
        		if(arrayA[idx] % gcdB == 0) {
        			b = false;
        		} 
        	}
        	if(!a && !b) {
        		break;
        	}
        }
        
        if(a && b) {
        	answer = Math.max(gcdA, gcdB);
        }
        else if(a) {
        	answer = gcdA;
        }
        else if(b) {
        	answer = gcdB;
        }
        
        return answer;
    }

	private int gcd(int i, int j) {
		int n;
		
		while(j != 0) {
			n = i%j;
			i = j;
			j = n;
		}
		
		return i;
	}

}
