import java.util.ArrayList;

public class Pro_LockAndKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}; 
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		
		solution(key, lock);
	}
	
    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
              
        int N = lock.length;
        int M = key.length;
        final int keyCnt = 4;
        
        if(check(lock, N)) return answer;
        
        int [][][] keys = new int [keyCnt][M][M];
        keys[0] = key;
        for(int idx = 1; idx < keyCnt; ++idx) keys[idx] = rotation(keys[idx - 1], M);
        
        for(int[][] tmpKey : keys) {
        	answer = open(N, M, lock, tmpKey);
        	if(answer) return answer;
        }
        
        return answer;
    }
    
    public static int[][] rotation(int[][] key, int M){
    	int [][] result = new int[M][M];
    	for(int row = 0; row < M; ++row) {
    		for(int col = 0; col < M; ++col) {
    			result[col][M - 1 - row] = key[row][col];
    		}
    	}
    	
    	return result;
    }
    
    public static boolean open(int N, int M, int[][] lock, int [][] key) {
    	boolean result = false;
    	
    	for(int startRow = 0; startRow < N + M - 1; ++startRow) {
    		for(int startCol = 0; startCol < N + M - 1; ++startCol) {
    			int[][] tmp = new int[N][N];
    			for(int idx = 0; idx < N; ++idx) tmp[idx] = lock[idx].clone();
    			for(int row = 0; row < N; ++row) {
    	    		for(int col = 0; col < N; ++col) {
    	    			int keyRow = M - 1 - startRow + row, keyCol = M - 1 - startCol + col;
    	    			if(keyRow < 0 || keyRow >= M || keyCol < 0 || keyCol >= M) continue;
    	    			tmp[row][col] += key[keyRow][keyCol];
    	    		}
    	    	}
    			result = check(tmp, N);
    			if(result) return result;
        	}
    	}
    	
    	return result;
    }
    
    public static boolean check(int[][] lock, int N) {
    	for(int row = 0; row < N; ++row) {
    		for(int col = 0; col < N; ++col) {
    			if(lock[row][col] != 1) return false;
    		}
    	}
    	return true;
    }
}
