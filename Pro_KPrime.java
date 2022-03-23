import java.util.StringTokenizer;

public class Pro_KPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 437674, k = 3;
		solution(n, k);
	}
	
    public static int solution(int n, int k) {
        int answer = 0;
        
        String kN = trans(n, k);
        StringTokenizer st = new StringTokenizer(kN, "0");
        
        while(st.hasMoreElements()) {
        	long x = Long.parseLong(st.nextToken());
        	if(isPrime(x)) ++answer;
        }
        
        return answer;
    }

	private static String trans(int n, int k) {
		String result = "";
		while(n > 0) {
			result = (n % k) + result;
			n /= k;
		}
		return result;
	}
	
	public static boolean isPrime(long x) {
		if(x < 2) return false;
		for(long idx = 2; idx <= Math.sqrt(x); ++idx) {
			if(x % idx == 0) return false;
		}
		return true;
	}

}
