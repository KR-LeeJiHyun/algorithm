import java.util.ArrayList;
import java.util.HashMap;

public class Pro_MeetStar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
		solution(line);
	}

    public static String[] solution(int[][] line) {
        String[] answer = {};
        HashMap<Long, ArrayList<Long>> map = new HashMap<>();
        long maxX = Long.MIN_VALUE, minX = Long.MAX_VALUE, maxY = Long.MIN_VALUE, minY = Long.MAX_VALUE; 
        for(int idx = 0; idx < line.length - 1; ++idx) {
        	long A = line[idx][0], B = line[idx][1], E = line[idx][2];
        	for(int sIdx = idx + 1; sIdx < line.length; ++sIdx) {
        		long C = line[sIdx][0], D = line[sIdx][1], F = line[sIdx][2];
        		long tmp = A*D - B*C;
        		if(tmp != 0) {
        			long x = (B*F - E*D), y = (E*C - A*F);
        			if(x % tmp == 0 && y % tmp == 0) {
        				x /= tmp;
        				y /= tmp;
        				if(!map.containsKey(y)) map.put(y, new ArrayList<Long>());
        				ArrayList<Long> list = map.get(y);
        				if(!list.contains(x)) map.get(y).add(x);
        				maxX = Math.max(maxX, x);
        				minX = Math.min(minX, x);
        				maxY = Math.max(maxY, y);
        				minY = Math.min(minY, y);
        			}
        		}
        	}
        }
        
        if(map.size() != 0) {
        	long yLen = (maxY - minY + 1), xLen = (maxX - minX + 1);
        	answer = new String[(int)yLen];
        	int idx = 0;
        	for(long y = maxY; y >= minY; --y) {
        		StringBuilder sb = new StringBuilder();
        		for(int x = 0; x < xLen; ++x) {
        			sb.append('.');
        		}
        		if(map.containsKey(y)) {
        			for(long x : map.get(y)) {
        				sb.setCharAt((int) (x - minX), '*');
        			}
        		}

        		answer[idx++] = sb.toString();
        	}
        }
        return answer;
    }
}
