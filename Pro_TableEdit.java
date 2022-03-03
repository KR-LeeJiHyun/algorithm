import java.util.Stack;

public class Pro_TableEdit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8, k = 2;
		String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
		System.out.print(solution(n, k, cmd));
	}
	
    public static String solution(int n, int k, String[] cmd) {
        String answer = "";  
        
        int curIdx = k;
        int len = n;
        Stack<Integer> delIdx = new Stack();
        
        for(String tmp : cmd) {
        	if(tmp.charAt(0) == 'U') {
        		int x = Integer.parseInt(tmp.substring(2));
        		curIdx -= x;
        	}
        	else if(tmp.charAt(0) == 'D') {
        		int x = Integer.parseInt(tmp.substring(2));
        		curIdx += x;
        	}
        	else if(tmp.charAt(0) == 'C') {
        		delIdx.add(curIdx);
        		--len;
        		if(curIdx >= len) --curIdx;
        	}
        	else {
        		int idx = delIdx.pop();
        		++len;
        		if(idx <= curIdx) ++curIdx;
        	}
        }
        
        StringBuilder tmpAnswer = new StringBuilder("O".repeat(len));
        
        while(!delIdx.isEmpty()) {
        	int idx = delIdx.pop();
        	tmpAnswer.insert(idx, 'X');
        }
        
        answer = tmpAnswer.toString();
        return answer;
    }

}
