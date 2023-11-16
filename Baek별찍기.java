import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek별찍기 {

	static char[][] answer = new char[3072][6144]; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		makeTri(N, 0, 0);
		
		for(int row = 0; row < N; ++row) {
			for(int col = 0; col < N*2; ++col) {
				bw.write((answer[row][col] == '*') ? '*' : ' ' );
			}
			bw.write('\n');
		}
		
		br.close();
		bw.close();
	}

	private static void makeTri(int n, int x, int y) {
		if(n == 3) {
			printStar(x, y);
			return;
		}
		
		makeTri(n / 2, x, y + n / 2);
		makeTri(n / 2, x + n / 2, y);
		makeTri(n / 2, x + n / 2, y + n);
	}

	private static void printStar(int x, int y) {
	    answer[x+0][y+2] = '*';
	    answer[x+1][y+1] = '*';
	    answer[x+1][y+3] = '*';
	    answer[x+2][y+0] = '*';
	    answer[x+2][y+1] = '*';
	    answer[x+2][y+2] = '*';
	    answer[x+2][y+3] = '*';
	    answer[x+2][y+4] = '*';
	}

}
