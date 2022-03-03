import java.util.HashMap;
public class Pro_Camouflage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int idx = 0; idx < clothes.length; ++idx) {
        	String key = clothes[idx][1];
        	if(!map.containsKey(key)) map.put(key, 0);
        	map.put(key, map.get(key) + 1);
        }
        
        for(String key : map.keySet()) {
        	answer *= (map.get(key) + 1);
        }
        
        --answer;
        return answer;
    }

}
