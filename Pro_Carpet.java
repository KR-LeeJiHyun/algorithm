
public class Pro_Carpet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(10, 2);
	}
	
    public static int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        final int MAX = 5000;
        for(int row = 3; row <= MAX; ++row){
            for(int col = 3; col <= MAX; ++col){
                int totalB = col * 2 + (row - 2) * 2, total = row * col;
                if(totalB == brown && total == brown + yellow) {
                    answer[0] = col;
                    answer[1] = row;
                    break;
                }
            }
            if(answer[0] != 0) break;
        }
        
        return answer;
    }

}
