
public class Pro_GetInLine {

	public static void main(String[] args) {
		int n = 6, k = 10;
		solution(n, k);
	}
	
    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        boolean[] visited = new boolean[n + 1];
        long cnt = 1;
       
        for(int idx = 0; idx < n; ++idx) {
        	int prev = 0;
        	for(int sIdx = 1; sIdx <= n; ++sIdx) {
        		if(!visited[sIdx]) {
        			long min = cnt + prev * fac(n - idx - 1), max = Math.max((cnt - 1) + (prev + 1) * fac((n - idx - 1)), cnt);
        			if(min <= k && k <= max) {
        				visited[sIdx] = true;
        				answer[idx] = sIdx;
        				cnt = min;
        				break;
        			}
        			++prev;
        		}
        	}
        }
        
        return answer;
    }
    
    public static long fac(int n) {
    	if(n == 0) return 0;
    	
    	long result = 1;
    	
    	while(n != 1) result *= n--;
    	
    	return result;
    }

}
