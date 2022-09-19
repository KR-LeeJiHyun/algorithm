import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_Matrix {
	static int N;
	static int M; 
	static int[][] matrix1;
	static int[][] matrix2;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix1 = new int[N][M];
		matrix2 = new int[N][M];
		
		for(int row = 0; row < N; ++row) {
			String strRow = br.readLine();
			for(int col = 0; col < M; ++col) matrix1[row][col] = Character.getNumericValue(strRow.charAt(col));
		}
		
		for(int row = 0; row < N; ++row) {
			String strRow = br.readLine();
			for(int col = 0; col < M; ++col) matrix2[row][col] = Character.getNumericValue(strRow.charAt(col));
		}
		
		int answer = 0;
		
		for(int row = 0; row <= N - 3; ++row) {
			for(int col = 0; col <= M - 3; ++col) {
				if(matrix1[row][col] != matrix2[row][col]) {
					++answer;
					trans(row, col);
				}
			}
		}
		
		if(coincide()) bw.write(Integer.toString(answer));
		else bw.write("-1");
		br.close();
		bw.flush();
		bw.close();

	}

	private static boolean coincide() {
		for(int row = 0; row < N; ++row) {
			for(int col = 0; col < M; ++col) {
				if(matrix1[row][col] != matrix2[row][col]) return false;
			}
		}
		return true;
	}

	private static void trans(int startRow, int startCol) {
		int endRow = startRow + 3;
		int endCol = startCol + 3;
		for(int row = startRow; row < endRow; ++row) {
			for(int col = startCol; col < endCol; ++col) {
				matrix1[row][col] = (matrix1[row][col] + 1) % 2;
			}
		}
	}

}
