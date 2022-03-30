
public class Pro_Quad {

	public static void main(String[] args) {

	}
	
	int[] answer = {0, 0};
	
    public int[] solution(int[][] arr) {
    	div(arr, arr.length);
    	
        return answer;
    }

	private void div(int[][] arr, int length) {
		if(allEqaul(arr)) {
			++answer[arr[0][0]];
			return;
		}
		int dLen = length / 2;
		int[][][] dArr = new int[4][dLen][dLen];
		
		for(int row = 0; row < dLen; ++row) {
			for(int col = 0; col < dLen; ++col) {
				dArr[0][row][col] = arr[row][col];
			}
		}
		
		for(int row = dLen; row < length; ++row) {
			for(int col = 0; col < dLen; ++col) {
				dArr[1][row - dLen][col] = arr[row][col];
			}
		}
		
		for(int row = 0; row < dLen; ++row) {
			for(int col = dLen; col < length; ++col) {
				dArr[2][row][col - dLen] = arr[row][col];
			}
		}
		
		for(int row = dLen; row < length; ++row) {
			for(int col = dLen; col < length; ++col) {
				dArr[3][row - dLen][col - dLen] = arr[row][col];
			}
		}
		
		for(int idx = 0; idx < 4; ++idx) div(dArr[idx], dLen);
	}

	private boolean allEqaul(int[][] arr) {
		int num = arr[0][0];
		for(int row = 0; row < arr.length; ++row) {
			for(int col = 0; col < arr.length; ++col) {
				if(arr[row][col] != num) return false;
			}
		}
		return true;
	}

}
