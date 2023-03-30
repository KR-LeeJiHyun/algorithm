import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Pro캠핑 {

	public static void main(String[] args) {
		int n = 4;
		int[][] data = {{0, 0}, {1, 1}, {0, 2}, {2, 0}};
		Pro캠핑 S = new Pro캠핑();
		S.solution(n, data);
	}
	
    public int solution(int n, int[][] data) {
        int answer = 0;
        final int LEN = data.length;
        Arrays.sort(data, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return o1[0] - o2[0];
        	}
		});
        
        for(int idx = 0; idx < LEN - 1; ++idx) {
        	for(int sIdx = idx + 1; sIdx < LEN; ++sIdx) {
        		if(data[idx][0] == data[sIdx][0] || data[idx][1] == data[sIdx][1]) {
        			continue;
        		}
        		int minX = Math.min(data[idx][0], data[sIdx][0]);
        		int maxX = Math.max(data[idx][0], data[sIdx][0]);
        		int minY = Math.min(data[idx][1], data[sIdx][1]);
        		int maxY = Math.max(data[idx][1], data[sIdx][1]);
        		boolean flag = true;
        		for(int tIdx = idx + 1; tIdx < sIdx; ++tIdx) {
                    int x = data[tIdx][0];
                    int y = data[tIdx][1];
                    if(minX != x && minY < y && x != maxX && y < maxY) {
                        flag = false;
                        break;
                    }
        		}
        		if(flag) {
        			++answer;
        		}
        	}
        }
        
        return answer;
    }
    
    public int solution2(int n, int[][] data) {
        int answer = 0;
        final int LEN = data.length;
        int[][] S = new int[n][n];
        
        HashSet<Integer> xList = new HashSet();
        HashSet<Integer> yList = new HashSet();
        
        for(int idx = 0; idx < LEN; ++idx) {
        	xList.add(data[idx][0]);
        	yList.add(data[idx][1]);
        }
        
        ArrayList<Integer> uniqueXList =new ArrayList(xList);
        ArrayList<Integer> uniqueYList =new ArrayList(yList);
        
        Collections.sort(uniqueXList);
        Collections.sort(uniqueYList);
        
        for(int idx = 0; idx < LEN; ++idx) {
        	int x = uniqueXList.indexOf(data[idx][0]);
        	int y = uniqueYList.indexOf(data[idx][1]);
        	
        	data[idx][0] = x;
        	data[idx][1] = y;
        	S[x][y] = 1;
        }
        
        for(int idx = 0; idx < LEN; ++idx) {
        	for(int sIdx = 0; sIdx < LEN; ++sIdx) {
        		S[idx][sIdx] += (idx - 1 >= 0 ? S[idx - 1][sIdx] : 0) + (sIdx - 1 >= 0 ? S[idx][sIdx - 1] : 0) - (idx - 1 >= 0 && sIdx - 1 >= 0 ? S[idx - 1][sIdx - 1] : 0);
        	}
        }
        
        for(int idx = 0; idx < LEN - 1; ++idx) {
        	for(int sIdx = idx + 1; sIdx < LEN; ++sIdx) {
        		if(data[idx][0] == data[sIdx][0] || data[idx][1] == data[sIdx][1]) {
        			continue;
        		}
        		
        		int minX = Math.min(data[idx][0], data[sIdx][0]);
        		int maxX = Math.max(data[idx][0], data[sIdx][0]);
        		int minY = Math.min(data[idx][1], data[sIdx][1]);
        		int maxY = Math.max(data[idx][1], data[sIdx][1]);
        		int cnt;
        		if(minX + 1 > maxX -1 || minY + 1 > maxY - 1) {
        			cnt = 0;
        		}
        		else {
        			cnt = S[maxX - 1][maxY - 1] - S[maxX - 1][minY] - S[minX][maxY - 1] + S[minX][minY];
        		}
        		if(cnt == 0) {
        			++answer;
        		}
        	}
        }
        
        return answer;
    }
}
