import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek암벽등반 {
	
	static class Hole {
		int x;
		int y;
		int cnt;
		
		public Hole(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MAX = 100000;
		StringTokenizer input = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(input.nextToken());
		int T = Integer.parseInt(input.nextToken());
		boolean[][] map = new boolean[MAX + 1][T + 1];
		
		for(int idx = 0; idx < n; ++idx) {
			input = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(input.nextToken());
			int y = Integer.parseInt(input.nextToken());
			map[x][y] = true;
		}
		
		Queue<Hole> q = new LinkedList<>();
		int answer = -1;
		q.add(new Hole(0, 0, 0));
		map[0][0] = false;
		
		while(!q.isEmpty()) {
			Hole c = q.poll();
			if(c.y == T) {
				answer = c.cnt;
				break;
			}
			
			int xStart = Math.max(0, c.x - 2);
			int xEnd = Math.min(MAX, c.x + 2);
			int yStart = Math.max(0, c.y - 2);
			int yEnd = Math.min(T, c.y + 2);
			
			for(int x = xStart; x <= xEnd; ++x) {
				for(int y = yStart; y <= yEnd; ++y) {
					if(map[x][y]) {
						map[x][y] = false;
						q.add(new Hole(x, y, c.cnt + 1));
					}
				}
			}
		}
		
		/*
		ArrayList<Integer>[] xHoles = new ArrayList[T + 1];
		
		for(int idx = 0; idx <= T; ++idx) {
			xHoles[idx] = new ArrayList();
		}
		
		for(int idx = 0; idx < n; ++idx) {
			input = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(input.nextToken());
			int y = Integer.parseInt(input.nextToken());
			xHoles[y].add(x);
		}
		
		for(int idx = 0; idx <= T; ++idx) {
			Collections.sort(xHoles[idx]);
		}
		
		Queue<Hole> q = new LinkedList<>();
		boolean[][] visited = new boolean[100000][T + 1];
		int answer = -1;
		q.add(new Hole(0, 0, 0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Hole c = q.poll();
			if(c.y == T) {
				answer = c.cnt;
				break;
			}
			
			int start = Math.max(0, c.y - 2);
			int end = Math.min(T, c.y + 2);
			for(int y = start; y <= end; ++y) {
				int fs = Collections.binarySearch(xHoles[y], Math.max(0, c.x - 2));
				int fe = Collections.binarySearch(xHoles[y], c.x + 2);
				
				if(fs < 0) {
					fs = -fs -1;
				}
				if(fe < 0) {
					fe = -fe -1;
				}
				else {
					++fe;
				}
				for(int idx = fs; idx < fe; ++idx) {
					int x = xHoles[y].get(idx);
					if(!visited[x][y]) {
						visited[x][y] = true;
						q.add(new Hole(x, y, c.cnt + 1));
					}
				}
			}
		}
		*/
		
		bw.write(String.valueOf(answer));
		bw.close();
		br.close();
	}

}
