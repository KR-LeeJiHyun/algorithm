import java.util.LinkedHashMap;
import java.util.ArrayList;

public class Pro_BrianWorry {
	
	public static String solution(String sentence) {
        String answer = "";
        String invalid = "invalid";
        int sen_len = sentence.length();
        ArrayList<Integer> start_list = new ArrayList<>(), end_list = new ArrayList<>(), rule_list = new ArrayList<>();
        ArrayList<Character> special_list = new ArrayList<>();
        
        //������ �����ϸ� �ȵǹǷ� invalid ����
        if(sentence.contains(" ")) return invalid;
        
        //Ư�������� ��ġ�� ����� �ؽ�(���� ������ �ʿ��ϹǷ� LinkedHashMap ���)
        LinkedHashMap<Character, ArrayList<Integer>> hash = new LinkedHashMap<Character, ArrayList<Integer>>();
        
        //Ư������ �ε���
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
        //Ư������ ��Ģ �ľ�
        for(char special : hash.keySet()) {
        	ArrayList<Integer> special_idx = hash.get(special);
        	int start = special_idx.get(0), special_idx_size = special_idx.size();
        	//�� ��Ģ�̶� �������
        	if(prev_end < start) {
        
        		//��Ģ2
        		if(special_idx_size == 2) {
        			//���� �ȵ� ���� ó��
        			if(start - prev_end > 1) {
        				start_list.add(prev_end + 1);
        				end_list.add(start - 1);
        				rule_list.add(0);
        			}
        			int end = special_idx.get(1);
        			if(end - start < 2) return invalid;
        			//���ǿ� �����ϹǷ� �ε��� ����
        			start_list.add(start);
        			end_list.add(end);
        			rule_list.add(2);
        			prev_end = end;
        			prev_rule = 2;
        		}
        		
        		//��Ģ1
        		else {
        			start = start - 1;
        			//���� �ȵ� ���� ó��
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
        			//���ǿ� �����ϹǷ� �ε��� ����
        			start_list.add(start);
        			end_list.add(end);
        			rule_list.add(1);
        			special_list.add(special);
        			prev_end = end;
        			prev_rule = 1;
        		}
        	}
        	//��Ģ �� �� ����
        	else {
        		//�� ��Ģ�� 2�� �ƴϸ� �Ѵܾ 1�� ���� �����̰��̹Ƿ� invalid ��ȯ
        		if(prev_rule != 2) return invalid;
        		start = start -1;
    			if(prev_end == start || start < 0) return invalid;
    			int end = special_idx.get(special_idx_size - 1) + 1;
    			if(prev_end - end != 1) return invalid;
    			for(int idx = 0; idx < special_idx_size - 1; ++idx) {
    				int current = special_idx.get(idx), next = special_idx.get(idx + 1);
    				if(next - current != 2) return invalid;
    			}
    			//���ǿ� �����ϹǷ� �ΰ��� ��Ģ�� ��� ���� ��ٰ� �ؼ� 3�̶�� ���ο� ��Ģ���� ����
    			rule_list.remove(rule_list.size() - 1);
    			rule_list.add(3);
    			special_list.add(special);
    			prev_rule = 3;
        	}
        }
        
        //������ �°� �ܾ� ����
        int special_list_idx = 0;
        for(int idx = 0; idx < rule_list.size(); ++idx) {
        	int rule = rule_list.get(idx), start = start_list.get(idx), end = end_list.get(idx);
        	String tmp_word = sentence.substring(start, end + 1);
        	
        	//��Ģ�� ���� �˸°� �ܾ� ó��
        	if(rule == 1) tmp_word = tmp_word.replace(Character.toString(special_list.get(special_list_idx++)), "");
        	else if(rule == 2) tmp_word = sentence.substring(start + 1, end);
        	else if(rule == 3) {
        		tmp_word = sentence.substring(start + 1, end);
        		tmp_word = tmp_word.replace(Character.toString(special_list.get(special_list_idx++)), "");
        	}
        	
        	//���� ó�� ���� �ܾ �ƴϸ� ������ �߰��Ͽ� �信 ����
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
