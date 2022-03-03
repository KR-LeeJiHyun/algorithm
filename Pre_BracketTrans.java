import java.util.Stack;

public class Pre_BracketTrans {
	
    public static String solution(String p) {
        String answer = "";
        String u = "", v = "";
        //���ڿ� ����
        if(p.isEmpty()) return p;
        Stack<Character> stack = new Stack();
        char[] trans = {'(', ')'}; // u���� �����ϱ� ���� ���ڿ�
        boolean u_plus = true;
        int count_0 = 0, count_1 = 0;
        
        //���ڿ� u,v �и� �� p�� �ùٸ��� �Ǵ�
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
        
        //stack�� ����ٸ� p�� �ùٸ� ���ڿ��̹Ƿ� p�� �״�� ��ȯ
        if(stack.isEmpty()) return p;
        
        stack.clear();
        
        //�κй��ڿ� u�� �ùٸ� ���ڿ����� �Ǵ�
        for(char tmp : u.toCharArray()) {
        	if(stack.isEmpty()) stack.add(tmp);
        	else {
        		if(stack.peek() == '(' && stack.peek() != tmp) stack.pop();
        		else stack.add(tmp);
        	}
        }
        
        //u�� �ùٸ� ���ڿ��� ���
        if(stack.isEmpty()) answer = u + solution(v);
        
        //u�� �ùٸ� ���ڿ��� �ƴ� ���
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
