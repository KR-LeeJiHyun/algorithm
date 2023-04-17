import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek직사각형탈출 {
	static int N;
	static int M;
	static int[][] board;
	static int aLen = 4;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static int rLen;
	static int cLen;
	static int sr;
	static int sc;
	static int fr;
	static int fc;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNM.nextToken());
		M = Integer.parseInt(stNM.nextToken());
		board = new int[N + 1][M + 1];
		
		for(int row = 1; row <= N; ++row) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			for(int col = 1; col <= M; ++col) {
				board[row][col] = Integer.parseInt(input.nextToken())+ board[row - 1][col] + board[row][col - 1] - board[row - 1][col - 1];
			}
		}
		
		StringTokenizer info = new StringTokenizer(br.readLine());
		rLen = Integer.parseInt(info.nextToken());
		cLen = Integer.parseInt(info.nextToken());
		sr = Integer.parseInt(info.nextToken());
		sc = Integer.parseInt(info.nextToken());
		fr = Integer.parseInt(info.nextToken());
		fc = Integer.parseInt(info.nextToken());
		visited = new boolean[N + 1][M + 1];
		
		int answer = bfs(sr, sc);

		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

	private static int bfs(int row, int col) {
		int result = -1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {row, col, 0});
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int cr = current[0];
			int cc = current[1];
			int cd = current[2];
			if(cr == fr && cc == fc) {
				result = cd;
				break;
			}
			
			for(int idx = 0; idx < aLen; ++idx) {
				int nr = cr + dRow[idx];
				int nc = cc + dCol[idx];
				int nfr = nr + rLen - 1;
				int nfc = nc + cLen - 1;
				if(nr < 1 || nc < 1 || nfr > N  || nfc > M || visited[nr][nc] || !isPossible(nr, nc, nfr, nfc)) {
					continue;
				}
				
				q.add(new int[] {nr, nc, cd + 1});
				visited[nr][nc] = true;
			}
		}
		
		return result;
	}

	private static boolean isPossible(int nr, int nc, int nfr, int nfc) {
		int result = board[nfr][nfc] - board[nr - 1][nfc] - board[nfr][nc - 1] + board[nr - 1][nc - 1];
		return result == 0 ? true : false;
	}

}
