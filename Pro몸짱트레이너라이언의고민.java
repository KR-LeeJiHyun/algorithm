import java.util.ArrayList;
import java.util.HashSet;

public class Pro몸짱트레이너라이언의고민 {

	public static void main(String[] args) {
		
		Pro몸짱트레이너라이언의고민 S = new Pro몸짱트레이너라이언의고민();
		for(int n = 3; n <= 10; ++n) {
			for(int max = 3; max <= n*n / 2; ++max) {
				int minwoo = S.solution2(n, max);
				int jh = S.solution(n, max);
				if(jh != minwoo) {
					System.out.println("=====================================");
					System.out.print("문제 조건 판크기 :" );
					System.out.print(n);
					System.out.print("사람수 : " );
					System.out.println(max);
					System.out.println("민우 풀이 답");
					System.out.println(minwoo);
					System.out.println("지현 풀이 답");
					System.out.println(jh);
					System.out.println("=====================================");
				}
			}
		}
		System.out.println("끝!!!!");
		
	}
	
	class Pos {
		int row;
		int col;
		
		Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	
    public int solution(int n, int maxCustomers) {   
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
	
	 class Point {
	        int row;
	        int col;

	        public Point(int row, int col) {
	            this.row = row;
	            this.col = col;
	        }
	    }

	    public int solution2(int n, int max) {
	        int answer = 1;
	        for (int distance = (n - 1) * 2; distance > 1; --distance) {
	            HashSet<Point> set = new HashSet<>();
	            if (dfs(set, max, n, distance)) {
	                answer = distance;
	                break;
	            }
	        }

	        return answer;
	    }

	    public boolean dfs(HashSet<Point> set, int count, int n, int targetDistance) {
	        if (count == 0) {
	            return true;
	        }

	        for (int row = 0; row < n; ++row) {
	            for (int col = 0; col < n; ++col) {
	                boolean pass = true;
	                for (Point prev : set) {
	                    int distance = Math.abs(row - prev.row) + Math.abs(col - prev.col);
	                    if (distance < targetDistance) {
	                        pass = false;
	                        break;
	                    }
	                }

	                if (pass) {
	                    Point p = new Point(row, col);
	                    set.add(p);
	                    if (dfs(set, count - 1, n, targetDistance)) {
	                        return true;
	                    }

	                    set.remove(p);
	                }
	            }
	        }

	        return false;
	    }



}
