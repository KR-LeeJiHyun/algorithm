import java.util.Comparator;
import java.util.PriorityQueue;

public class Pro_DiscController {
	
	public static class REQ {
		int requestTime;
		int processTime;
		public REQ(int requestTime, int processTime) {
			this.requestTime = requestTime;
			this.processTime = processTime;
		}
	}
	
    public static int solution(int[][] jobs) {
        int answer = 0, time = 0, len = jobs.length;
        
        PriorityQueue<REQ> requestTimePQ = new PriorityQueue<>(new Comparator<REQ>() {
            @Override
            public int compare(REQ o1, REQ o2) {
                return o1.requestTime - o2.requestTime;
            }
        });
        
        PriorityQueue<REQ> processTimePQ = new PriorityQueue<>(new Comparator<REQ>() {
            @Override
            public int compare(REQ o1, REQ o2) {
                return o1.processTime - o2.processTime;
            }
        });
        
        for(int idx = 0; idx < len; ++idx) requestTimePQ.add(new REQ(jobs[idx][0], jobs[idx][1]));
        
        while(!requestTimePQ.isEmpty() || !processTimePQ.isEmpty()) {
        	if(!processTimePQ.isEmpty()) {
        		REQ req = processTimePQ.poll();
        		time += req.processTime;
        		answer += time - req.requestTime;
        	}
        	else {
        		int peekTime = requestTimePQ.peek().requestTime;
        		if(time < peekTime) time = peekTime;
        	}
        	while(!requestTimePQ.isEmpty() && requestTimePQ.peek().requestTime <= time) processTimePQ.add(requestTimePQ.poll());	
        }
        
        return answer / len;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		System.out.print(solution(jobs));
	}

}
