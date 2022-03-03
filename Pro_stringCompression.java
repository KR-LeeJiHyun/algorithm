import java.util.ArrayList;

public class Pro_stringCompression {
	
	public static int solution(String s) {
        int answer = s.length();
        ArrayList<String> stack = new ArrayList<String>();
        
        for(int div = 1; div <= s.length() / 2; ++div) {
        	String tmp_answer = "";
        	for(int idx = 0; idx <s.length(); idx = idx + div) {
        		String token = "";
        		
        		if(idx + div < s.length()) token = s.substring(idx, idx + div);
        		else token = s.substring(idx);
        		
        		if(stack.isEmpty()) stack.add(token);
        		else {
        			//if(!stack.contains(token)) {
        			if(!stack.get(0).equals(token)) {
        				if(stack.size() > 1) tmp_answer += stack.size() + stack.get(0);
        				else tmp_answer += stack.get(0);
        				stack.clear();
        			}
        			stack.add(token);
        		}
        	}
        	if(!stack.isEmpty()) {
				if(stack.size() > 1) tmp_answer += stack.size() + stack.get(0);
				else tmp_answer += stack.get(0);
				stack.clear();
			}
        	if(answer > tmp_answer.length()) answer = tmp_answer.length();
        }
        
        return answer;
    }

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabbaccc";
		
		solution(s);
	}*/

}
