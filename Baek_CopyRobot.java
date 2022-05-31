import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Baek_CopyRobot {
	
	static int[] parent;
	static ArrayList<Node> keys;
	static PriorityQueue<MST_Node> edge;
	static char[][] map;
	
	static class Node {
		int row;
		int col;
		int cost;
		
		public Node(int row, int col, int cost) {
			this.row = row;
			this.col = col;
			this.cost = cost;
		}		
	}

	static class MST_Node implements Comparable<MST_Node>{
		int start;
		int dest;
		int cost;

		public MST_Node(int start, int dest, int cost) {
			this.start = start;
			this.dest = dest;
			this.cost = cost;
		}

		public int compareTo(MST_Node n) {
			return this.cost - n.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stNM.nextToken()), M = Integer.parseInt(stNM.nextToken());
		map = new char[N][N];
		keys = new ArrayList<>();
		edge = new PriorityQueue();
		
		for(int row = 0; row < N; ++row) {
			String tmp = br.readLine();
			for(int col = 0; col < N; ++col) {
				char c = tmp.charAt(col);
				map[row][col] = c;
				if(c == 'K' || c == 'S') keys.add(new Node(row, col, 0));
			}
		}
		
		for(int  idx = 0; idx <= M; ++idx) bfs(idx, N, M);
			
		bw.write(kruskal(M) + "\n");
		br.close();
		bw.flush();
		bw.close();	
	}
	
	public static void bfs(int num, int N, int M) {
		if(num == 1) {
			int a = 0;
		}
		int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
		boolean[][] visited = new boolean[N][N];
		Queue<Node> q = new LinkedList();
		q.add(new Node(keys.get(num).row, keys.get(num).col, 0));
		visited[keys.get(num).row][keys.get(num).col] = true;
		
		while(!q.isEmpty()) {
			Node current = q.poll();
			
			for(int idx = 0; idx < dRow.length; ++idx) {
				int nRow = current.row + dRow[idx], nCol = current.col + dCol[idx], nCost = current.cost + 1;
				if(nRow < 0 || nCol < 0 || nRow == N || nCol == N || visited[nRow][nCol] || map[nRow][nCol] == '1') continue;
				visited[nRow][nCol] = true;
				q.add(new Node(nRow, nCol, nCost));
				if(map[nRow][nCol] == 'S' || map[nRow][nCol] == 'K') {
					for(int sIdx = 0; sIdx <= M; ++sIdx) {
						Node key = keys.get(sIdx);
						if(key.row == nRow && key.col == nCol) edge.add(new MST_Node(num, sIdx, nCost));
					}
				}
			}
		}
	}
	
	private static int kruskal(int M) {
		int result = 0;
		parent = new int[M + 1];
		
		for(int idx = 0; idx <= M; ++idx) parent[idx] = idx;
		
		int cnt = 0;
		while(!edge.isEmpty()) {
			MST_Node node = edge.poll();
			int start = node.start, dest = node.dest, cost = node.cost;
			if (find(start) != find(dest)) {
				union(start, dest);
				result += cost;
				++cnt;
			}
		}
		
		if(cnt != M) return -1;
		return result;
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	private static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return find(parent[x]);
	}

}
