import java.util.PriorityQueue;

public class Pro_Balloon {

	public static void main(String[] args) {
		int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
		solution(a);
	}
	
    public static int solution(int[] a) {
        int answer = 2, aLen = a.length;
        if(aLen < 3) return aLen;
        int left = a[0];
        PriorityQueue<Integer> right = new PriorityQueue<>();
        right.add(a[aLen - 1]);
        for(int idx = aLen - 2; idx > 0; --idx) {
        	if(right.peek() > a[idx]) right.add(a[idx]);
        }
        
        for(int idx = 1; idx < aLen - 1; ++idx) {
        	int current = a[idx];
        	if(right.peek() == current) right.poll();
        	if(current < left || current < right.peek()) ++answer;
        	if(current < left) left = current;
        }
        
        return answer;
    }

}
