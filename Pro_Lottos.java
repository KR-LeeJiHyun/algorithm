import java.util.Arrays;

public class Pro_Lottos {
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        int win_idx = 0, zero_count = 0, count = 0, place = 6;
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        for(int idx = 0; idx < lottos.length; ++idx) {
        	if(lottos[idx] != 0) {
        		for(int i = win_idx; i < win_nums.length; ++i) {
        			if(lottos[idx] == win_nums[i]) {
        				++count;
        				win_idx = i; 
        			}
        		}
        	}
        	else ++zero_count;
        }
        
        int predic = count + zero_count - 1;
        
        if(predic < 1) predic = 0;
        answer[0] = place - predic;
        
        if(count == 0) count = 1;
        answer[1] = place - (count - 1);
        
        return answer;
    }

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lottos = {44, 1, 0, 0, 31, 25}, win_nums = {31, 10, 45, 1, 6, 19};
		
		solution(lottos, win_nums);

	}*/

}
