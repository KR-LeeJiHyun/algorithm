import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_MakeBridge2 {
	
	public static class Node implements Comparable<Node>{
		int start;
		int dest;
		int weight;
		
		public Node(int start, int dest, int weight) {
			this.start = start;
			this.dest = dest;
			this.weight = weight;
		}
		
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	static int N, M;
	static int[] dRow = {1, 0}, dCol = {0, 1};
	static int[] bDRow = {1, -1, 0, 0}, bDCol = {0, 0, 1, -1};
	static int[] parent;
	static boolean[][] visited;
	static PriorityQueue<Node> edge;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stNM = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stNM.nextToken());
		M = Integer.parseInt(stNM.nextToken());
		int[][] map = new int[N][M];
		
		for(int row = 0; row < N; ++row) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < M; ++col) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		int num = 1;
		visited = new boolean[N][M];
		for(int row = 0; row < N; ++row) {
			for(int col = 0; col < M; ++col) {
				if(map[row][col] == 1 && !visited[row][col]) {
					bfs(num, row, col, map);
					++num;
				}
			}
		}
		
		edge = new PriorityQueue<>();
		for(int row = 0; row < N; ++row) {
			for(int col = 0; col < M; ++col) {
				if(map[row][col] != 0) {
					searchEdge(row, col, map);
				}
			}
		}
		
		int answer = kruskal(num);
		
		for(int idx = 2; idx < num; ++idx) {
			if(find(1) != find(idx)) {
				answer = -1;
				break;
			}
		}
		
		bw.write(answer + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

	private static void searchEdge(int sRow, int sCol, int[][] map) {
		for(int idx = 0; idx < dRow.length; ++idx) {
			Queue<Integer> q = new LinkedList<>();
			q.add(sRow);
			q.add(sCol);
			q.add(0);

			int node = map[sRow][sCol];

			while(!q.isEmpty()) {
				int row = q.poll(), col = q.poll(), cost = q.poll();
				int nRow = row + dRow[idx], nCol = col + dCol[idx];
				if(nRow < 0 || nCol < 0 || nRow == N || nCol == M) continue;
				else if(map[nRow][nCol] == 0) {
					q.add(nRow);
					q.add(nCol);
					q.add(cost + 1);
				}
				else if(map[nRow][nCol] != node && cost > 1) {
					edge.add(new Node(node, map[nRow][nCol], cost));
				}
			}
		}
	}

	private static void bfs(int num, int sRow, int sCol,int[][] map) {
		Queue<Integer> q = new LinkedList<>();
		q.add(sRow);
		q.add(sCol);
		map[sRow][sCol] = num;
		visited[sRow][sCol] = true;
		
		while(!q.isEmpty()) {
			int row = q.poll(), col = q.poll();
			
			for(int idx = 0; idx < bDRow.length; ++idx) {
				int nRow = row + bDRow[idx], nCol = col + bDCol[idx];
				if(nRow < 0 || nCol < 0 || nRow == N || nCol == M) continue;
				else if(map[nRow][nCol] == 1 && !visited[nRow][nCol]) {
					q.add(nRow);
					q.add(nCol);
					map[nRow][nCol] = num;
					visited[nRow][nCol] = true;
				}
			}
		}
	}
	
	private static int kruskal(int N) {
		int result = 0;
		parent = new int[N];
		
		for(int idx = 0; idx < N; ++idx) parent[idx] = idx;
		
		while(!edge.isEmpty()) {
			Node node = edge.poll();
			int start = node.start, dest = node.dest, weight = node.weight;
			if (find(start) != find(dest)) {
				union(start, dest);
				result += weight;
			}
		}
		
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
