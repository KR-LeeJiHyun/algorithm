import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek선분그룹 {
	
	static class Pair{
		int x;
		int y;
		
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int compare(Pair o) {
			if(this.x == o.x) {
				if(this.y > o.y) return 1;
				else if(this.y < o.y) return -1;
				else return 0;
			}
			else if(this.x < o.x) return -1;
			else return 1;
		} 
	}
	
	static class Line{
		Pair fDot;
		Pair sDot;
		
		Line(int x1, int y1, int x2, int y2) {
			Pair pair1 = new Pair(x1, y1);
			Pair pair2 = new Pair(x2, y2);
			
			if(pair1.compare(pair2) <= 0) {
				this.fDot = pair1;
				this.sDot = pair2;
			}
			else {
				this.fDot = pair2;
				this.sDot = pair1;
			}
		}
		
		public boolean overlap(Line o) {
			 if(this.fDot.compare(o.sDot) <= 0 && o.fDot.compare(this.sDot) <= 0) {
				 return true;
			 }
			 return false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] cnts = new int[N];
		int[] parents = new int[N];
		Line[] lines = new Line[N];
		
		for(int idx = 0; idx < N; ++idx) {
			cnts[idx] = 1;
			parents[idx] = idx;
			StringTokenizer input = new StringTokenizer(br.readLine());
			lines[idx] = new Line(Integer.parseInt(input.nextToken()), Integer.parseInt(input.nextToken()), 
					Integer.parseInt(input.nextToken()), Integer.parseInt(input.nextToken()));
		}
		
		for(int idx = 0; idx < N - 1; ++idx) {
			for(int sIdx = idx + 1; sIdx < N; ++sIdx) {
				int find1 = find(parents, idx);
				int find2 = find(parents, sIdx);
				if(find1 != find2) {
					if(isIntersect(lines[idx], lines[sIdx])) {
						union(find1, find2, cnts, parents);
					}
				}
			}
		}
		
		int max = 0;
		int groupCnt = 0;
		
		for(int idx = 0; idx < N; ++idx) {
			if(cnts[idx] != 0) ++groupCnt;
			max = Math.max(max, cnts[idx]);
		}
		
		StringBuilder answer = new StringBuilder();
		answer.append(groupCnt);
		answer.append('\n');
		answer.append(max);
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}
	
	private static int ccw(Pair fDot, Pair sDot, Pair tDot) {
		int result = (fDot.x * sDot.y + sDot.x * tDot.y + tDot.x * fDot.y) - (sDot.x * fDot.y + tDot.x * sDot.y + fDot.x * tDot.y);
		if(result > 0) return 1;
		else if(result < 0) return -1;
		else return 0;
	}

	private static boolean isIntersect(Line line, Line line2) {
		int first = ccw(line.fDot, line.sDot, line2.fDot) * ccw(line.fDot, line.sDot, line2.sDot);
		int second = ccw(line2.fDot, line2.sDot, line.fDot) * ccw(line2.fDot, line2.sDot, line.sDot);
		
		if(first == 0 && second == 0) {
			return line.overlap(line2);
		}
		
		return first <= 0 && second <= 0;
	}

	private static void union(int find1, int find2, int[] cnts, int[] parents) {
		if(find1 > find2) {
			int tmp = find1;
			find1 = find2;
			find2 = tmp;
		}
		
		cnts[find1] += cnts[find2];
		cnts[find2] = 0;
		parents[find2] = find1;
	}

	private static int find(int[] parents, int idx) {
		if(parents[idx] == idx) return idx;
		return find(parents, parents[idx]);
	}

}
