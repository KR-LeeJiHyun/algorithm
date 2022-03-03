public class Pro_MaxExpression {
	
	static boolean[] visited = {false, false, false};
	static final char[] op = {'+', '-', '*'};
	static final int plus = 0, minus = 1, mul = 2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "100-200*300-500+20";
		solution(expression);
	}

	
    public static long solution(String expression) {
        long answer = 0;
        
        if(visited[0] && visited[1] && visited[2]) {
        	expression = expression.replace('!', '-');
        	return Math.abs(Long.parseLong(expression));
        }
        
        for(int idx = 0; idx < visited.length; ++idx) {
        	if(!visited[idx]) {
        		visited[idx] = true;
        		String tmp = cal(expression, op[idx]);
        		answer = Math.max(answer, solution(tmp));
        		visited[idx] = false;
        	}
        }
        
        return answer;
    }
    
    public static String cal(String expression, char operator) {
    	int opIdx = expression.indexOf(operator);
    	while(opIdx != -1) {
    		String firstOperand = "", secondOperand = "";
    		int firstIdx = opIdx - 1;
    		while(firstIdx > -1) {
    			char tmp = expression.charAt(firstIdx);
    			if(tmp == op[plus] || tmp == op[minus] || tmp == op[mul]) break;
    			firstOperand += tmp;
    			--firstIdx;
    		}
    		
    		int secondIdx = opIdx + 1;
    		while(secondIdx < expression.length()) {
    			char tmp = expression.charAt(secondIdx);
    			if(tmp == op[plus] || tmp == op[minus] || tmp == op[mul]) break;
    			secondOperand += tmp;
    			++secondIdx;
    		}
    		
    		StringBuffer sb = new StringBuffer(firstOperand);
    		firstOperand = sb.reverse().toString();
    		
        	long result = 0;
        	String tmpFirstOperand = firstOperand.replace('!', '-');
        	String tmpSecondOperand = secondOperand.replace('!', '-');
        	if(operator == op[plus]) result = Long.parseLong(tmpFirstOperand) + Long.parseLong(tmpSecondOperand);
        	else if(operator == op[minus]) result = Long.parseLong(tmpFirstOperand) - Long.parseLong(tmpSecondOperand);
        	else result = Long.parseLong(tmpFirstOperand) * Long.parseLong(tmpSecondOperand);
        	
        	if(result < 0) {
        		result = result * -1;
        		expression = expression.replace(firstOperand + operator + secondOperand, "!" + Long.toString(result));
        	}
        	else expression = expression.replace(firstOperand + operator + secondOperand, Long.toString(result));
        	opIdx = expression.indexOf(operator);
    	}

    	return expression;
    }
 
}
