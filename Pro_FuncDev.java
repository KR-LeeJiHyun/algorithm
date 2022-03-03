import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Pro_FuncDev {
	
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> tmp_answer = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        for(int idx = 0; idx < progresses.length; ++idx) {
        	int day = 100 - progresses[idx];
        	if(day%speeds[idx] != 0) day = day/speeds[idx] + 1;
        	else day = day/speeds[idx];
        	
        	queue.offer(day);
        }
        
        int pre_func = queue.poll();
        int count = 1;
        
        while(!queue.isEmpty()) {
        	int current_func = queue.poll();
        	if(pre_func < current_func) {
        		tmp_answer.add(count);
        		count = 1;
        		pre_func = current_func;
        	}
        	else ++count;
        }
        
        tmp_answer.add(count);
        
        answer = new int[tmp_answer.size()];
        
       int idx = 0;
       for(int tmp : tmp_answer) {
    	   answer[idx++] = tmp;
       }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		solution(progresses, speeds);
	}

}
