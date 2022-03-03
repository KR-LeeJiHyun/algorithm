import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Pro_RankingSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] info = {
				"java backend junior pizza 150"
		};
		
		String[] query = {
				"java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250",
				"- and backend and senior and - 150",
				"- and - and - and chicken 100",
				"- and - and - and - 150"
		};
		
		solution(info, query);
	}
	
	static HashMap<String, ArrayList<Integer>> map;
	
    public static int[] solution(String[] info, String[] query) {
        int[] answer = {};
        int queryLen = query.length;
        
        answer = new int[queryLen];
        map = new HashMap<>();
        
        for(String tmp : info) {
        	String[] strList = tmp.split(" ");
        	combine(strList, "", 0);
        }
        
       for(String key : map.keySet()) {
    	   ArrayList<Integer> list = map.get(key);
    	   Collections.sort(list);
       }
        
        int qIdx = 0;
        for(String tmp : query) {
        	tmp = tmp.replace(" and ", "");
        	answer[qIdx++] = binarySearch(tmp);
        }
        
        return answer;
    }
    
    public static void combine(String[] strList, String key, int idx) {
    	if(idx != 4) {
    		combine(strList, key + strList[idx], idx + 1);
    		combine(strList, key + "-", idx + 1);
    	}
    	else {
    		if(!map.containsKey(key)) map.put(key, new ArrayList<>());
    		map.get(key).add(Integer.parseInt(strList[idx]));
    	}
    }
    
    public static int binarySearch(String tmp) {
    	StringTokenizer st = new StringTokenizer(tmp);
    	String key = st.nextToken();
    	int value = Integer.parseInt(st.nextToken());
    	
    	if(!map.containsKey(key)) return 0;
    	
    	ArrayList<Integer> list = map.get(key);
    	//Collections.sort(list); 시간초과
    	int listSize = list.size();
    	int start = 0, end = listSize - 1;
    	
    	while(start <= end) {
    		int mid = (start + end) / 2;
    		
    		if(list.get(mid) >= value) end = mid - 1;
    		else start = mid + 1;
    	}
    	
    	return listSize - start;
    }

}

