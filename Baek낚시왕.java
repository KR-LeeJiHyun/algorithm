import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek낚시왕 {

	public static void main(String[] args) throws IOException {
		int[] dRow = {0, -1, 1, 0, 0};
		int[] dCol = {0, 0, 0, 1, -1};
		int[] trans = {0, 2, 1, 4, 3};
		int S = 0;
		int D = 1;
		int Z = 2;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer input = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(input.nextToken());
		int C = Integer.parseInt(input.nextToken());
		int M = Integer.parseInt(input.nextToken());
		int[][][][] map = new int[C + 1][R + 1][C + 1][3];
		for(int idx = 0; idx < M; ++idx) {
			input = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(input.nextToken());
			int col = Integer.parseInt(input.nextToken());
			int s = Integer.parseInt(input.nextToken());
			int d = Integer.parseInt(input.nextToken());
			int z = Integer.parseInt(input.nextToken());

			map[1][row][col][S] = s;
			map[1][row][col][D] = d;
			map[1][row][col][Z] = z;
		}

		int answer = 0;
		for(int king = 1; king <= C; ++king) {
			for(int row = 1; row <= R; ++row) {
				if(map[king][row][king][Z] != 0) {
					answer += map[king][row][king][Z];
					map[king][row][king][Z] = 0;
					break;
				}
			}
			
			if(king == C) break;
			
			for(int row = 1; row <= R; ++row) {
				for(int col = 1; col <= C; ++col) {
					if(map[king][row][col][Z] != 0) {
						int d = map[king][row][col][D];
						int s = map[king][row][col][S];
						int nr = row + dRow[d] * s;
						int nc = col + dCol[d] * s;

						while(nr < 1 || nr > R) {
							d = trans[d];
							if(nr < 1) {
								nr = 2 - nr; 
							}
							else {
								nr = R * 2 - nr;
							}
						}
						
						while(nc < 1 || nc > C) {
							d = trans[d];
							if(nc < 1) {
								nc = 2 - nc; 
							}
							else {
								nc = C * 2 - nc;
							}
						}
						int a = 0;
						if(map[king + 1][nr][nc][Z] < map[king][row][col][Z]) {
							map[king + 1][nr][nc] = map[king][row][col];
							map[king + 1][nr][nc][D] = d; 
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
