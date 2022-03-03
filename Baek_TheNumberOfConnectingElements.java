import java.util.Scanner;
import java.util.Stack;

public class Baek_TheNumberOfConnectingElements {
	
	public static int solution(boolean[][] map, boolean[]visited, int N, int M) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		
		for(int idx = 0; idx < N; ++idx) {
			if(!visited[idx]) ++answer;
			stack.push(idx);
			while(!stack.isEmpty()) {
				int start = stack.peek();
				stack.pop();
				
				if(!visited[start]) {
					visited[start] = true;
				
					for(int col = 0; col < N; ++col) {
						if(map[start][col] && !visited[col]) stack.push(col);
					}
				}
			}
		}
		
		return answer;
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] map;
		boolean[] visited;
		int N, M, u, v;
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new boolean[N][N];
		visited = new boolean[N];
		M = sc.nextInt();
		for(int idx = 0; idx < M; ++idx) {
			u = sc.nextInt();
			v = sc.nextInt();
			map[u - 1][v - 1] = true;
			map[v - 1][u - 1] = true;
		}
		
		System.out.print(solution(map, visited, N, M));
	}*/

}
