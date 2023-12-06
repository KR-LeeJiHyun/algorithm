import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek치킨배달 {

	static class Node {
		int row;
		int col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static int answer = Integer.MAX_VALUE;
	static int N;
	static int M;
	static boolean[] visited;
	static ArrayList<Node> chickens = new ArrayList();
	static ArrayList<Node> houses = new ArrayList();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer input = new StringTokenizer(br.readLine());
		N = Integer.parseInt(input.nextToken());
		M = Integer.parseInt(input.nextToken());

		for(int row = 0; row < N; ++row) {
			input = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; ++col) {
				int type = Integer.parseInt(input.nextToken());
				if(type == 1) {
					houses.add(new Node(row, col));
				}
				else if(type == 2) {
					chickens.add(new Node(row, col));
				}
			}
		}
		
		visited = new boolean[chickens.size()];

		dfs(0, chickens.size());
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}

	private static void dfs(int start, int size) {
		if(size == M) {
			PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
			
			for(int hIdx = 0; hIdx < houses.size(); ++hIdx) {
				Node house = houses.get(hIdx);
				int min = Integer.MAX_VALUE;
				for(int cIdx = 0; cIdx < chickens.size(); ++cIdx) {
					Node chicken = chickens.get(cIdx);
					if(visited[cIdx]) continue;
					int dis = Math.abs(house.row - chicken.row) + Math.abs(house.col - chicken.col);
					if(dis < min) {
						min = dis;
					}
				}
				pq.add(min);
			}
			int result = 0;
			while(!pq.isEmpty()) {
				result += pq.poll();
			}
			answer = Math.min(answer, result);
		}
		else {
			for(int idx = start; idx < chickens.size(); ++idx) {
				visited[idx] = true;
				dfs(idx + 1, size - 1);
				visited[idx] = false;
			}
		}
	}

}
