import java.util.LinkedList;
import java.util.Queue;

public class Pro_TransNum {

	public static void main(String[] args) {
		Pro_TransNum PTN = new Pro_TransNum();
		PTN.solution(10, 40, 5);
	}
	
	class Num {
		int x;
		int cnt;
		
		public Num(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
	
    public int solution(int x, int y, int n) {
    	boolean[] visited = new boolean[y + 1];
    	Queue<Num> q = new LinkedList<>();
    	
    	visited[x] = true;
    	q.add(new Num(x, 0));
    	
    	while(!q.isEmpty()) {
    		Num num = q.poll();
    		int plus = num.x + n;
    		int mul2 = num.x * 2;
    		int mul3 = num.x * 3;
    		int cnt = num.cnt + 1;
    		
    		if(plus == y || mul2 == y || mul3 == y) {
    			return cnt;
    		}
    		
    		if(plus < y && !visited[plus]) {
    			visited[plus] = true;
    			q.add(new Num(plus, cnt));
    		}
    		
    		if(mul2 < y && !visited[mul2]) {
    			visited[mul2] = true;
    			q.add(new Num(mul2, cnt));
    		}
    		
    		if(mul3 < y && !visited[mul3]) {
    			visited[mul3] = true;
    			q.add(new Num(mul3, cnt));
    		}
    	}
    	
        return -1;
    }

}
