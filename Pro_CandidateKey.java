import java.util.ArrayList;
import java.util.HashMap;

public class Pro_CandidateKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] relation = { {"a","1","aaa","c","ng"},
				{"a","1","bbb","e","g"},
				{"c","1","aaa","d","ng"},
				{"d","2","bbb","d","ng"}};
		solution(relation);
	}
	
	static HashMap<String, Integer> map;
	
    public static int solution(String[][] relation) {
        int answer = 0;
        int relLen = relation[0].length;
        
        map = new HashMap<>();
        for(int dep = 1; dep <= relLen; ++dep) {
        	for(int idx = 0; idx < relLen; ++idx) {
        		if(!map.containsKey(Integer.toString(idx))) {
        			ArrayList<Integer> list = new ArrayList<>();
        			list.add(idx);
        			answer += combin(relation, idx, list, dep);
        		}
        	}
        }
        return answer;
    }
    
    public static int combin(String[][] relation, int cIdx, ArrayList<Integer> list, int dep) {
    	if(list.size() == dep) {
    		String candiKey = "";
    		for(int tmp : list) candiKey += Integer.toString(tmp);
    		if(map.containsKey(candiKey)) return 0;
    		HashMap<String, Integer> keyMap = new HashMap<>();
    		
    		for(int row = 0; row < relation.length; ++row) {
    			String key = "";
    			for(int col : list) {
    				key += relation[row][col];
    			}
    			if(keyMap.containsKey(key)) return 0;
    			else keyMap.put(key, 1);
    		}
    		
    		map.put(candiKey, 1);
    		return 1;
    	}
    	else {
    		int result = 0;
    		for(int idx = cIdx + 1; idx < relation[0].length; ++idx) {
                boolean check = true;
    			ArrayList<Integer> tmp = (ArrayList<Integer>) list.clone();
    			tmp.add(idx);
    			String candiKey = "";
        		for(int tmpKey : tmp) candiKey += Integer.toString(tmpKey);
        		for(String tmpKey : map.keySet()) {
        			int count = 0;
        			for(char chkey : candiKey.toCharArray()) {
        				if(tmpKey.contains(Character.toString(chkey))) {
                            ++count;
                        }
        			}
        			if(count == tmpKey.length()) {
        				check = false;
        				break;
        			}
        		}
                if(check) result += combin(relation, idx, tmp, dep);
    		}
    		return result;
    	}
    }

}
