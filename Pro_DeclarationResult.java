import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Pro_DeclarationResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String, ArrayList<String>> log = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();
        
        for(String id : id_list) {
        	log.put(id, new ArrayList<>());
        	result.put(id, 0);
        }
        
        for(String rep : report) {
        	StringTokenizer st = new StringTokenizer(rep);
        	String user = st.nextToken(), target = st.nextToken();
        	ArrayList<String> list = log.get(target);
        	if(!list.contains(user)) log.get(target).add(user);
        }
        
        for(String key : log.keySet()) {
        	ArrayList<String> list = log.get(key);
        	if(list.size() >= k) {
        		for(String rKey : list) {
        			result.put(rKey, result.get(rKey) + 1);
        		}
        	}
        }
 
        for(int idx = 0; idx < id_list.length; ++idx) {
        	answer[idx] = result.get(id_list[idx]);
        }
        
        return answer;
    }
}
