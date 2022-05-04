
public class Pro_MatrixMul {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[][] solution(int[][] arr1, int[][] arr2) {
    	int rLen = arr1.length, cLen = arr2[0].length, len = arr2.length;
        int[][] answer = new int[rLen][cLen];
        
        for(int row = 0; row < rLen; ++row) {
        	for(int col = 0; col < cLen; ++col) {
        		for(int idx = 0; idx < len; ++idx) {
        			answer[row][col] += arr1[row][idx] * arr2[idx][col];
        		}
        	}
        }
        
        return answer;
    }

}
