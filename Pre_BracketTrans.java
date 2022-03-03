import java.util.Stack;

public class Pre_BracketTrans {
	
    public static String solution(String p) {
        String answer = "";
        String u = "", v = "";
        //빈문자열 리턴
        if(p.isEmpty()) return p;
        Stack<Character> stack = new Stack();
        char[] trans = {'(', ')'}; // u에서 변형하기 위한 문자열
        boolean u_plus = true;
        int count_0 = 0, count_1 = 0;
        
        //문자열 u,v 분리 및 p가 올바른지 판단
        for(char tmp : p.toCharArray()) {
        	if(u_plus) {
        		u += tmp;
        		if(tmp == '(') ++count_0;
        		else ++count_1;
        		
        		if(count_0 == count_1) u_plus = false;
        	}
        	else v += tmp;
        	if(stack.isEmpty()) stack.add(tmp);
        	else {
        		if(stack.peek() == '(' && stack.peek() != tmp) stack.pop();
        		else stack.add(tmp);
        	}
        }
        
        //stack이 비었다면 p는 올바른 문자열이므로 p를 그대로 반환
        if(stack.isEmpty()) return p;
        
        stack.clear();
        
        //부분문자열 u가 올바른 문자열인지 판단
        for(char tmp : u.toCharArray()) {
        	if(stack.isEmpty()) stack.add(tmp);
        	else {
        		if(stack.peek() == '(' && stack.peek() != tmp) stack.pop();
        		else stack.add(tmp);
        	}
        }
        
        //u가 올바른 문자열일 경우
        if(stack.isEmpty()) answer = u + solution(v);
        
        //u가 올바른 문자열이 아닐 경우
        else {
        	answer = "(";
        	answer += solution(v);
        	answer += ")";
        	
        	u = u.substring(1, u.length() - 1);
        	for(char tmp : u.toCharArray()) answer += trans[')' - tmp];
        }
              
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p = "(()())()";
		System.out.print(solution(p));
	}

}
