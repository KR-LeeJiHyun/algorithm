import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Pro_OpenChat {
	
    public static String[] solution(String[] record) {
        String[] answer;
        ArrayList<String> tmp_answer = new ArrayList<String>();
        ArrayList<String> id_list = new ArrayList<String>();
        HashMap<String, String> map = new HashMap<>();
        
        for(String tmp_record:record) {
        	StringTokenizer st = new StringTokenizer(tmp_record, " ");
        	String cmd = st.nextToken();
        	String id = st.nextToken();
        	
        	if(cmd.equals("Enter")) {
        		String nick = st.nextToken();
        		tmp_answer.add("´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
        		id_list.add(id);
        		map.put(id, nick);
        	}
        	else if(cmd.equals("Leave")){
        		tmp_answer.add("´ÔÀÌ ³ª°¬½À´Ï´Ù.");
        		id_list.add(id);
        	}
        	else {
        		String nick = st.nextToken();
        		map.put(id, nick);
        	}
        }
        
        answer = new String[tmp_answer.size()];
        
        for(int idx = 0; idx < answer.length; ++idx) {
        	answer[idx] = map.get(id_list.get(idx)) + tmp_answer.get(idx);
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);
	}

}
