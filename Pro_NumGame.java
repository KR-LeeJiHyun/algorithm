import java.util.Arrays;

public class Pro_NumGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIdx = 0, bIdx = 0, aLen = A.length, bLen = B.length;
        
        while(aIdx < aLen && bIdx < bLen) {
        	if(A[aIdx] < B[bIdx]) {
        		++answer;
        		++aIdx;
        	}
        	++bIdx;
        }
        
        return answer;
    }

}
