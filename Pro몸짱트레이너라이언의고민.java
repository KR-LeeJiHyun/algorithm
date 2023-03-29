import java.util.ArrayList;

public class Pro몸짱트레이너라이언의고민 {

	public static void main(String[] args) {
		int n = 4;
		int m = 5;
		int[][] timetable = {{1140,1200},{1150,1200},{1100,1200},{1210,1300},{1220,1280}};
		
		Pro몸짱트레이너라이언의고민 S = new Pro몸짱트레이너라이언의고민();
		S.solution(n, m, timetable);
	}
	
	class Pos {
		int row;
		int col;
		
		Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	
    public int solution(int n, int m, int[][] timetable) {
        int maxCustomers = 0;
        final int start = 600;
        int[] customers = new int[720];
        for(int idx = 0; idx < m; ++idx) {
        	for(int time = timetable[idx][0]; time <= timetable[idx][1]; ++time) {
        		++customers[time - start];
        		maxCustomers = Math.max(maxCustomers, customers[time - start]);
        	}
        }
        
        final int MAX = 2 * (n - 1);
        if(maxCustomers == 1) {
        	return 0;
        }
        else if(maxCustomers == 2) {
        	return MAX;
        }
        
        for(int dis = MAX - 1; dis > 0; --dis) {
        	for(int sRow = 0; sRow < n; ++sRow) {
        		for(int sCol = 0; sCol < n; ++sCol) {
        			ArrayList<Pos> map = new ArrayList<>();
        			map.add(new Pos(sRow, sCol));
        			for(int nRow = 0; nRow < n; ++nRow) {
        				for(int nCol = 0; nCol < n; ++nCol) {
        					Pos next = new Pos(nRow, nCol);
        					if(isPossible(map, next, dis)) {
        						map.add(next);
        						if(map.size() == maxCustomers) {
        							return dis;
        						}
        					}
        				}
        			}
        		}
        	}
        }
        return 1;
    }


	private boolean isPossible(ArrayList<Pos> map, Pos next, int dis) {
		for(Pos p : map) {
			if(calcDis(p, next) < dis) {
				return false;
			} 
		}
		return true;
	}


	private int calcDis(Pos p, Pos next) {
		return Math.abs(p.row - next.row) + Math.abs(p.col - next.col);
	}



}
