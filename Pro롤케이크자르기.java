import java.util.HashMap;

public class Pro롤케이크자르기 {

	public static void main(String[] args) {
		int[] topping = {1, 2, 3, 1, 4};
		Pro롤케이크자르기 S = new Pro롤케이크자르기();
		S.solution(topping);

	}
	
    public int solution(int[] topping) {
        int answer = 0;
        final int LEN = topping.length;

        HashMap<Integer, Integer> OB = new HashMap();
        HashMap<Integer, Integer> YB = new HashMap();
        
        for(int idx = 0; idx < LEN; ++idx) {
        	int current = topping[idx];
        	YB.put(current, YB.getOrDefault(current, 0) + 1);
        }
        
        for(int idx = 0; idx < LEN; ++idx) {
        	int current = topping[idx];
        	OB.put(current, OB.getOrDefault(current, 0) + 1);
        	YB.put(current, YB.get(current) - 1);
        	if(YB.get(current) == 0) {
        		YB.remove(current);
        	}
        	
        	if(OB.size() == YB.size()) {
        		++answer;
        	}
        	
        	if(OB.size() > YB.size()) {
        		break;
        	}
        }
        
        
        return answer;
    }
}
