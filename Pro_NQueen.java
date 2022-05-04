import java.util.Arrays;

public class Pro_NQueen {

	public static void main(String[] args) {
		solution(4);
	}
	
    public static int solution(int n) {
        int answer = 0;
        if(n == 1) return 1;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        answer = search(n, 0, visited);
        return answer;
    }

	private static int search(int n, int cnt, int[] visited) {
		if(cnt == n) {
			return 1;
		}
		int result = 0;
		for(int idx = 0; idx < n; ++idx) {
			if(check(n, cnt, idx, visited)) {
				visited[cnt] = idx;
				result += search(n, cnt + 1, visited);
				visited[cnt] = -1;
			}
		}
		return result;
	}

	private static boolean check(int n, int row, int col, int[] visited) {
		for(int r = 0; r < row; ++r) {
			int diff = row - r;
			if(visited[r] == col) return false;
			if(col - diff > -1 && visited[r] == col - diff) return false;
			if(col + diff < n && visited[r] == col + diff) return false;
		}
		return true;
	}

}
