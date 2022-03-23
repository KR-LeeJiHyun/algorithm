import java.util.TreeMap;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Pro_ParkingPare {

	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		
		solution(fees, records);
	}
	
    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        int last = 23 * 60 + 59;
        TreeMap<String, ArrayList<Integer>> logs = new TreeMap<>();
        
        for(String record : records) {
        	StringTokenizer st = new StringTokenizer(record);
        	String time = st.nextToken(), num = st.nextToken(), command = st.nextToken();
        	
        	StringTokenizer tSt = new StringTokenizer(time, ":");
        	int mTime = Integer.parseInt(tSt.nextToken()) * 60  + Integer.parseInt(tSt.nextToken());
        	if(!logs.containsKey(num)) logs.put(num, new ArrayList<>());
        	logs.get(num).add(mTime);
        }
        
        answer = new int[logs.size()];
        int idx = 0;
        for(String key : logs.keySet()) {
        	ArrayList<Integer> list = logs.get(key);
        	if(list.size() % 2 != 0) list.add(last);
        	answer[idx++] = calc(fees, list);
        }
        
        return answer;
    }

	private static int calc(int[] fees, ArrayList<Integer> list) {
		int result = fees[1];
		double sum = 0;
		
		for(int idx = 0; idx < list.size(); idx += 2) sum += list.get(idx + 1) - list.get(idx);
		if(sum > fees[0]) result += Math.ceil((sum - fees[0]) / fees[2]) * fees[3];
		
		return result;
	}

}
