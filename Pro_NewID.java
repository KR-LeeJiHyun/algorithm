
public class Pro_NewID {
	
	public static String solution(String new_id) {
        String answer = "", tmp_id = new_id;
        
        //1단계
        tmp_id = tmp_id.toLowerCase();

        //2단계
        String match = "[~!@#$%^&*()=+\\[{\\]}:?,<>/]";
        tmp_id = tmp_id.replaceAll(match, "");
        
        //3단계
        while(tmp_id.contains("..")) tmp_id = tmp_id.replace("..", ".");
        
        //4단계
        while(!tmp_id.isEmpty() && tmp_id.charAt(0) == '.') tmp_id = tmp_id.replaceFirst(".", "");
        while(!tmp_id.isEmpty() && tmp_id.charAt(tmp_id.length() - 1) == '.') tmp_id = tmp_id.substring(0,tmp_id.length() - 1);
        
        //5단계
        if(tmp_id.isEmpty()) tmp_id = "a";
        
        //6단계
        if(tmp_id.length() > 15) {
        	tmp_id = tmp_id.substring(0, 15);
        	while(tmp_id.charAt(tmp_id.length() - 1) == '.') tmp_id = tmp_id.substring(0,tmp_id.length() - 1);
        }
        
        //7단계
        int len = tmp_id.length();
        if(len < 3) {
        	for(int idx = 0; idx < 3-len; ++idx) {
        		tmp_id += tmp_id.charAt(len - 1);
        	}
        }
        
        answer = tmp_id;
        
        return answer;
    }
	
	/*public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm~!@#$%^&*()=+[{]}:?,<>/~!@#$%^&*()=+[{]}:?,<>//";
		solution(new_id);
	}*/
}
