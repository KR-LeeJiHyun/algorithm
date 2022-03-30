import java.util.LinkedList;
import java.util.Queue;

public class Pro_110Move {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"1100111011101001"};
		solution(s);
	}
	
    public static String[] solution(String[] s) {
        String[] answer = new String[s.length];
        final String target = "110";
        for(int idx = 0; idx < s.length; ++idx) {
        	StringBuilder sb = new StringBuilder(), tmpAnswer = new StringBuilder();
        	String current = s[idx]; 
        	Queue<Character> q = new LinkedList<>();
        	int cnt = 0;
        	for(int sIdx = 0; sIdx < current.length(); ++sIdx) {
        		char c = current.charAt(sIdx);
        		if(c == '0') {
        			if(sb.length() > 1) {
        				if(sb.substring(sb.length() - 2, sb.length()).equals("11")) {
        					sb.delete(sb.length() - 2, sb.length());
        					++cnt;
        					continue;
        				}
        			}
        		}
        		sb.append(c);
        	}
        	for(int sIdx = 0; sIdx < sb.length(); ++sIdx) {
        		char c = sb.charAt(sIdx);
        		if(c == '0') {
        			if(!q.isEmpty()) tmpAnswer.append(q.poll());
        			tmpAnswer.append(c);
        		}
        		else q.add(c);
        	}
        	while(cnt != 0) {
        		tmpAnswer.append(target);
        		--cnt;
        	}
        	while(!q.isEmpty()) tmpAnswer.append(q.poll());
        	answer[idx] = tmpAnswer.toString();
        }
        
        return answer;
    }

}
