import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.Iterator;

public class Pro_Printer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] priorities = {4, 2, 1, 3 ,2};
		int location = 2;
		solution(priorities, location);
	}
	
    public static int solution(int[] priorities, int location) {
        int answer = location;
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList();
        for(int idx = 0; idx < priorities.length; ++idx) {
        	map.put(idx, priorities[idx]);
        	q.add(idx);
        }
        
        int count = 0;
        
        while(!q.isEmpty()) {
        	Iterator<Integer> it = q.iterator();
        	int current = it.next();
        	while(it.hasNext()) {
        		if(map.get(current) < map.get(it.next())) {
        			q.add(current);
        			break;
        		}
        	}
        	q.poll();
        	if(!q.contains(current)) {
        		++count;
        		if(location == current) {
        			answer = count;
        			break;
        		}
        	}
        	
        }
        
        return answer;
    }

}
