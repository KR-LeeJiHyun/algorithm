import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek열쇠 {
	
	static class Position {
		int row;
		int col;
		
		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MAX = 27;
		int T = Integer.parseInt(br.readLine());
		while(T > 0) {
			--T;
			StringTokenizer input = new StringTokenizer(br.readLine());
			final int RLEN = Integer.parseInt(input.nextToken());
			final int CLEN = Integer.parseInt(input.nextToken());
			char[][] map = new char[RLEN][CLEN];
			ArrayList<Position> start = new ArrayList<>();
			for(int row = 0; row < RLEN; ++row) {
				map[row] = br.readLine().toCharArray();
				if(row == 0 || row == RLEN - 1) {
					for(int col = 1; col < CLEN - 1; ++col) {
						if(map[row][col] != '*'){
							start.add(new Position(row, col));
						}
					}
				}
				if(map[row][0] != '*'){
					start.add(new Position(row, 0));
				}
				if(map[row][CLEN - 1] != '*'){
					start.add(new Position(row, CLEN - 1));
				}
			}
			
			
			
			boolean[][][] visited = new boolean[MAX][RLEN][CLEN];
			int kLen = 0;
			boolean[] keys = new boolean[MAX];
			String strKey = br.readLine();
			if(strKey.compareTo("0") != 0) {
				for(char c : strKey.toCharArray()) {
					int pos = c - 'a';
					if(!keys[pos]) {
						++kLen;
					}
					keys[pos] = true;
				}
			}
			
			final int[] dRow = {1, -1, 0, 0};
			final int[] dCol = {0, 0, 1, -1};
			int answer = 0;
			Queue<Position> q = new LinkedList<>();
			for(Position s : start) {
				char c = map[s.row][s.col];
				if('A' <= c && c <= 'Z') {
					if(keys[c - 'A']) {
						q.add(s);
						visited[kLen][s.row][s.col] = true;
					}
				}
				else {
					q.add(s);
					visited[kLen][s.row][s.col] = true;
				}
			}
			
			while(!q.isEmpty()) {
				Position current = q.poll();
				char c = map[current.row][current.col];
				if(c == '$') {
					++answer;
				}
				else if('a' <= c && c <= 'z') {
					int pos = c - 'a';
					if(!keys[pos]) {
						keys[pos] = true;
						++kLen;
						for(Position s : start) {
							char sc = map[s.row][s.col];
							if('A' <= sc && sc <= 'Z') {
								if(keys[sc - 'A']) {
									q.add(s);
									visited[kLen][s.row][s.col] = true;
								}
							}
							else {
								q.add(s);
								visited[kLen][s.row][s.col] = true;
							}
						}
					}
				}
				map[current.row][current.col] = '.';
				for(int idx = 0; idx < 4; ++idx) {
					int nRow = current.row + dRow[idx];
					int nCol = current.col + dCol[idx];
					if(nRow < 0 || nRow == RLEN || nCol < 0 || nCol == CLEN || visited[kLen][nRow][nCol] || map[nRow][nCol] == '*') {
						continue;
					}
					if('A' <= map[nRow][nCol] && map[nRow][nCol] <= 'Z') {
						if(keys[map[nRow][nCol] - 'A']) {
							q.add(new Position(nRow, nCol));
							visited[kLen][nRow][nCol] = true;
						}
					}
					else {
						q.add(new Position(nRow, nCol));
						visited[kLen][nRow][nCol] = true;
					}
				}
			}
			
			bw.write(String.valueOf(answer));
			bw.write('\n');
		}
		br.close();
		bw.close();
	}

}
