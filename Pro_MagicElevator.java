
public class Pro_MagicElevator {

	public static void main(String[] args) {
		
		Pro_MagicElevator PME = new Pro_MagicElevator();
		System.out.println(PME.solution(155));
		System.out.println(PME.solution(154));
		System.out.println(PME.solution(75));
		System.out.println(PME.solution(555));

	}
	
    public int solution(int storey) {
    	
        int answer = 0;
        
        final int UNIT = 10;
        
        while(storey > 0) {
        	int mod = storey % UNIT;
        	int cnt = UNIT - mod;
        	if(mod < cnt) {
        		answer += mod;
        		storey /= UNIT;
        	}
        	
        	else if(mod == cnt) {
        		int storey10 = storey / UNIT;
        		int mod10 = storey10 % (UNIT);
        		if(mod10 < mod) {
        			answer += mod;
            		storey /= UNIT;
        		}
        		else {
        			answer += cnt;
            		storey /= UNIT;
            		++storey;
        		}
        	}
        	
        	else {
        		answer += cnt;
        		storey /= UNIT;
        		++storey;
        	}	
        }
        
        //answer = dfs(storey, 0);
        
        return answer;
        
    }

	private int dfs(int storey, int answer) {
		
		if(storey == 0) return answer;
		
		int mod = storey % 10;
		int tmp1 = dfs(storey / 10, answer + mod);
		int tmp2 = Integer.MAX_VALUE;
		if(mod > 4) tmp2 = dfs(storey / 10 + 1, answer + (10 - mod));
		answer = Math.min(tmp1, tmp2);
		return answer;
		
	}

}
