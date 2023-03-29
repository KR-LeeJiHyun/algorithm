import java.util.LinkedList;
import java.util.Queue;

public class Pro두큐합같게만들기 {

	public static void main(String[] args) {
		int[] q1 = {1, 10, 1, 2};
		int[] q2 = {1, 2, 1, 2};
		Pro두큐합같게만들기 S = new Pro두큐합같게만들기();
		S.solution(q1, q2);

	}
	
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        int sum1 = 0;
        int sum2 = 0;
        int MAXCNT = queue1.length * 2;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int idx = 0; idx < queue1.length; ++idx) {
        	sum1 += queue1[idx];
        	sum2 += queue2[idx];
        	
        	q1.add(queue1[idx]);
        	q2.add(queue2[idx]);
        }
        
        int cnt = 0;
        while(cnt <= MAXCNT) {
        	if(sum1 == sum2) {
        		return cnt;
        	}
        	else if(sum1 < sum2) {
        		++cnt;
        		int num = q2.poll();
        		sum1 += num;
        		sum2 -= num;
        		q1.add(num);
        	}
        	else {
        		++cnt;
        		int num = q1.poll();
        		sum1 -= num;
        		sum2 += num;
        		q2.add(num);
        	}
        }
        
        return answer;
    }

}
