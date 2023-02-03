import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Pro_Hotel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Room implements Comparable<Room>{
		int start;
		int end;
		
		Room(String[] time) {
			start = trans(time[0]);
			end = trans(time[1]);
		}

		private int trans(String string) {
			StringTokenizer st = new StringTokenizer(string, ":");
			return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
		}
		
		public int compareTo(Room o) {
			return this.start - o.start;
		}

	}
	
    public int solution(String[][] book_time) {
        int answer = 0;
        
        PriorityQueue<Room> sPq = new PriorityQueue<>();
        PriorityQueue<Integer> ePq = new PriorityQueue<>();
        for(int idx = 0; idx < book_time.length; ++idx) {
        	sPq.add(new Room(book_time[idx]));
        }
        
        ePq.add(sPq.poll().end);
        while(!sPq.isEmpty()) {
        	Room room = sPq.poll();
        	int start = room.start;
        	int end = room.end;
        	if(ePq.peek() + 10 <= start) {
        		ePq.poll();
        	}
        	ePq.add(end);
        }
        
        answer = ePq.size();
        return answer;
    }
    

}
