import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek행성탐사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stMN = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(stMN.nextToken()) + 1;
		int N = Integer.parseInt(stMN.nextToken()) + 1;
		int K = Integer.parseInt(br.readLine());
		int[][] jungle = new int[M][N];
		int[][] ocean = new int[M][N];
		int[][] ice = new int[M][N];
		
		for(int row = 1; row < M; ++row) {
			String input = br.readLine();
			for(int col = 1; col < N; ++col) {
				char c = input.charAt(col - 1);
				if(c == 'J') {
					jungle[row][col] = 1;
				}
				else if(c == 'O') {
					ocean[row][col] = 1;
				}
				else {
					ice[row][col] = 1;
				}
				
				jungle[row][col] += jungle[row - 1][col] + jungle[row][col - 1] - jungle[row - 1][col - 1];
				ocean[row][col] += ocean[row - 1][col] + ocean[row][col - 1] - ocean[row - 1][col - 1];
				ice[row][col] += ice[row - 1][col] + ice[row][col - 1] - ice[row - 1][col - 1];
			}
		}
		
		StringBuilder answer = new StringBuilder();
		for(int idx = 0; idx < K; ++idx) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken()) - 1;
			int sc = Integer.parseInt(st.nextToken()) - 1;
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			answer.append(jungle[er][ec] - jungle[sr][ec] - jungle[er][sc] + jungle[sr][sc]);
			answer.append(' ');
			answer.append(ocean[er][ec] - ocean[sr][ec] - ocean[er][sc] + ocean[sr][sc]);
			answer.append(' ');
			answer.append(ice[er][ec] - ice[sr][ec] - ice[er][sc] + ice[sr][sc]);
			answer.append('\n');
		}
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}

}
