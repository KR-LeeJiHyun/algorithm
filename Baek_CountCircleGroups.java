import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_CountCircleGroups {
	
	static class Coordinate {
		
		int x;
		int y;
		int r;
		
		public Coordinate(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			Coordinate[] pos = new Coordinate[N + 1];
			int[] group = new int[N + 1];
			
			for(int idx = 1; idx <= N; ++idx) {
				group[idx] = idx;
				StringTokenizer st = new StringTokenizer(br.readLine());
				pos[idx] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			for(int idx = 1; idx <= N; ++idx) {
				for(int sIdx = idx + 1; sIdx <= N; ++sIdx) {
					if(getRange(pos[idx], pos[sIdx])) union(group, idx, sIdx);
				}
			}
			
			int cnt = 0;
			for(int idx = 1; idx <= N; ++idx) {
				if(group[idx] == idx) ++cnt;
			}
			
			answer.append(cnt);
			answer.append('\n');
		}
		
		bw.write(answer.toString());
		br.close();
		bw.close();

	}

	private static void union(int[] group, int idx, int sIdx) {
		
		int num1 = find(group, idx);
		int num2 = find(group, sIdx);
		
		if(num1 < num2) group[num2] = num1;
		else group[num1] = num2;
		
	}

	private static int find(int[] group, int idx) {
		if(group[idx] == idx) return idx;
		return find(group, group[idx]);
	}

	private static boolean getRange(Coordinate c1, Coordinate c2) {
		int r = c1.r + c2.r;
		int dis = (c1.x - c2.x) * (c1.x - c2.x) + (c1.y - c2.y) * (c1.y - c2.y);
		if(dis <= r*r) return true;
		return false;
	}

}
