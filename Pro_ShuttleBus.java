import java.util.StringTokenizer;
import java.util.Arrays;

public class Pro_ShuttleBus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int tableLen = timetable.length;
        int[] crues = new int[tableLen];
        final int hour = 60, start = 9;
        
        for(int idx = 0; idx < tableLen; ++idx) {
        	StringTokenizer st = new StringTokenizer(timetable[idx], ":");
        	crues[idx] = Integer.parseInt(st.nextToken()) * hour + Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(crues);
        int crueIdx = 0;
        int tmpAnswer = 0;
        for(int bus = 0; bus < n; ++bus) {
        	int busTime = (start * hour) + (t * bus);
        	int passenger = 0;
        	int latestPassenger = 0;
        	for(int idx = crueIdx; idx < crues.length; ++idx) {
        		if(passenger == m) break;
        		if(crues[idx] <= busTime) {
        			++passenger;
        			latestPassenger = crues[idx];
        			crueIdx = idx + 1;
        		}
        		else break;
        	}
        	if(passenger == m) tmpAnswer = latestPassenger - 1;
        	else tmpAnswer = busTime;
        }
        
        
        answer = String.format("%02d", tmpAnswer/hour) + ":" + String.format("%02d",tmpAnswer%hour); 
        
        return answer;
    }

}
