public class Pro_NumberString {
	public int solution(String s) {
        int answer = 0;
        
        s = s.replace("zero", "0");
        s.replace("one", "1");
        s.replace("two", "2");
        s.replace("three", "3");
        s.replace("four", "4");
        s.replace("five", "5");
        s.replace("six", "6");
        s.replace("seven", "7");
        s.replace("eight", "8");
        s.replace("nine", "9");
        
        answer = Integer.parseInt(s);
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
