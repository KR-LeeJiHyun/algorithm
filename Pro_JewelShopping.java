import java.util.HashMap;

public class Pro_JewelShopping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] gems = {"A", "B", "B", "C", "A"};
		int[] answer = solution(gems);
		System.out.print(answer[0] + " " + answer[1]);
	}
	
    public static int[] solution(String[] gems) {
    	int len = gems.length;
        int[] answer = {0, len - 1};
        HashMap<String, Integer> hash = new HashMap();
        
        for(String gem : gems) hash.put(gem, 0);
        
        int cnt = 0, start = 0, end = 0, gemCnt = hash.size();
        for(String gem : gems) {
            if(hash.get(gem) == 0) ++cnt;
            hash.put(gem, hash.get(gem) + 1);
            if(cnt == gemCnt) {
        		answer[1] = end;
        		answer[0] = start;
        		++end;
        		break;
        	}
        	++end;
        }
        
        while(hash.get(gems[start]) != 1) {
        	hash.put(gems[start], hash.get(gems[start]) - 1);
        	++start;
        	answer[0] = start;
        }
        
        for(; end < len; ++end) {
        	hash.put(gems[end], hash.get(gems[end]) + 1);
            while(hash.get(gems[start]) != 1) {
            	hash.put(gems[start], hash.get(gems[start]) - 1);
            	++start;
            }
            if(answer[1] - answer[0] > end - start) {
            	answer[0] = start;
            	answer[1] = end;
            }
        }
        
        ++answer[0];
        ++answer[1];
        return answer;
    }
}
