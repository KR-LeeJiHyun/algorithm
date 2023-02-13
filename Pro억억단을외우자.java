import java.util.HashMap;

public class Pro억억단을외우자 {

	public static void main(String[] args) {
		int e = 8;
		int[] starts = {1, 3, 7};
		
		Pro억억단을외우자 s = new Pro억억단을외우자();
		s.solution(e, starts);
	}
	
    public int[] solution(int e, int[] starts) {
    	final int LEN = starts.length;
        int[] answer = new int[LEN];
        int[][] dp = new int[e + 1][2];
        dp[e][0] = e;
        dp[e][1] = getFactorCnt(e);
        
        for(int num = e - 1; num > 0; --num) {
        	int cnt = getFactorCnt(num);
        	
        	if(cnt >= dp[num + 1][1]) {
        		dp[num][0] = num;
        		dp[num][1] = cnt;
        	}
        	else {
        		dp[num][0] = dp[num + 1][0];
        		dp[num][1] = dp[num + 1][1];
        	}
        }
        
        for(int idx = 0; idx < LEN; ++idx) {
        	answer[idx] = dp[starts[idx]][0];
        }
        
        return answer;
        
        /*
        int[] res = new int[starts.length];

        int[] count = new int[e + 1];
        for (int i = 1; i <= e; i++) {
            for (int j = 1; j <= e / i; j++) {
                count[i * j]++;
            }
        }

        int[] max = new int[e + 1];
        max[e] = e;
        for (int i = e - 1; i >= 1; i--) {
            if (count[i] >= count[max[i + 1]]) {
                max[i] = i;
            } else {
                max[i] = max[i + 1];
            }
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = max[starts[i]];
        }
        return res; 
        */
    }

	private int getFactorCnt(int num) {
		HashMap<Integer, Integer> map = new HashMap();
		for(int div = 2; div <= Math.sqrt(num); ++div) {
			while(num % div == 0) {
				num /= div;
				map.put(div, map.getOrDefault(div, 0) + 1);
			}
		}
		
		if(num != 1) {
			map.put(num, 1);
		}
		
		int cnt = 1;
		for(int key : map.keySet()) {
			cnt *= map.get(key) + 1;
		}
		
		return cnt;
	}

}
