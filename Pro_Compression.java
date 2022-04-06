import java.util.ArrayList;
import java.util.HashMap;

public class Pro_Compression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "KAKAO";
		solution(msg);
	}
	
    public static int[] solution(String msg) {
        int[] answer = {};
        ArrayList<Integer> tmp = new ArrayList<>();
        HashMap<String, Integer> dic = new HashMap<>();
        for(int idx = 0; idx < 26; ++idx) dic.put(Character.toString('A' + idx), idx + 1);
        StringBuilder sb = new StringBuilder("");
        for(int idx = 0; idx < msg.length(); ++idx) {
        	char c = msg.charAt(idx);
        	String key = sb.toString();
        	if(!dic.containsKey(key + c)) {
        		tmp.add(dic.get(key));
        		dic.put(key + c, dic.size() + 1);
        		sb = new StringBuilder("");
        	}
        	sb.append(c);
        }
        
        if(sb.length() != 0) tmp.add(dic.get(sb.toString()));
        
        answer = new int[tmp.size()];
        for(int idx = 0; idx <tmp.size(); ++idx) answer[idx] = tmp.get(idx);
        return answer;
    }

}
