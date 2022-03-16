import java.util.ArrayList;

public class Pro_PillarAndBeam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[][] build_frame = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}, {1, 0, 0, 1}, {0, 1, 1, 0}, {1, 1, 0, 1}};
		solution(n, build_frame);
	}
	
	final static int PILLAR = 0, BEAM = 1, DEL = 0, BUILD = 1;
	
    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {}, map = new int[n + 1][n + 1];
        
        
        for(int[] frame : build_frame) {
        	int x = frame[0], y = frame[1], category = frame[2], use = frame[3];
        	if(use == BUILD) {
        		build(x, y, category, map);
        	}
        	else {
        		del(x, y, category, map);
        	}
        }
        ArrayList<ArrayList<Integer>> tmp = new ArrayList<>();
        for(int x = 0; x <= n; ++x) {
        	for(int y = 0; y <= n; ++y) {
        		ArrayList<Integer> a = new ArrayList<>();
        		if((map[x][y] & (1 << PILLAR)) != 0) {
        			a.add(x);
        			a.add(y);
        			a.add(PILLAR);
        			tmp.add(a);
        		}
        		ArrayList<Integer> b = new ArrayList<>();
        		if((map[x][y] & (1 << BEAM)) != 0) {
        			b.add(x);
        			b.add(y);
        			b.add(BEAM);
        			tmp.add(b);
        		}
        	}
        }
        answer = new int[tmp.size()][3];
        for(int idx = 0; idx < tmp.size(); ++idx) {
        	answer[idx][0] = tmp.get(idx).get(0);
        	answer[idx][1] = tmp.get(idx).get(1);
        	answer[idx][2] = tmp.get(idx).get(2);
        }
        
        return answer;
    }

	/*private static void del(int x, int y, int category, int[][] map) {
		map[x][y] -= (1 << category);
	    int n = map.length - 1;
        for(int w = 0; w <= n; ++w) {
        	for(int h = 0; h <= n; ++h) {
        		if((map[w][h] & 1 << PILLAR) != 0 && !bcheck_pillar(w, h, map)) {
        			map[x][y] += (1 << category);
        			return;
        		}
        		if((map[w][h] & 1 << BEAM) != 0 && !bcheck_beam(w, h, map)) {
        			map[x][y] += (1 << category);
        			return;
        		}
        	}
        }
	}*/
    
    private static void del(int x, int y, int category, int[][] map) {
		map[x][y] -= (1 << category);
	    int n = map.length - 1;
	    if(category == PILLAR && !dcheck_pillar(x, y, map)) map[x][y] += (1 << category);
	    else if(category == BEAM && !dcheck_beam(x, y, map)) map[x][y] += (1 << category);
	}

	private static boolean dcheck_beam(int x, int y, int[][] map) {
		//¿ÞÂÊ º¸
		if(x != 0 && (map[x - 1][y] & 1 << BEAM) != 0 && !bcheck_beam(x - 1, y, map)) return false;
		//¿À¸¥ÂÊ º¸
		if(x != map.length - 1 && (map[x + 1][y] & 1 << BEAM) != 0 && !bcheck_beam(x + 1, y, map)) return false;
		//ÀÚ±â ±âµÕ
		if((map[x + 1][y] & 1 << PILLAR) != 0 && !bcheck_pillar(x, y, map)) return false;
		//¿À¸¥ÂÊ ±âµÕ
		if(x != 0 && (map[x - 1][y] & 1 << PILLAR) != 0 && !bcheck_pillar(x - 1, y, map)) return false;
		
		return true;
	}

	private static boolean dcheck_pillar(int x, int y, int[][] map) {
		//À§ÂÊ º¸
		if(y != map.length - 1 && (map[x][y + 1] & 1 << BEAM) != 0 && !bcheck_beam(x, y + 1, map)) return false; 
		//À§¿ÞÂÊ º¸
		if(x != 0 && y != map.length - 1 && (map[x - 1][y + 1] & 1 << BEAM) != 0 && !bcheck_beam(x - 1, y + 1, map)) return false;
		//À§ ±âµÕ
		if(y != map.length - 1 && (map[x][y + 1] & 1 << PILLAR) != 0 && !bcheck_pillar(x, y + 1, map)) return false;
		return true;
	}

	private static void build(int x, int y, int category, int[][] map) {
		if(category == PILLAR && bcheck_pillar(x, y, map)) map[x][y] += (1 << category);
		else if(category == BEAM && bcheck_beam(x, y, map)) map[x][y] += (1 << category);
	}

	private static boolean bcheck_beam(int x, int y, int[][] map) {
		//¾ç¿· º¸
		if(x != 0 && x != map.length - 1 && (map[x - 1][y] & (1 << BEAM)) != 0 && (map[x + 1][y] & (1 << BEAM)) != 0) return true;
		//¾Æ·¡ ±âµÕ
		if(y != 0 && (map[x][y - 1] & (1 << PILLAR)) != 0) return true;
		//¾Æ·¡ ¿À¸¥ÂÊ ±âµÕ 
		if(y != 0 && x != map.length - 1 && (map[x + 1][y - 1] & (1 << PILLAR)) != 0) return true;
		
		return false;
	}

	private static boolean bcheck_pillar(int x, int y, int[][] map) {
		//¹Ù´Ú
		if(y == 0) return true;
		//¹Ø¿¡ ±âµÕ
		if((map[x][y - 1] & (1 << PILLAR)) != 0) return true;
		//¿ÞÂÊ º¸
		if(x != 0 && (map[x - 1][y] & (1 << BEAM)) != 0) return true;
		//ÀÚ±â º¸
		if((map[x][y] & (1 << BEAM)) != 0) return true;
		
		return false;
	}
}
