import java.util.Arrays;

public class Pro연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int len = sequence.length;
        int[] answer = {0, len - 1};
        
        if(k == sequence[0]) {
        	answer[0] = 0;
        	answer[1] = 0;
        	return answer;
        }
        
        int[] prefix = new int[len];
        prefix[0] = sequence[0];
        for(int idx = 1; idx < len; ++idx){
        	prefix[idx] = prefix[idx - 1] + sequence[idx];
        	
        	if(prefix[idx] == k) {
        		int dis = idx;
    			int aDis = answer[1] - answer[0];
    			if(dis < aDis) {
    				answer[0] = 0;
    				answer[1] = idx;
    			}
        	}
        	
        	else if(prefix[idx] > k) {
        		int fIdx = Arrays.binarySearch(prefix, 0, idx, prefix[idx] - k);
        		if(fIdx > -1) {
        			int dis = idx - fIdx - 1;
        			int aDis = answer[1] - answer[0];
        			if(dis < aDis) {
        				answer[0] = fIdx + 1;
        				answer[1] = idx;
        			}
        		}
        	}
        }
        
        return answer;
    }
}
