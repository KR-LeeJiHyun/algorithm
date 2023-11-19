import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek행렬제곱 {
	static final int MOD = 1000;
	static int N;
	static long B;
	static int[][] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		N = Integer.parseInt(input.nextToken());
		B = Long.parseLong(input.nextToken());
		A = new int[N][N];
		
		for(int row = 0; row < N; ++row) {
			input = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; ++col) {
				A[row][col] = Integer.parseInt(input.nextToken()) % MOD;
			}
		}
		
		int[][] answer = matrixSquare(B);
		
		for(int row = 0; row < N; ++row) {
			for(int col = 0; col < N; ++col) {
				bw.write(String.valueOf(answer[row][col]));
				bw.write(' ');
			}
			bw.write('\n');
		}
		
		br.close();
		bw.close();
	}

	private static int[][] matrixSquare(long square) {
		if(square == 1) {
			return A;
		}
		
		int[][] half = matrixSquare(square / 2l);
		if((square & 1) == 0) {
			return matrixMul(half, half);
		}
		else {
			return matrixMul(matrixMul(half, half), A);
		}
	}

	private static int[][] matrixMul(int[][] m1, int[][] m2) {
		int[][] result = new int[N][N];
		
		for(int row = 0; row < N; ++row) {
			for(int col = 0; col < N; ++col) {
				for(int idx = 0; idx < N; ++idx) {
					result[row][col] += m1[row][idx] * m2[idx][col]; 
				}
				result[row][col] %= MOD;
			}
		}
		
		return result;
	}

}
