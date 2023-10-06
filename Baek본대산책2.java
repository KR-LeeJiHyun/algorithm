import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek본대산책2 {
	
	static final long MOD = 1000000007;
	static final int SIZE = 8;
	//정보과학관 0, 전산관 1, 미래관 2, 신양관 3, 한경직기념관 4, 진리관 5, 형남공학관 6, 학생회관 7
	static long[][] oneHop = {
			{0, 1, 1, 0, 0, 0, 0, 0},
			{1, 0, 1, 1, 0, 0, 0, 0},
			{1, 1, 0, 1 ,1, 0, 0, 0},
			{0, 1, 1, 0, 1, 1, 0, 0},
			{0, 0, 1, 1, 0, 1, 1, 0},
			{0, 0, 0, 1, 1, 0, 0, 1},
			{0, 0, 0, 0, 1, 0, 0, 1},
			{0, 0, 0, 0, 0, 1, 1, 0}
	};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int D = Integer.parseInt(br.readLine());
		long[][] map = calc(D); 
		
		bw.write(String.valueOf(map[0][0]));
		br.close();
		bw.close();
	}

	private static long[][] calc(int d) {
		long[][] result = new long[SIZE][SIZE];
		if(d == 1) {
			return oneHop;
		}
		
		long[][] prev = calc(d / 2);
		result = mul(prev, prev);
		if(d % 2 != 0) {
			result = mul(result, oneHop);
		}
		
		return result;
	}
	
	private static long[][] mul(long[][] A, long[][] B) {
		long[][] result = new long[SIZE][SIZE];
		
		for(int mid = 0; mid < SIZE; ++mid) {
			for(int start = 0; start < SIZE; ++start) {
				for(int end = 0; end < SIZE; ++end) {
					result[start][end] += A[start][mid] * B[mid][end];
					result[start][end] %= MOD;
				}
			}
		}
		
		return result;
	}

}
