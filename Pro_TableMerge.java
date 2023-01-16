import java.util.ArrayList;
import java.util.StringTokenizer;

public class Pro_TableMerge {

	public static void main(String[] args) {
		
		String[] commands =  { 
				"UPDATE 1 1 menu", "UPDATE 1 2 category",
				"UPDATE 2 1 bibimbap", "UPDATE 2 2 korean",
				"UPDATE 2 3 rice", "UPDATE 3 1 ramyeon",
				"UPDATE 3 2 korean", "UPDATE 3 3 noodle",
				"UPDATE 3 4 instant", "UPDATE 4 1 pasta",
				"UPDATE 4 2 italian", "UPDATE 4 3 noodle",
				"MERGE 1 2 1 3", "MERGE 1 3 1 4",
				"UPDATE korean hansik", "UPDATE 1 3 group",
				"UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4" 
		};
		
		Pro_TableMerge PTM = new Pro_TableMerge();
		
		String[] answer = PTM.solution(commands);
		for(int idx = 0; idx < answer.length; ++idx) {
			System.out.println(answer[idx]);
		}
		
	}
	
	final int SIZE = 51;
	String[][] table = new String[SIZE][SIZE];
	boolean[][][][] link = new boolean[SIZE][SIZE][SIZE][SIZE]; 
	
    public String[] solution(String[] commands) {
        String[] answer = {};
        ArrayList<String> tmp = new ArrayList<>();
        
        for(int row = 1; row < SIZE; ++row) {
			for(int col = 1; col < SIZE; ++col) { 
				table[row][col] = "";
			}
		}
        
        for(int idx = 0; idx < commands.length; ++idx) {
        	StringTokenizer st = new StringTokenizer(commands[idx]);
        	String command = st.nextToken();
        	
        	if(command.compareTo("UPDATE") == 0 ) {
        		if(st.countTokens() == 3) {
        			int r = Integer.parseInt(st.nextToken());
            		int c = Integer.parseInt(st.nextToken());
            		String value = st.nextToken();
            		UPDATE(r, c, value);
        		}
        		else {
            		String value1 = st.nextToken();
            		String value2 = st.nextToken();
            		UPDATE(value1, value2);
        		}
        	}
        	
        	else if(command.compareTo("MERGE") == 0) {
        		int r1 = Integer.parseInt(st.nextToken());
        		int c1 = Integer.parseInt(st.nextToken());
        		int r2 = Integer.parseInt(st.nextToken());
        		int c2 = Integer.parseInt(st.nextToken());
        		if(table[r1][c1].compareTo("") != 0)  UPDATE(r2, c2, table[r1][c1]);
        		else if(table[r2][c2].compareTo("") != 0) UPDATE(r1, c1, table[r2][c2]);
        		MERGE(r1, c1, r2, c2);
        	}
        	
        	else if(command.compareTo("UNMERGE") == 0) {
    			int r = Integer.parseInt(st.nextToken());
        		int c = Integer.parseInt(st.nextToken());
        		String prev = table[r][c];
        		UPDATE(r, c, "");
        		UNMERGE(r, c);
        		table[r][c] = prev;
        	}
        	
        	else {
        		int r = Integer.parseInt(st.nextToken());
        		int c = Integer.parseInt(st.nextToken());
        		if(table[r][c].compareTo("") == 0) tmp.add("EMPTY");
        		else tmp.add(table[r][c]);
        	}
        }
        
        int len = tmp.size();
        answer = new String[len];
        for(int idx = 0; idx < len; ++idx) {
        	answer[idx] = tmp.get(idx);
        }
        
        return answer;
    }

	private void UNMERGE(int r, int c) {
		
		ArrayList<Integer> lr = new ArrayList<>();
		ArrayList<Integer> lc = new ArrayList<>();
		lr.add(r);
		lc.add(c);
		for(int row = 1; row < SIZE; ++row) {
			for(int col = 1; col < SIZE; ++col) {
				if(link[r][c][row][col]) {
					lr.add(row);
					lc.add(col);
				}
			}
		}
		
		int len = lr.size();
		for(int idx = 0; idx < len - 1; ++idx) {
			int nr1 = lr.get(idx);
			int nc1 = lc.get(idx);
			for(int sIdx = idx + 1; sIdx < len; ++sIdx) {
				int nr2 = lr.get(sIdx);
				int nc2 = lc.get(sIdx);
				link[nr1][nc1][nr2][nc2] = false;
				link[nr2][nc2][nr1][nc1] = false;
			}
		}
		
	}

	private void MERGE(int r1, int c1, int r2, int c2) {
		
		if(link[r1][c1][r2][c2]) return;
		
		ArrayList<Integer> lr1 = new ArrayList<>();
		ArrayList<Integer> lc1 = new ArrayList<>();
		ArrayList<Integer> lr2 = new ArrayList<>();
		ArrayList<Integer> lc2 = new ArrayList<>();
		
		lr1.add(r1);
		lc1.add(c1);
		lr2.add(r2);
		lc2.add(c2);
		for(int row = 1; row < SIZE; ++row) {
			for(int col = 1; col < SIZE; ++col) {
				if(link[row][col][r1][c1]) {
					lr1.add(row);
					lc1.add(col);
				}
				else if(link[row][col][r2][c2] && !link[r1][c1][row][col]) {
					lr2.add(row);
					lc2.add(col);
				}
			}
		}
		
		for(int idx = 0; idx < lr1.size(); ++idx) {
			int nr1 = lr1.get(idx);
			int nc1 = lc1.get(idx);
			for(int sIdx = 0; sIdx < lr2.size(); ++sIdx) {
				int nr2 = lr2.get(sIdx);
				int nc2 = lc2.get(sIdx);
				link[nr2][nc2][nr1][nc1] = true;
				link[nr1][nc1][nr2][nc2] = true;
			}
		}
		
	}

	private void UPDATE(String value1, String value2) {
		
		for(int row = 1; row < SIZE; ++row) {
			for(int col = 1; col < SIZE; ++col) {
				if(table[row][col].compareTo(value1) == 0) table[row][col] = value2;
			}
		}
		
	}

	private void UPDATE(int r, int c, String value) {
		
		table[r][c] = value;
		for(int row = 1; row < SIZE; ++row) {
			for(int col = 1; col < SIZE; ++col) {
				if(link[row][col][r][c]) table[row][col] = value;
			}
		}
		
	}

}
