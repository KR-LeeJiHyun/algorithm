public class Pro_BinaryTransRepeat {

	public static void main(String[] args) {
		String s = "110010101001";
		solution(s);
	}
	
    public static int[] solution(String s) {
        int[] answer = new int[2];
        
        while(s.compareTo("1") != 0) {
        	++answer[0];
        	int len = s.length();
        	int x = s.replace("0", "").length();
        	answer[1] += len - x;
        	s = Integer.toBinaryString(x);
        }

        return answer;
    }

}
