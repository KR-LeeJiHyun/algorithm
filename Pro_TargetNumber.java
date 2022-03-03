import java.util.Queue;
import java.util.LinkedList;

public class Pro_TargetNumber {
	
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(numbers[0]);
        q.offer(1);
        q.offer(-numbers[0]);
        q.offer(1);
        
        while(!q.isEmpty()) {
        	int number = q.poll();
        	int idx = q.poll();
        	
        	if(idx == numbers.length) {
        		if(number == target) ++answer;
        	}
        	else {
        		q.offer(number + numbers[idx]);
        		q.offer(idx + 1);
        		
        		q.offer(number - numbers[idx]);
        		q.offer(idx + 1);
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		
		solution(numbers, target);
	}

}
