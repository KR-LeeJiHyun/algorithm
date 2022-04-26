import java.util.StringTokenizer;

public class Pro_MinAndMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String solution(String s) {
        String answer = "";
        
        StringTokenizer st = new StringTokenizer(s);
        
        int min, max;
        
        min = Integer.parseInt(st.nextToken());
        max = min;
        
        while(st.hasMoreElements()) {
        	int num = Integer.parseInt(st.nextToken());
        	min = Math.min(min, num);
        	max = Math.max(max, num);
        }
        
        answer = min + " " + max;
        return answer;
    }

}
