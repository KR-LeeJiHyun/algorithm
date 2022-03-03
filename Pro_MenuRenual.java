import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Pro_MenuRenual {
	
	public static TreeMap<String, Integer> menu_conbination(TreeMap<String, Integer> course_candi, char[] order, int c_idx, String menu) {
		if(menu.length() > 1) {
			if(!course_candi.containsKey(menu)) course_candi.put(menu, 1);
			else course_candi.put(menu, course_candi.get(menu) + 1);
		}
		
		for(int idx = c_idx; idx < order.length; ++idx) {
			course_candi = menu_conbination(course_candi, order, idx + 1, menu + order[idx]);
		}
		
		return course_candi;
	}
	
	public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        ArrayList<String> tmp_answer = new ArrayList<>();
        
        TreeMap<String, Integer> course_candi = new TreeMap<String, Integer>();
        for(String tmp_order : orders) {
        	char[] order = tmp_order.toCharArray();
        	Arrays.sort(order);
        	course_candi = menu_conbination(course_candi, order, 0, "");
        }
        
        int[] max_count = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}; 
        ArrayList<String>[] matrix_answer = new ArrayList[11];
        for(int idx = 2; idx < 11; ++idx) matrix_answer[idx] = new ArrayList<>();
        for(String tmp : course_candi.keySet()) {
        	int cnt = course_candi.get(tmp);
        	int len = tmp.length();
        	for(int course_len : course) {
        		if(len == course_len) {
        			if(cnt == max_count[len]) matrix_answer[len].add(tmp); 
        			else if (cnt > max_count[len]) {
        				max_count[len] = cnt;
        				matrix_answer[len] = new ArrayList<>();
        				matrix_answer[len].add(tmp); 
        			}
        		}
        	}
        }
        
        for(int idx = 2; idx < 11; ++idx) {
        	for(String tmp : matrix_answer[idx]) tmp_answer.add(tmp); 
        }
        
        int answer_size = tmp_answer.size();
        answer = new String[answer_size];
        for(int idx = 0; idx < answer_size; ++idx) answer[idx] = tmp_answer.get(idx);
        Arrays.sort(answer);
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		
		solution(orders, course);
	}

}
