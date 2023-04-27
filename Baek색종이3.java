import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek색종이3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int RLEN = 101;
		final int CLEN = 101;
		final int LINE = 10;
		int N = Integer.parseInt(br.readLine());
		int[][] confettis = new int[RLEN][CLEN];
		
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken()) + 1;
			int sc = Integer.parseInt(st.nextToken()) + 1;
			int er = sr + LINE;
			int ec = sc + LINE;
			for(int row = sr; row < er; ++row) {
				for(int col = sc; col < ec; ++col) {
					confettis[row][col] = 1;
				}
			}
		}
		
		for(int row = 1; row < RLEN; ++row) {
			for(int col = 1; col < CLEN; ++col) {
				confettis[row][col] += confettis[row - 1][col] + confettis[row][col - 1] - confettis[row - 1][col - 1];
			}
		}
		
		int answer = 0;
		for(int sr = 1; sr < RLEN; ++sr) {
			for(int sc = 1; sc < CLEN; ++sc) {
				for(int er = sr; er < RLEN; ++er) {
					for(int ec = sc; ec < CLEN; ++ec) {
						int area = confettis[er][ec] - confettis[sr][ec] - confettis[er][sc] + confettis[sr ][sc];
						int real = (er - sr) * (ec - sc);
						if(answer < real && area == real) {
							answer = Math.max(answer, area);
						}
					}
				}
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

}
