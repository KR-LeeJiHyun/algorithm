import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Pro_DoublePriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] operations = {"D 1", "I 16", "I 16","D 1"};
		solution(operations);
	}
	
    public static int[] solution(String[] operations) {
        int[] answer = {0, 0};
        
        ArrayList<Integer> queue = new ArrayList<>();
        
        for(String operation : operations) {
        	StringTokenizer st = new StringTokenizer(operation);
        	String op = st.nextToken();
        	int value = Integer.parseInt(st.nextToken());
        	
        	if(op.compareTo("I") == 0){
        		queue.add(value);
                int len = queue.size();
                if(len > 1&& queue.get(len - 2) > queue.get(len - 1)) Collections.sort(queue);
        	}
        	
        	else if(!queue.isEmpty()) {
                int len = queue.size();
        		if(value == 1) queue.remove(len - 1);
        		else queue.remove(0);
        	}	
        }
        
        if(!queue.isEmpty()) {
        	answer[1] = queue.get(0);
        	answer[0] = queue.get(queue.size() - 1);
        }
        
        return answer;
    }

}
