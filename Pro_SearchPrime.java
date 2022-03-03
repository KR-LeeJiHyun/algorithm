import java.util.HashSet;

public class Pro_SearchPrime {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numbers = "17";
		solution(numbers);
	}
	
    public static int solution(String numbers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        
        permutation("", numbers, set, 0);
        
        for(int prime : set) {
        	if(isPrime(prime)) ++answer;
        }
        
        return answer;
    }

    public static void permutation(String permu, String numbers, HashSet<Integer> set, int mask) {
    	int len = numbers.length();
    	for(int idx = 0; idx < len; ++idx) {
    		if((mask & 1 << idx) == 0) {
    			String tmp = permu + numbers.charAt(idx);
    			set.add(Integer.parseInt(tmp));
    			permutation(tmp, numbers, set, mask | (1 << idx));
    		}
    	}
    }
    
	public static boolean isPrime(int x) {
		if(x < 2) return false;
		for(int idx = 2; idx <= Math.sqrt(x); ++idx) {
			if(x % idx == 0) return false;
		}
		return true;
	}
}
