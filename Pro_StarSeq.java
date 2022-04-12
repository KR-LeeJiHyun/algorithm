import java.util.ArrayList;
import java.util.HashMap;

public class Pro_StarSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0, 2, 3, 2, 3, 0, 1, 0, 1, 0, 1};		
		
		System.out.print(solution(a));
	}
	
    public static int solution(int[] a) {
        int answer = 0;
        if(a.length < 2) return answer;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int len = a.length;
        for(int idx = 0; idx < len; ++idx) {
        	int num = a[idx];
        	if(!map.containsKey(num)) map.put(num, new ArrayList<>());
        	map.get(num).add(idx);
        }
        
        for(int key : map.keySet()) {
        	ArrayList<Integer> list = map.get(key);
        	if(list.size() <= answer / 2) continue;
        	
        	boolean[] visited = new boolean[len];
        	int cnt = 0;
        	
        	for(int idx = 0; idx < list.size(); ++idx) {
        		int cIdx = list.get(idx);
        		if(cIdx != 0 && cIdx != len - 1) {
        			if(!visited[cIdx - 1] && a[cIdx] != a[cIdx - 1]) {
        				visited[cIdx] = true;
        				visited[cIdx - 1] = true;
        				++cnt;
        			}
        			else if(!visited[cIdx + 1] && a[cIdx] != a[cIdx + 1]) {
        				visited[cIdx] = true;
        				visited[cIdx + 1] = true;
        				++cnt;
        			}
        		}
        		else {
        			if(cIdx == len - 1 && !visited[cIdx - 1] && a[cIdx] != a[cIdx - 1]) {
        				visited[cIdx] = true;
        				visited[cIdx - 1] = true;
        				++cnt;
        			}
        			else if(cIdx == 0 && !visited[cIdx + 1] && a[cIdx] != a[cIdx + 1]) {
        				visited[cIdx] = true;
        				visited[cIdx + 1] = true;
        				++cnt;
        			}
        		}
        	}
        	answer = Math.max(answer, cnt * 2);
        }
        
        
        return answer;
    }

}
