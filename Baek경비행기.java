import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek경비행기 {
	
	static int N;
	static int K;
	static final int DX = 10000;
	static final int DY = 10000;
	static Coor[] map;
	
	static class Coor {
		int x;
		int y;
		int cnt;
		
		public Coor(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		public void setCnt(int cnt) {
			this.cnt = cnt;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stNK = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stNK.nextToken());
		K = Integer.parseInt(stNK.nextToken());
		map = new Coor[N];
		
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			map[idx] = new Coor(Integer.parseInt(input.nextToken()), Integer.parseInt(input.nextToken()), 0);
		}
		
		int left = 1;
		int right = calcFuel(0, 0, DX, DY);
		int answer = right;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(isPossible(mid)) {
				answer = Math.min(answer, mid);
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

	private static boolean isPossible(int fuel) {
		boolean[] visited = new boolean[N];
		Queue<Coor> q = new LinkedList<>();
		q.add(new Coor(0, 0, 0));
		
		while(!q.isEmpty()){
			Coor c = q.poll();
			if(calcFuel(c.x, c.y, DX, DY) <= fuel) {
				return true;
			}
			if(c.cnt == K) {
				continue;
			}
			for(int idx = 0; idx < N; ++idx) {
				if(visited[idx] || calcFuel(c.x, c.y, map[idx].x, map[idx].y) > fuel) {
					continue;
				}
				visited[idx] = true;
				map[idx].setCnt(c.cnt + 1);
				q.add(map[idx]);
			}
		}
		
		return false;
	}

	private static int calcFuel(int sX, int sY, int dX, int dY) {
		double result = Math.sqrt(Math.pow(sX - dX, 2) + Math.pow(sY - dY, 2));
		if(result % 10 != 0) {
			return (int)result / 10 + 1;
		}
		else {
			return (int)result / 10;
		}
	}

}
