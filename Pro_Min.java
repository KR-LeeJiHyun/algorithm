import java.util.Collections;
import java.util.PriorityQueue;

public class Pro_Min {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int solution(int []A, int []B)
    {
        int answer = 0, len = A.length;

        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int idx = 0; idx < len; ++idx) {
        	a.add(A[idx]);
        	b.add(B[idx]);
        }
        
        while(!a.isEmpty()) answer += (a.poll() * b.poll());

        return answer;
    }
    
}
