import java.util.LinkedHashMap;
import java.util.ArrayList;

public class Pro_BrianWorry {
	
	public static String solution(String sentence) {
        String answer = "";
        String invalid = "invalid";
        int sen_len = sentence.length();
        ArrayList<Integer> start_list = new ArrayList<>(), end_list = new ArrayList<>(), rule_list = new ArrayList<>();
        ArrayList<Character> special_list = new ArrayList<>();
        
        //공백이 존재하면 안되므로 invalid 리턴
        if(sentence.contains(" ")) return invalid;
        
        //특수문자의 위치를 기록할 해시(순서 유지가 필요하므로 LinkedHashMap 사용)
        LinkedHashMap<Character, ArrayList<Integer>> hash = new LinkedHashMap<Character, ArrayList<Integer>>();
        
        //특수문자 인덱싱
        int s_idx = 0;
        for(char c : sentence.toCharArray()) {
        	if(c >= 'a' && c <= 'z') {
        		if(!hash.containsKey(c)) {
        			hash.put(c, new ArrayList<>());
        		}
        		hash.get(c).add(s_idx);
        	}
        	++s_idx;
        }
        
        int prev_end = -1;
        int prev_rule = 0;
        //특수문자 규칙 파악
        for(char special : hash.keySet()) {
        	ArrayList<Integer> special_idx = hash.get(special);
        	int start = special_idx.get(0), special_idx_size = special_idx.size();
        	//전 규칙이랑 상관없음
        	if(prev_end < start) {
        
        		//규칙2
        		if(special_idx_size == 2) {
        			//변형 안된 문자 처리
        			if(start - prev_end > 1) {
        				start_list.add(prev_end + 1);
        				end_list.add(start - 1);
        				rule_list.add(0);
        			}
        			int end = special_idx.get(1);
        			if(end - start < 2) return invalid;
        			//조건에 부합하므로 인덱스 저장
        			start_list.add(start);
        			end_list.add(end);
        			rule_list.add(2);
        			prev_end = end;
        			prev_rule = 2;
        		}
        		
        		//규칙1
        		else {
        			start = start - 1;
        			//변형 안된 문자 처리
        			if(start - prev_end > 1) {
        				start_list.add(prev_end + 1);
        				end_list.add(start - 1);
        				rule_list.add(0);
        			}
        			if(prev_end == start || start < 0) return invalid;
        			int end = special_idx.get(special_idx_size - 1) + 1;
        			if(end >= sen_len) return invalid;
        			for(int idx = 0; idx < special_idx_size - 1; ++idx) {
        				int current = special_idx.get(idx), next = special_idx.get(idx + 1);
        				if(next - current != 2) return invalid;
        			}
        			//조건에 부합하므로 인덱스 저장
        			start_list.add(start);
        			end_list.add(end);
        			rule_list.add(1);
        			special_list.add(special);
        			prev_end = end;
        			prev_rule = 1;
        		}
        	}
        	//규칙 두 개 적용
        	else {
        		//전 규칙이 2가 아니면 한단어에 1이 연속 적용이것이므로 invalid 반환
        		if(prev_rule != 2) return invalid;
        		start = start -1;
    			if(prev_end == start || start < 0) return invalid;
    			int end = special_idx.get(special_idx_size - 1) + 1;
    			if(prev_end - end != 1) return invalid;
    			for(int idx = 0; idx < special_idx_size - 1; ++idx) {
    				int current = special_idx.get(idx), next = special_idx.get(idx + 1);
    				if(next - current != 2) return invalid;
    			}
    			//조건에 부합하므로 두가지 규칙이 모두 적용 됬다고 해서 3이라는 새로운 규칙으로 저장
    			rule_list.remove(rule_list.size() - 1);
    			rule_list.add(3);
    			special_list.add(special);
    			prev_rule = 3;
        	}
        }
        
        //원형에 맞게 단어 저장
        int special_list_idx = 0;
        for(int idx = 0; idx < rule_list.size(); ++idx) {
        	int rule = rule_list.get(idx), start = start_list.get(idx), end = end_list.get(idx);
        	String tmp_word = sentence.substring(start, end + 1);
        	
        	//규칙에 따라 알맞게 단어 처리
        	if(rule == 1) tmp_word = tmp_word.replace(Character.toString(special_list.get(special_list_idx++)), "");
        	else if(rule == 2) tmp_word = sentence.substring(start + 1, end);
        	else if(rule == 3) {
        		tmp_word = sentence.substring(start + 1, end);
        		tmp_word = tmp_word.replace(Character.toString(special_list.get(special_list_idx++)), "");
        	}
        	
        	//공백 처음 들어가는 단어가 아니면 공백을 추가하여 답에 저장
        	if(answer.length() != 0) answer += " " + tmp_word;
        	else answer = tmp_word;
        	
        	if(idx + 1 == rule_list.size() && end + 1 < sen_len) answer += " " + sentence.substring(end + 1);
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentence = "AaA";
		System.out.println(solution(sentence));
	}

}
