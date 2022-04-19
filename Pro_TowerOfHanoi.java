import java.util.ArrayList;

public class Pro_TowerOfHanoi {

	public static void main(String[] args) {
		int n = 4;
		solution(n);
	}
	
	static ArrayList<Integer> tmp;
    public static int[][] solution(int n) {
        int[][] answer = {};
        tmp = new ArrayList<>();
        hanoi(n, 1, 2, 3);
        
        answer = new int[tmp.size() / 2][2];
        for(int idx = 0; idx < tmp.size(); idx += 2) {
        	answer[idx / 2][0] = tmp.get(idx);
        	answer[idx / 2][1] = tmp.get(idx + 1);
        }
        
        return answer;
    }

	private static void hanoi(int n, int from, int by, int to) {
		if(n == 0) return;
	    hanoi(n - 1, from, to, by);
	    move(from, to);
	    hanoi(n - 1, by, from, to);
	}

	private static void move(int from, int to) {
		tmp.add(from);
		tmp.add(to);
	}

}
