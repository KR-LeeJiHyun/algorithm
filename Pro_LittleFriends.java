import java.util.ArrayList;
import java.util.TreeMap;

public class Pro_LittleFriends {
	
	static char BLANK = '.', BLOCK = '*';
	static String IMPOSSIBLE = "IMPOSSIBLE";
	
	public static boolean up_check(int start_row, int start_col, int dest_row, int dest_col, String[] board, char tile) {
		boolean result = true;
		int dist = dest_col - start_col;
		
		for(int row = start_row - 1; row >= dest_row; --row) {
			if(board[row].charAt(start_col) != BLANK && board[row].charAt(start_col) != tile) return false;
		}
		
		if(dist >= 0) result = right_check(start_row, start_col, dest_row, dest_col, board);
		else result = left_check(start_row, start_col, dest_row, dest_col, board);
		
		return result;
	}
	
	public static boolean down_check(int start_row, int start_col, int dest_row, int dest_col, String[] board, char tile) {
		boolean result = true;
		int dist = dest_col - start_col;
		
		for(int row = start_row + 1; row <= dest_row; ++row) {
			if(board[row].charAt(start_col) != BLANK && board[row].charAt(start_col) != tile) return false;
		}
		
		if(dist >= 0) result = right_check(start_row, start_col, dest_row, dest_col, board);
		else result = left_check(start_row, start_col, dest_row, dest_col, board);
		
		return result;
	}
	
	public static boolean left_check(int start_row, int start_col, int dest_row, int dest_col, String[] board) {
		boolean result = true;
		
		for(int col = start_col - 1; col > dest_col; --col) {
			if(board[dest_row].charAt(col) != BLANK) return false;
		}
		
		return result;
	}
	
	public static boolean right_check(int start_row, int start_col, int dest_row, int dest_col, String[] board) {
		boolean result = true;
		
		for(int col = start_col + 1; col < dest_col; ++col) {
			if(board[dest_row].charAt(col) != BLANK) return false;
		}
		
		return result;
	}
	
    public static String solution(int m, int n, String[] board) {
        String answer = "";
        
        //���ĺ������� �����ϱ� ���Ͽ� HashMap��� TreeMap ���
        TreeMap<Character, ArrayList<Integer>> hash = new TreeMap<>();
        //TreeMap���ٰ� Ÿ���߰�
        for(int row = 0; row < m; ++row) {
        	for(int col = 0; col < n; ++col) {
        		char c = board[row].charAt(col);
        		if(c >= 'A' && c <= 'Z') {
        			if(!hash.containsKey(c)) hash.put(c, new ArrayList<>());
        			hash.get(c).add(row);
        			hash.get(c).add(col);
        		}
        	}
        }
        
        //TreepMap��� Ÿ���� �迭�� ��ȯ�Ͽ� keys�� �߰�
        ArrayList<Character> keys = new ArrayList<>();
        for(char tmp : hash.keySet()) keys.add(tmp);
        
        //key���迭�� ���鼭 ���Ű������� Ȯ��
        while(!keys.isEmpty()) {
        	String tmp_answer = "";
        	for(char tmp : keys) {
        		ArrayList<Integer> idx = hash.get(tmp);
        		int f_row = idx.get(0), f_col = idx.get(1), s_row = idx.get(2), s_col = idx.get(3);
        		if(down_check(f_row, f_col, s_row, s_col, board, tmp)) {
        			//������ �� ���� �ش� Ÿ���� ��ĭ���� ��ȯ
        			board[f_row] = board[f_row].replace(tmp, BLANK);
        			board[s_row] = board[s_row].replace(tmp, BLANK);
        			keys.remove(keys.indexOf(tmp));
        			tmp_answer += tmp;
        			break;//���� �Ϸ� �� ó������ Ȯ��
        		}
        		else if(up_check(s_row, s_col, f_row, f_col, board, tmp)) {
        			//������ �� ���� �ش� Ÿ���� ��ĭ���� ��ȯ
        			board[f_row] = board[f_row].replace(tmp, BLANK);
        			board[s_row] = board[s_row].replace(tmp, BLANK);
        			keys.remove(keys.indexOf(tmp));
        			tmp_answer += tmp;
        			break;//���� �Ϸ� �� ó������ Ȯ��
        		}
        	}
        	if(tmp_answer.isEmpty()) return IMPOSSIBLE;
        	answer += tmp_answer;
        }
        
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 4, n = 4;
		String[] board = {"A..C", "..CB", "B...", "...A"};
		/*int m = 3, n = 3;
		String[] board = {"DBA", "C*A", "CDB"};*/
		System.out.print(solution(m, n, board));
	}

}
