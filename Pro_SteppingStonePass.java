
public class Pro_SteppingStonePass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		solution(stones, k);
	}

    public static int solution(int[] stones, int k) {
        int answer = 0;
        int left = 0, right = 200000000, len = stones.length;
        
        while(left <= right) {
        	int mid = (left + right) / 2;
        	int cnt = 0;
        	
        	for(int idx = 0; idx < len; ++idx) {
        		if(cnt == k) {
        			right = mid - 1;
        			break;
        		}
        		if(stones[idx] < mid) ++cnt;
        		else cnt = 0;
        	}
        	
        	answer = Math.max(answer, mid);
        	left = mid + 1;
        }
        
        return answer;
    }
}
