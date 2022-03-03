import java.util.HashMap;
import java.util.ArrayList;

public class Pro__Cheater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"*rodo", "*rodo", "******"};
		solution(user_id, banned_id);
	}
	
    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        int user_len = user_id.length, banned_len = banned_id.length;
        HashMap<String, Boolean> visited = new HashMap();
        HashMap<String, Integer> bitmask = new HashMap();
        ArrayList<String>[] cheaters = new ArrayList[banned_len];
        
        for(int idx = 0; idx < user_len; ++idx) bitmask.put(user_id[idx], idx);
        for(int idx = 0; idx < banned_len; ++idx) cheaters[idx] = new ArrayList<String>();
        
        for(String user : user_id) { 
        	visited.put(user, false);
        	int idx = 0;
        	for(String banned : banned_id) {
        		if(check(user, banned)) {
        			cheaters[idx].add(user);
        		}
        		++idx;	
        	}
        }
        ArrayList<String> path = new ArrayList<String>();
        HashMap<Integer, Boolean> visited2 = new HashMap<Integer, Boolean>();
        answer += combine(cheaters, visited, 0, 0, visited2, bitmask);

        
        return answer;
    }

	public static boolean check(String user, String banned) {
    	if(user.length() != banned.length()) return false;
    	
    	for(int idx = 0; idx < banned.length(); ++idx) {
    		char tmp = banned.charAt(idx);
    		if(tmp == '*') continue;
    		if(user.charAt(idx) != tmp) return false;
    	}
    	
    	return true;
    }
	
    private static int combine(ArrayList<String>[] cheaters, HashMap<String, Boolean> visited, int idx, int bit, HashMap<Integer, Boolean> visited2, HashMap<String, Integer> bitmask) {
		int result = 0;
    	if(idx == cheaters.length) {
    		if(!visited2.containsKey(bit)) {
    			visited2.put(bit, false);
    			return 1;
    		}
    		return 0;
    	}
    	
    	for(String cheater : cheaters[idx]) {
    		if(!visited.get(cheater)) {
    			visited.put(cheater, true); 
    			result += combine(cheaters, visited, idx + 1, bit | 1<<bitmask.get(cheater), visited2, bitmask);
    			visited.put(cheater, false);
    		}
    	}
    	
		return result;
	}
}
