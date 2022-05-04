public class Pro_JadenCaseStr {

	public static void main(String[] args) {
		String s = " 3people  unFollowed                               m";
		solution(s);
	}
	
    public static String solution(String s) {
        StringBuilder sb = new StringBuilder("");
        s = s.toLowerCase();
        boolean head = true;
        for(int idx = 0; idx < s.length(); ++idx) {
        	char c = s.charAt(idx);
        	if(head && c != ' ') {
        		sb.append(Character.toUpperCase(c));
        		head = false;
        	}
        	else {
        		if(c == ' ') head = true;
        		sb.append(c);
        	}
        }
        
        return sb.toString();
    }

}
