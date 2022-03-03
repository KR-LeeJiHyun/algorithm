import java.util.PriorityQueue;

public class Pro_Scoville {

	public static int solution(int[] scoville, int K) {
        int answer = -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int ele : scoville) {
        	pq.add(ele);
        }
        
        int count = 0;
        while(pq.size() > 1 && pq.peek() < K) {
        	++count;
        	int first = pq.poll(), second = pq.poll();
        	int new_sco = first + (second * 2);
        	pq.add(new_sco);
        }
        
        if(pq.peek() >= K) answer = count;
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scoville = {2,1,3};
		int K = 1;
		solution(scoville, K);
	}

}
