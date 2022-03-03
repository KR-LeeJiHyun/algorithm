import java.util.Queue;
import java.util.LinkedList;

public class Pro_BiregePass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bridge_length = 100; 
		int weight = 100;
		int[] truck_weights = {10};
		
		solution(bridge_length, weight, truck_weights);
	}
	
	static class Truck{
		int weight;
		int time;
		
		public Truck() {
			this.weight = 0;
			this.time = 0;
		}
		
		public Truck(int weight, int time) {
			this.weight = weight;
			this.time = time;
		}
	}
	
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Truck> queue = new LinkedList<>();
        int idx = 0, sum = 0;
        
        while(idx < truck_weights.length || !queue.isEmpty()) {
        	++answer;
        	if(!queue.isEmpty()) {
        		Truck tmp = queue.peek();
        		if(answer - tmp.time == bridge_length) {
        			queue.poll();
        			sum -= tmp.weight;
        		}
        	}
        	if(idx < truck_weights.length && queue.size() < bridge_length && sum + truck_weights[idx] <= weight) {
        		queue.add(new Truck(truck_weights[idx], answer));
        		sum += truck_weights[idx++];
        	}
        }
        
        return answer;
    }

}
