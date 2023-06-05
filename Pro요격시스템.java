import java.util.PriorityQueue;

public class Pro요격시스템 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Missile implements Comparable<Missile>{
		
		public int s;
		public int e;
		
		public Missile(int s, int e) {
			this.s = s;
			this.e = e;
		}



		@Override
		public int compareTo(Missile o) {
			return this.e - o.e;
		}
	}
	
    public int solution(int[][] targets) {
    	
        int answer = 0;
        
        PriorityQueue<Missile> pq = new PriorityQueue<>();
        for(int idx = 0; idx < targets.length; ++idx) {
        	pq.add(new Missile(targets[idx][0], targets[idx][1]));
        }
        
        Missile prev = pq.poll();
        int e = prev.e;
        answer = 1;
        
        
        while(!pq.isEmpty()){
        	Missile current = pq.poll();
        	if(e <= current.s) {
        		++answer;
        		e = current.e;
        	}
        }
        
        return answer;
    }

}
