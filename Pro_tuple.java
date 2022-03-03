import java.util.HashMap;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Pro_tuple {

    public static int[] solution(String s) {
        int[] answer = {};
        s = s.replace("{", "");
        s = s.replace("},", " ");
        s = s.replace("}", "");
        
        HashMap<Integer, ArrayList<Integer>> hash = new HashMap<Integer, ArrayList<Integer>>();
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreElements()) {
        	String tmpSt = st.nextToken();
        	StringTokenizer stHash = new StringTokenizer(tmpSt, ",");
        	int len = stHash.countTokens();
        	hash.put(len, new ArrayList<Integer>());
        	while(stHash.hasMoreElements()) {
        		ArrayList<Integer> tmpList = hash.get(len);
        		tmpList.add(Integer.parseInt(stHash.nextToken()));
        		hash.put(len, tmpList);
        	}
        }
        
        ArrayList<Integer> tmpAnswer = new ArrayList();
        for(int idx = 1; idx <=hash.size(); ++idx) {
        	ArrayList<Integer> tmpHash = hash.get(idx);
        	for(int tmp : tmpHash) {
        		if(!tmpAnswer.contains(tmp)) tmpAnswer.add(tmp);
        	}
        }
        
        answer = new int[tmpAnswer.size()];
        int idx = 0;
        for(int tmp : tmpAnswer) answer[idx++] = tmp;
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		solution(s);
	}

}
