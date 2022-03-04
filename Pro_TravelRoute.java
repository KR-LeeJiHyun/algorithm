import java.util.Arrays;
import java.util.Comparator;

public class Pro_TravelRoute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		solution(tickets);
	}
	
	static String tmpAnswer = "z";
	
    public static String[] solution(String[][] tickets) {
    	int len = tickets.length;
        String[] answer = new String[len + 1];
        boolean[] visited = new boolean[len];
        Arrays.sort(tickets, new Comparator<String[]>() {
        	@Override
        	public int compare(String[] o1, String[] o2) {
        		return o1[1].compareTo(o2[1]);
        	}
		});
        
        String path = "ICN";
        dfs("ICN", visited, tickets, path, len);
        
        for(int idx = 0; idx < len + 1; ++idx) {
        	answer[idx] = tmpAnswer.substring(idx * 3, idx * 3 + 3);
        }
        
        return answer;
    }
    
    public static void dfs(String start, boolean[] visited, String[][] tickets, String path, int len) {
    	if(path.length() == (len + 1) * 3) {
    		tmpAnswer = path;
    		return;
    	}
    	
    	for(int idx = 0; idx < len; ++idx) {
    		if(tmpAnswer.compareTo("z") != 0) return;
    		if(!visited[idx] && tickets[idx][0].compareTo(start) == 0) {
    			visited[idx] = true;
    			dfs(tickets[idx][1], visited, tickets, path + tickets[idx][1], len);
                visited[idx] = false;
    		}
    	}
    }

}
